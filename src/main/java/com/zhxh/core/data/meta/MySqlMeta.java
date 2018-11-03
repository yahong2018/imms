package com.zhxh.core.data.meta;

import com.zhxh.core.data.EntitySqlMeta;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class MySqlMeta extends EntitySqlMeta {
    @Override
    public String getSelectByPageSql(Map listMap, boolean isCount) {
        /*
        select count(*) from (
            select 1 as temp_field
            from system_user
            where user_id=1
            order by user_id desc
            limit 10,30
        ) cnt_table

        select user_id,user_name,password,email
        from system_user
        where user_id=1
        order by user_id desc
        limit 10,30

       */

        String fields;
        if (isCount) {
            fields = "1 as temp_field";
        } else {
            fields = StringUtils.join(this.getColumns().toArray(), ",");
        }
        StringBuffer buffer = new StringBuffer("select ").append(fields).append("\n")
                .append(" from ").append(this.getTableName());

        map2StringBuffer(listMap, buffer);
        buffer.append("\n limit #{start},#{limit} \n");

        if (isCount) {
            buffer.insert(0, "select count(*) from (");
            buffer.append(")cnt_table");
        }

        return buffer.toString();
    }

}
