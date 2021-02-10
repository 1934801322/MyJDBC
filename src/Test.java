import java.sql.*;
public class Test {
    private static Connection getConn() {
        //导入驱动包
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://121.4.118.195:3306/WanQuanZhuang?useSSL=false";
        String username = "root";
        String password = "pwd@123";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            //链接至数据库
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; //将连接对象抛出去
    }
    public static void JdbcSelect (String sql){

        try {
           Connection conn= getConn(); //获取连接jdbc对象
            Statement state = conn.createStatement(); //容器
//            String sql = "select * from U_USER";  //sql语句
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
    public static int  JdbcInset(String sql ) throws Exception{
        Connection conn =getConn();
        int i =0;
        PreparedStatement pstmt;
        pstmt = conn.prepareStatement(sql);
        i = pstmt.executeUpdate();
//        pstmt.setString(1,);
        conn.close();
        pstmt.close();
        return i;

    }
    public static int JdbcDelete(String sql,int uid) throws Exception{
        int i =0;
        Connection conn=getConn();
        PreparedStatement pstmt=conn.prepareStatement(sql );
        i = pstmt.executeUpdate();
        System.out.println("删除ID为: " + uid);
        pstmt.close();
        conn.close();
        return i;
    }
//    public static int JdbcUpdate (Dao dao) throws Exception{
    public static int JdbcUpdate (String sql) throws Exception{

//        Dao dao=new Dao();
        int i = 0;
        Connection conn = getConn();
        PreparedStatement pstmt;
//        String sql = "update U_USER set AGE='"+dao.getAge() +"'where UID=' "+ dao.getUid()+ "'";
        pstmt = conn.prepareStatement(sql);
        i= pstmt.executeUpdate();
        conn.close();
        pstmt.close();
        return i;
    }
    public static void main(String[] args) throws Exception {
//        JdbcInset("INSERT INTO U_USER VALUES (NULL,'ROOT1',1234)");
//        JdbcDelete("DELETE FROM U_USER WHERE UID=8",8);
        JdbcUpdate("UPDATE U_USER SET AGE=1111 WHERE UID=1;\n");
        JdbcSelect("select * from U_USER");



   }

}
