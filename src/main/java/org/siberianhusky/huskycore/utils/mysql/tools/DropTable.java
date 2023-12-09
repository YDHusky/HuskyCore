package org.siberianhusky.huskycore.utils.mysql.tools;

import org.siberianhusky.huskycore.utils.mysql.SqlHelper;

public class DropTable {
    public static void dropTable(String tableName, SqlHelper sqlHelper) {
        String sql = "DROP TABLE IF EXISTS " + tableName;
        sqlHelper.execute(sql);
    }
}
