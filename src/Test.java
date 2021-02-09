import java.sql.*;
public class Test {
    public static void JdbcSelect (){
        //导入驱动包
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //链接至数据库
            String jdbc = "jdbc:mysql://121.4.118.195:3306/WanQuanZhuang?useSSL=false";
            Connection conn = DriverManager.getConnection(jdbc, "root", "pwd@123");
            Statement state = conn.createStatement(); //容器
            String sql = "select * from U_USER";  //sql语句
            ResultSet rs = state.executeQuery(sql); //将sql语句传至数据库，返回的值为一个字符集用一个变量接收
            while (rs.next()){
                System.out.print("uid="+rs.getObject("UID")+"\t");
                System.out.print("uname="+rs.getObject("UNAME")+"\t");
                System.out.println("age="+rs.getObject("age"));
            }
            //关闭连接释放资源
            state.close();
            conn.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int JdbcInset(dao dao ){
        return 0;
    }
    public static void main(String[] args) throws Exception {
        JdbcSelect();


   }

}
