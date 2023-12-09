package org.siberianhusky.huskycore.utils.sqlite.tools;

import org.siberianhusky.huskycore.utils.sqlite.SqliteHelper;

public class Update {
    public static void update(SqliteHelper sqliteHelper,String tableName, String key, String value, String whereKey, String whereValue) {
        String sql = "UPDATE " + tableName + " SET " + key + " = " + value + " WHERE " + whereKey + " = " + whereValue;
        sqliteHelper.execute(sql);
    }
}
