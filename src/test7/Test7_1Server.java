package test7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew on 2016/6/13.
 */
public class Test7_1Server {

    private static ServerSocket serverSocket;
    //若要实现更复杂功能可考虑map或者封装po
    protected static ArrayList<Socket> sockets=new ArrayList<>();


    public static void main(String[] args) throws IOException {
        serverSocket=new ServerSocket(9999);
        while (true){
            Socket socket=serverSocket.accept();
            System.out.println("连接到一个客户端");
            BuildThread onePerson=new BuildThread(socket);
            onePerson.start();
        }

    }
    //用户登录处理并返回状态
    public static void login(Socket socket)throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Map<String,String> result=handleInfo(bufferedReader);
        if(result.get("userName").equals("admin")&&result.get("password").equals("admin")){
            //进入聊天室
            bufferedWriter.write("status:1"+"\r\n");
            bufferedWriter.flush();
            while (true){
                try {
                    chat(socket);
                }catch (IOException e){
                    socket.close();
                    System.out.println("客户端关闭");
                    break;
                }
            }
        }else if (!result.get("userName").equals("admin")){
            System.out.println("用户名错误");
            bufferedWriter.write("status:用户名错误"+"\r\n");
            bufferedWriter.flush();
        }else if (!result.get("password").equals("admin")){
            System.out.println("密码错误");
            bufferedWriter.write("status:密码错误"+"\r\n");
            bufferedWriter.flush();
        }else {
            System.out.println("不可知错误");
            bufferedWriter.write("status:不可知错误"+"\r\n");
            bufferedWriter.flush();
        }

    }
    //处理请求信息
    public static Map<String,String> handleInfo(BufferedReader bufferedReader)throws IOException,SocketException {
        System.out.println("处理消息");
        Map<String,String> result=new HashMap();
        String completeInfo=bufferedReader.readLine();
        System.out.println(completeInfo);
        String[] temps=completeInfo.split(",");
        for (String tem:temps) {
            String[] pieces=tem.split(":");
            result.put(pieces[0],pieces[1]);
        }
        return result;
    }
    //接收客户端发送的信息并转发给所有人
    public static void  chat(Socket socket)throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //接收信息
        Map<String,String>info=handleInfo(bufferedReader);
        //发送消息
        if (!info.isEmpty())
        for (Socket aSocket:sockets
             ) {
            System.out.println("---------socket是否关闭："+aSocket.isClosed());
            if(!aSocket.isClosed()) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(aSocket.getOutputStream()));
                bufferedWriter.write(info.get("message") + "\r\n");
                bufferedWriter.flush();
            }
        }
    }
}
class BuildThread extends Thread{
    private Socket socket;
    BuildThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        Test7_1Server.sockets.add(socket);
        try {
            Test7_1Server.login(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("回收一个线程");
    }
}
