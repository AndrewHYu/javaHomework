package test8;
import java.sql.*;
public class InsertRecord {
    public static void main(String[] args) {
        String JDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String conURL = "jdbc:odbc:DBTest";
        
try {
            Class.forName(JDriver);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("ForName :" + e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(conURL);
            Statement stat = con.createStatement();
            String r1 = "insert into student values(" + "'20050705','张丽','男','1986-9-1','一班','软件',88)";
            String r2 = "insert into student values(" + "'20050706','马亮','男','1986-10-1','二班','应用',92)";
            String r3 = "insert into student values(" + "'20050707','刘凯','女','1986-11-1','三班','安全',87)";
            //使用SQL 命令insert into插入三条学生记录到表中
            stat.executeUpdate(r1);
            stat.executeUpdate(r2);
            stat.executeUpdate(r3);
            ResultSet rs = stat.executeQuery("SELECT * FROM student");
            System.out.println("插入记录后，查询结果为：");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
