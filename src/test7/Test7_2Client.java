package test7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * Created by Andrew on 2016/6/13.
 */
public class Test7_2Client {
    public static void main(String[]args){
        LoginView loginView=new LoginView();
    }
}
class LoginView extends JFrame implements ActionListener {
    private JTextField userName;

    private JPasswordField password;

    private JLabel firstLabel;

    private JLabel secondLabel;

    private JButton determine;

    private JButton cancel;

    LoginView(){

        //设置布局方式
        GridLayout gLayout=new GridLayout(3,2);
        this.setLayout(gLayout);
        this.setTitle("登录");

        //创建按钮和添加监听器
        determine=new JButton("确定");
        determine.addActionListener(this);
        cancel=new JButton("取消");
        cancel.addActionListener(this);

        //创建文本框
        password=new JPasswordField();
        userName=new JTextField();

        //创建label
        firstLabel=new JLabel("用户名：");
        secondLabel=new JLabel("密码：");

        //将控件加入窗体
        this.add(firstLabel);
        this.add(userName);
        this.add(secondLabel);
        this.add(password);
        this.add(determine);
        this.add(cancel);

        //设置窗口属性
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
        int width=Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(width/2, height/2);
        this.setSize(350, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(determine)) {
            beforeChat(handleLoginForm());
        }else if (e.getSource().equals(cancel)) {
            JOptionPane.showMessageDialog(null,"取消登录");
            this.dispose();
        }
    }
    public String handleLoginForm(){
        String data="userName:"+userName.getText()+",password:"+String.valueOf(password.getPassword())+"\r\n";
        return data;
    }
    public void beforeChat(String data){
        try {
            Socket socket=new Socket("127.0.0.1",9999);
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter.write(data);
            bufferedWriter.flush();
            System.out.println(data);
            while (true){
                int i=0;
                String responseData="";
                if((responseData=bufferedReader.readLine())!=null){
                    System.out.println(responseData);
                    String []datas=responseData.split(":");
                    if(datas[1].equals("1")){
                        ChatView chatView=new ChatView(socket);
                        this.dispose();
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null,datas[1]);
                        break;
                    }
                }
                i++;
                if (i<0) {
                    JOptionPane.showMessageDialog(null, "连接超时");
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
class ChatView extends JFrame implements ActionListener
{

    private JScrollPane jScrollPane;
    private JTextArea content;
    private  JTextField message;
    private JButton send;
    private JPanel panel;
    private Socket socket;

    ChatView(Socket socket){
        this.socket=socket;
        content=new JTextArea();
        jScrollPane=new JScrollPane(content);
        message=new JTextField();
        send=new JButton("发送");
        send.addActionListener(this);
        panel=new JPanel();
        content.setLineWrap(true);

        this.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
//        jScrollPane.setViewportView(content);

//        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(message,BorderLayout.CENTER);
        panel.add(send,BorderLayout.EAST);

        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(panel,BorderLayout.SOUTH);

        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
        int width=Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setLocation(width/2, height/2);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //接收消息线程
        GetMessage getMessage=new GetMessage(socket,content);
        getMessage.start();
        System.out.println("构造函数执行完毕");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==send){
            try {
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write("message:"+message.getText()+"\r\n");
                bufferedWriter.flush();
//                System.out.println(System.);
                message.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
class GetMessage extends Thread{
    private Socket socket;
    private JTextArea content;
    GetMessage(Socket socket,JTextArea content){
        this.socket=socket;
        this.content=content;
    }
    @Override
    public void run() {
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message="";
            while ((message=bufferedReader.readLine())!=null){
                System.out.println(message);
                content.append(message+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}