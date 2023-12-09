package org.siberianhusky.huskycore.utils.mysql;

import org.bukkit.plugin.java.JavaPlugin;

import java.sql.*;

public class SqlHelper {
    private Connection connection;
    private Statement statement;
    private boolean isConnect = false;


    /**
     * 创建一个mysql连接
     * @param host 主机
     * @param port 端口
     * @param database 数据库
     * @param username 用户名
     * @param password 密码
     * @param plugin 插件
     */
    public SqlHelper(String host, int port ,String database, String username, String password, JavaPlugin plugin) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host+":"+port + "/" + database + "?useSSL=false", username, password);
            connection.setAutoCommit(true);
            isConnect = true;
            statement=connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            plugin.getLogger().warning("Could not connect to MySQL database! Because: " + e.getMessage());
        }
    }
    /**
     * 设置自动提交
     * @param autoCommit 是否自动提交
     */
    public void setAutoCommit(boolean autoCommit){
        if (isConnect) {
            try {
                connection.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 执行数据库语句
     * @param sql 数据库语句
     */
    public void execute(String sql) {
        if(isConnect){
            try {
                statement.execute(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
     * 执行查找语句
     * @param sql 查找语句
     * @return 结果集
     */
    public ResultSet executeQuery(String sql) {
        if (isConnect) {
            try {
                return statement.executeQuery(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
