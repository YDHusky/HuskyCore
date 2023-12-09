package org.siberianhusky.huskycore.utils.sqlite;


import org.bukkit.plugin.java.JavaPlugin;

import java.sql.*;

public class SqliteHelper {
    private Connection connection;
    private Statement statement;
    private boolean isConnect = false;
    /**
     * 构造函数
     * 连接数据库
     */
    public SqliteHelper(String dbPath, JavaPlugin plugin) {
        try {
            //加载驱动
            Class.forName("org.sqlite.JDBC");
            //连接数据库
            connection = DriverManager.getConnection(dbPath);
            //设置自动提交
            connection.setAutoCommit(true);
            //创建Statement对象
            statement = connection.createStatement();
            isConnect = true;
        } catch (ClassNotFoundException | SQLException e) {
            plugin.getLogger().warning("数据库连接失败");
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

    /**
     * 关闭数据库连接
     */
    public void close(){
        if(isConnect){
            try {
                statement.close();
                connection.close();
                isConnect= false;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 设置自动提交
     * @param autoCommit 是否自动提交
     */
    public void setAutoCommit(boolean autoCommit){
        if(isConnect){
            try {
                connection.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
