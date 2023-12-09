package org.siberianhusky.huskycore.utils.mysql.tools;

import org.siberianhusky.huskycore.utils.mysql.SqlHelper;

public class Update {
    public static void update(SqlHelper sqlHelper, String tableName, String key, String value, String whereKey, String whereValue) {
        String sql = "UPDATE " + tableName + " SET " + key + " = " + value + " WHERE " + whereKey + " = " + whereValue;
        sqlHelper.execute(sql);
    }
}
