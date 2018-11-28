package com.zhxh.core.data;

import com.zhxh.core.data.meta.CheckUnique;
import com.zhxh.core.data.meta.TreeTableParentKey;
import com.zhxh.core.data.meta.TreeTable;
import com.zhxh.core.utils.ClassUtils;
import com.zhxh.core.utils.StringUtilsExt;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;

import java.lang.reflect.Field;
import java.util.*;

public abstract class EntitySqlMeta {
    public void buildSql() {
        this.buildInsertSql();
        this.buildDeleteSql();
        this.buildUpdateSql();
        this.buildSelectSql();
        this.buildCheckUniqueSql();

        this.initIsTreeTable();
        this.buildGetTreeRootSql();
    }

    private void buildInsertSql() {
        StringBuffer buffer = new StringBuffer("insert into ").append(tableName)
                .append(" (")
                .append(StringUtils.join(columns.toArray(), ","))
                .append(") ")
                .append("values (")
                .append(StringUtilsExt.joinWrap(properties.toArray(), ",", "#{", "}"))
                .append(")");
        this.sqlInsert = buffer.toString();
    }

    private void buildDeleteSql() {
        StringBuffer buffer = new StringBuffer("delete from ").append(tableName);
        this.sqlDeleteAll = buffer.toString();
        buffer.append(" where ").append(this.keyColumn).append("=").append(this.propertyExprs.get(this.keyProperty));

        this.sqlDeleteById = buffer.toString();
    }

    private void buildUpdateSql() {
        String fieldAssigns = StringUtils.join(fieldsAssigns.values().toArray(), ",");
        StringBuffer buffer = new StringBuffer("update ").append(tableName)
                .append(" set ").append(fieldAssigns)
                .append(" where ").append(this.keyColumn).append("=").append(this.propertyExprs.get(this.keyProperty));

        this.sqlUpdate = buffer.toString();
    }

    private void buildSelectSql() {
        StringBuffer buffer = new StringBuffer("select ")
                .append(StringUtils.join(columns.toArray(), ","))
                .append(" from ")
                .append(tableName);

        this.sqlSelect = buffer.toString();
    }

    public String getSelectSql(Map listMap) {
        StringBuffer buffer = new StringBuffer(this.sqlSelect);
        if (listMap != null) {
            map2StringBuffer(listMap, buffer);
        }

        return buffer.toString();
    }

    protected void map2StringBuffer(Map listMap, StringBuffer buffer) {
        String where = (String) listMap.get("where");
        if (StringUtils.isNotEmpty(where)) {
            buffer.append(" where ").append(where).append("\n");
        }
        String orderBy = (String) listMap.get("orderBy");
        if (StringUtils.isNotEmpty(orderBy)) {
            buffer.append(" order by ").append(orderBy).append(" ");
        }
        String sortDir = (String) listMap.get("sortDir");
        if (StringUtils.isNotEmpty(sortDir)) {
            buffer.append(sortDir);
        }
    }

    public String getDeleteByWhereSql(String where) {
        if (StringUtils.isEmpty(where)) {
            return "";
        }

        return new StringBuffer(this.sqlDeleteAll).append(" ").append(where).toString();
    }

    private void buildCheckUniqueSql() {
        StringBuffer buffer = new StringBuffer("select count(*) from ").append(tableName)
                .append("  where ")
                .append(this.keyColumn).append("<>").append(this.propertyExprs.get(this.keyProperty))
                .append(" and (");
        int i = 0;
        for (String property : this.uniqueFields) {
            String col = this.propertyColumns.get(property);
            buffer.append(this.fieldsAssigns.get(col));

            if (i > 0) {
                buffer.append(" or ");
            }
            i++;
        }
        buffer.append(")");

        this.checkUniqueSql = buffer.toString();
    }

    private void buildGetTreeRootSql(){
        StringBuffer buffer = new StringBuffer("select * from ").append(tableName)
                .append("  where ")
                .append(this.keyColumn).append("=").append(this.propertyColumns.get(this.parentKeyField));

        this.getTreeRootSql = buffer.toString();
    }


    public abstract String getSelectByPageSql(Map listMap, boolean isCount);

    private String tableName;
    private String keyProperty;
    private String keyColumn;
    private String sqlInsert;
    private String sqlDeleteById;
    private String sqlUpdate;
    private String sqlSelect;
    private String sqlDeleteAll;
    private String checkUniqueSql;
    private String getTreeRootSql;

    private ResultMap resultMap;
    private boolean treeTable;
    private String parentKeyField;

    private List<String> columns = new ArrayList<>();
    private List<String> properties = new ArrayList<>();
    private List<String> uniqueFields = new ArrayList<>();
    private Map<String, String> propertyColumns = new HashMap<>();
    private Map<String, String> fieldsAssigns = new HashMap<>();
    private Map<String, String> propertyExprs = new HashMap<>();


    public String getTableName() {
        return tableName;
    }

    public String getKeyColumn() {
        return keyColumn;
    }

    public String getKeyProperty() {
        return keyProperty;
    }

    public String getSqlInsert() {
        return sqlInsert;
    }

    public String getSqlDeleteById() {
        return sqlDeleteById;
    }

    public String getSqlUpdate() {
        return sqlUpdate;
    }

    public String getSqlSelect() {
        return sqlSelect;
    }

    public boolean isTreeTable() {
        return treeTable;
    }

    public String getParentKeyField() {
        return parentKeyField;
    }

    public String getGetTreeRootSql() {
        return getTreeRootSql;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setKeyColumn(String keyColumn) {
        this.keyColumn = keyColumn;
    }

    public void setKeyProperty(String keyProperty) {
        this.keyProperty = keyProperty;
    }

    public void setSqlInsert(String sqlInsert) {
        this.sqlInsert = sqlInsert;
    }

    public void setSqlUpdate(String sqlUpdate) {
        this.sqlUpdate = sqlUpdate;
    }

    public void setSqlDeleteById(String sqlDelete) {
        this.sqlDeleteById = sqlDelete;
    }

    public void setSqlSelect(String sqlSelect) {
        this.sqlSelect = sqlSelect;
    }

    public ResultMap getResultMap() {
        return resultMap;
    }

    public Map<String, String> getFieldsAssigns() {
        return fieldsAssigns;
    }

    public Map<String, String> getPropertyExprs() {
        return propertyExprs;
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<String> getProperties() {
        return properties;
    }

    public List<String> getUniqueFields() {
        return uniqueFields;
    }

    public Map<String, String> getPropertyColumns() {
        return propertyColumns;
    }

    public String getCheckUniqueSql() {
        return checkUniqueSql;
    }

    public void setCheckUniqueSql(String checkUniqueSql) {
        this.checkUniqueSql = checkUniqueSql;
    }

    public void setResultMap(ResultMap resultMap) {
        this.resultMap = resultMap;

        for (ResultMapping mapping : resultMap.getPropertyResultMappings()) {
            String column = mapping.getColumn();
            String property = mapping.getProperty();
            if (columns.contains(column)) {
                continue;
            }

            propertyColumns.put(property, column);
            columns.add(column);
            properties.add(property);
            propertyExprs.put(property, "#{" + property + "}");

            fieldsAssigns.put(column, column + "=#{" + property + "}");
        }

        Class checkUniqueType = CheckUnique.class;
        Class clazz = resultMap.getType();
        Object[] fieldsList = Arrays.stream(ClassUtils.getDeclaredFields(clazz)).filter(x ->
                x.getAnnotation(checkUniqueType) != null
        ).toArray();
        for (int i = 0; i < fieldsList.length; i++) {
            Field field = (Field) fieldsList[i];
            this.uniqueFields.add(field.getName());
        }

        if (StringUtils.isEmpty(this.keyProperty)) {
            if (resultMap.getIdResultMappings().size() > 0) {
                this.keyColumn = resultMap.getIdResultMappings().get(0).getColumn();
                this.keyProperty = resultMap.getIdResultMappings().get(0).getProperty();
            }
        }
    }

    private void initIsTreeTable() {
        Class clazz = resultMap.getType();
        this.treeTable = clazz.getAnnotation(TreeTable.class) != null;

        if (this.treeTable) {
            this.parentKeyField = Arrays.stream(ClassUtils.getDeclaredFields(clazz)).filter(x ->
                    x.getAnnotation(TreeTableParentKey.class) != null
            ).findFirst().get().getName();
        }
    }
}
