package com.van.support;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetMapper<T> {

    public List<T> mapRersultSetToObject(ResultSet rs, Class outputClass) {
        List<T> outputList = new ArrayList<>();
        if (rs == null) {
            return new ArrayList<>();
        }

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            Field[] fields = outputClass.getDeclaredFields();

            while (rs.next()) {
                Constructor<T> constructor = outputClass.getConstructor();
                T bean = constructor.newInstance();

                for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
                    String columnName = rsmd.getColumnName(_iterator + 1);
                    Object columnValue = rs.getObject(_iterator + 1);

                    for (Field field : fields) {
                        field.setAccessible(true);

                        if (field.getName().equals(columnName)) {
                            field.set(bean, columnValue);
                            break;
                        }
                    }
                }
                outputList.add(bean);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return outputList;
    }
}
