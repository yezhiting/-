package com.usejdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


/**
 * 操作数据库工具类
 *
 *
 */
public class Database {

	static Connection conn = null;


    /**
     * 连接数据
     *
     * @return conn
     */
	public static void Init (){
		String url = "jdbc:mysql://localhost/test?";
		String user = "root";
		String password = "123123";
		String driver = "com.mysql.jdbc.Driver";
		//conn = getConnection(driver, url, user, password);
		try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("link success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
    public static Connection getConnection(String driver,String url,String username,String password) {
    	
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("link success!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return conn;
    }

    /**
     * 关闭连接对象
     *
     * @param conn
     *            连接对象
     * @param pstmt
     *            预编译对象
     * @param rs
     *            结果集
     */
    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 增删改操作
     *
     * @param sql
     *            SQL命令
     * @param param
     *            参数
     * @return
     * @throws SQLException 
     */
    public static int executUpdate(String sql, Object[] param) throws SQLException {
        Init();
    	int result = 0;
        PreparedStatement pstmt = null;
       
            pstmt = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            result = pstmt.executeUpdate();
            System.out.println("插入成功");
       
        return result;
    }
    /**
     * 查询
     *
     * @return int
     * 
     */
    public static ResultSet executQuery(String sql, String[] param) {
    	Init();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setString(i + 1, param[i]);
                }
            }
            result = pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return result;
    }
}
