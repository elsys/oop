package org.elsys.serializer;

import javax.swing.text.StyledEditorKit;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractSerializer
    implements Serializer{

    protected List<Field> getFields(Class cls){
        List<Field> fields = new ArrayList<>();

        while(cls != Object.class){
            fields.addAll(
                    Arrays.asList(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }

        return fields;
    }

    protected boolean isDirectlySerializable(Object object){
        return object instanceof String
                || object instanceof Number
                || object instanceof Boolean
                || object instanceof Character;
    }

    protected boolean isCollection(Object object){
        return object instanceof Collection;
    }

    protected boolean isArray(Object object){
        return object.getClass().isArray();
    }
}