package test8;
import java.sql.*;
public class ScrollResult {
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
                    Statement st = con.createStatement(    //建立滚动集
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select * from student"); //执行查询
                    rs.last();//以各种方式查看结果
            int number = rs.getRow();
            System.out.println("该表共有 " + number + " 条记录,倒序显示为");
            rs.afterLast();
            while (rs.previous())//倒序显示，从最后一条记录开始显示
            {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                String sex = rs.getString("sex");
                String major = rs.getString("major");
                System.out.print("姓名：" + name);
                System.out.print("性别：" + sex);
                System.out.print("   成绩：" + score);
                 System.out.println("   专业：" + major);
            }
            rs.absolute(2);
            System.out.println("第2条记录为：" + rs.getString(2) + rs.getString(3));
            rs.previous();
            System.out.println("第2条记录的前一条记录为："+rs.getString(2) + rs.getString(3));
            rs.first();
            System.out.println("第1条记录为：" + rs.getString(2) + rs.getString(3));
            rs.relative(2);
            System.out.println("从第1条记录开始，相对移动2条记录后：" + rs.getString(2) + rs.getString(3));
           //关闭ResultSet对象
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
