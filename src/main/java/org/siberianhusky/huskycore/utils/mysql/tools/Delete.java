package org.siberianhusky.huskycore.utils.mysql.tools;

import org.siberianhusky.huskycore.utils.mysql.SqlHelper;
import org.siberianhusky.huskycore.utils.sqlite.SqliteHelper;

public class Delete {
    public static void delete(String tableName, String key, String value, SqlHelper sqlHelper) {
        String sql = "DELETE FROM " + tableName + " WHERE " + key + " = " + value;
        sqlHelper.execute(sql);
    }
}
