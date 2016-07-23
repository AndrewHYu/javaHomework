package test8;
import java.sql.*;
public class UpdateRecord {
    public static void main(String[] args) {
        String JDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String conURL = "jdbc:odbc:DBTest";
        String[] Studentid = {"20050706", "20050707"};
        int[] score = {89, 70};
        
try {
            Class.forName(JDriver);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("ForName :" + e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(conURL);
            //修改数据库记录
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE student set score=? where id=? ");
            int i = 0, number = Studentid.length;
            do {
                ps.setInt(1, score[i]);
                ps.setString(2, Studentid[i]);
                ps.executeUpdate();  //执行SQL修改语句
                ++i;
            } while (i < number);
            ps.close();
            //查询数据库并把内容输出到屏幕上
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from student");
            while (rs.next()) {
                System.out.println(rs.getString("id") +
                        "\t" + rs.getString("name") +
                        "\t" + rs.getInt("score")+
                        "\t"+rs.getDate("birth"));
            }
            s.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
