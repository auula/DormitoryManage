package me.codegc.manage.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



/**
 * Java数据访问层工具类
 * @author Ding
 *
 */
public class JDBCUtil {
	
	private String url;

    private String username;

    private String password;

    private Connection connection = null;
    
    public static final String CONFIG = "src/main/resources/jdbc.properties";

    //initialize
    public JDBCUtil(String driver, String url, String username, String password) {
        try {
            this.url = url;
            this.username = username;
            this.password = password;
            // loading class
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public JDBCUtil() {
    }

    /**
     * 初始化JDBC
     *
     * @return
     */
    public static JDBCUtil init(String path) {
        //String path = "/Users/jdode/Documents/JavaProjects/idea_work/JavaReptile/src/config/jdbc.properties";
        //获得当前类的路径，加载指定属性文件
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(path)));
            return new JDBCUtil(properties.getProperty("jdbc.driver"), properties.getProperty("jdbc.url"), properties.getProperty("jdbc.user"), properties.getProperty("jdbc.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取SQLConnection
    public Connection getConnection() {
        try {
            connection =  DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭SQLConnection
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
