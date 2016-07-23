package test8;
import java.sql.*;
public class CreateDBTable {
    public static void main(String args[]) {
        //连接Access数据库表student，数据源名字为DBTest
        String url = "jdbc:odbc:DBTest";
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
     
   try {
            //加载JDBC驱动程序
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("驱动程序已经装载!");
            System.out.println("即将连接数据库");
        } catch (Exception ex) {//如果无法加载驱动，则给出错误信息
            System.out.println("无法加载驱动程序：" + ex.getMessage());
            return;
        }
        try {
            //登录数据库的用户名是user,密码是1234
            con = DriverManager.getConnection(url, "root", "330606");
            //建立Statement类对象
            stat = con.createStatement();
            //定义一个学生表student
            String query = "create table student( " + "id char(10)," + "name char(15)," + "sex char(2)," + "birth date," + "class char(8)," + "major char(15)," + "score integer" + ")";  //创建一个含有三个字段的学生表student3
//创建该学生表student
            stat.executeUpdate(query);
//查询该表信息，开始应为空记录
            rs = stat.executeQuery("SELECT * FROM student");
            System.out.println("查询结果为：");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
            }
            rs.close();
            stat.close();//释放Statement所连接的数据库及JDBC资源
            con.close();//关闭与数据库的连接
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        }
    }
}
