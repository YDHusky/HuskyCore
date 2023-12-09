package org.siberianhusky.huskycore.utils.sqlite.tools;

import org.siberianhusky.huskycore.utils.sqlite.SqliteHelper;

public class DropTable {
    public static void dropTable(String tableName, SqliteHelper sqliteHelper) {
        String sql = "DROP TABLE IF EXISTS " + tableName;
        sqliteHelper.execute(sql);
    }
}
