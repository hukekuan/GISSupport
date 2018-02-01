package com.gis3c.spatial.postgis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;

import java.math.BigDecimal;
import java.sql.*;

/**
 * Created by hukekuan on 2017/12/15.
 */

public class ArrayTypeHandler extends BaseTypeHandler<Object[]> {
    private static final String TYPE_NAME_VARCHAR = "varchar";
    private static final String TYPE_NAME_BOOLEAN = "boolean";
    private static final String TYPE_NAME_INTEGER = "integer";
    private static final String TYPE_NAME_NUMERIC = "numeric";
    private static final String TYPE_NAME_DECIMAL = "decimal";



    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object[] parameter, JdbcType jdbcType) throws SQLException {
        String typeName = null;
        if (parameter instanceof Integer[] || parameter instanceof Integer[][]) {
            typeName = TYPE_NAME_INTEGER;
        } else if (parameter instanceof String[] || parameter instanceof String[][]) {
            typeName = TYPE_NAME_VARCHAR;
        } else if (parameter instanceof Boolean[] || parameter instanceof Boolean[][]) {
            typeName = TYPE_NAME_BOOLEAN;
        } else if (parameter instanceof Double[] || parameter instanceof Double[][]) {
            typeName = TYPE_NAME_NUMERIC;
        } else if(parameter instanceof BigDecimal[] || parameter instanceof BigDecimal[][]){
            typeName = TYPE_NAME_DECIMAL;
        }

        if (typeName == null) {
            throw new TypeException("ArrayTypeHandler parameter typeName error, your type is " + parameter.getClass().getName());
        }

        Array array = ps.getConnection().createArrayOf(typeName, parameter);
        ps.setArray(i, array);
    }



    @Override
    public Object[] getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getArray(rs.getArray(columnName));
    }

    @Override
    public Object[] getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getArray(rs.getArray(columnIndex));
    }

    @Override
    public Object[] getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getArray(cs.getArray(columnIndex));
    }

    private Object[] getArray(Array array) {
        if (array == null) {
            return null;
        }
        try {
            return (Object[]) array.getArray();
        } catch (Exception e) {
        }
        return null;
    }
}
