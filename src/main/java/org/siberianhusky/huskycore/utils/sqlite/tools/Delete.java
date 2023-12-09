package org.siberianhusky.huskycore.utils.sqlite.tools;

import org.siberianhusky.huskycore.utils.sqlite.SqliteHelper;

public class Delete {
    public static void delete(SqliteHelper sqliteHelper, String tableName, String key, String value) {
        String sql = "DELETE FROM " + tableName + " WHERE " + key + " = " + value;
        sqliteHelper.execute(sql);
    }
}
