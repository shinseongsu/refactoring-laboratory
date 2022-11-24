package com.van.support.parser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public <T> List<T> parser(byte[] reqBytes, Class outputClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = outputClass.getConstructor();
        T bean = constructor.newInstance();
        Field[] fields = outputClass.getDeclaredFields();

        List<T> result = new ArrayList<>();

        for(Field field : fields) {
            if(field.isAnnotationPresent(FixedLength.class)) {
                FixedLength annotation = field.getAnnotation(FixedLength.class);
                field.setAccessible(true);

                field.set(bean, new String(reqBytes, annotation.offset(), annotation.length() ));

                result.add(bean);
            }
        }

        return result;
    }

}
