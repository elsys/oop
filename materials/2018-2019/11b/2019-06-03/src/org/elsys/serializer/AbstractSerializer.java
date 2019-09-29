package org.elsys.serializer;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public abstract class AbstractSerializer implements Serializer {
    protected List<Field> getFields(Class cls){
        List<Field> result = new ArrayList<>();

        while(cls != Object.class){
            result.addAll(Arrays.asList(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }

        return result;
    }

    protected boolean isDirectlySerializable(Object obj){
        return obj instanceof  String
                || obj instanceof Character
                || obj instanceof Number
                || obj instanceof Boolean;
    }

    protected boolean isCollection(Object obj){
        return obj instanceof Collection;
    }

    protected boolean isArray(Object obj){
        return obj.getClass().isArray();
    }
}












