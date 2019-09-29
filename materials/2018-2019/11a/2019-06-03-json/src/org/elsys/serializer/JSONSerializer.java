package org.elsys.serializer;

import javax.crypto.MacSpi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONSerializer extends AbstractSerializer
    implements Serializer{
    @Override
    public String serialize(Object object) {
        List<Field> fields = getFields(object.getClass());
        List<String> outputs = new ArrayList<>();

        for(Field field: fields){
            Ignore[] ignores = field.getDeclaredAnnotationsByType(Ignore.class);
            if (ignores.length > 0)
                continue;

            StringBuilder builder = new StringBuilder();
            String fieldName = field.getName();

            MapAs[] maps = field.getDeclaredAnnotationsByType(MapAs.class);
            if(maps.length > 0){
                MapAs map = maps[0];
                fieldName = map.value();
            }

            builder.append('"');
            builder.append(fieldName);
            builder.append('"');

            builder.append(" : ");

            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (isDirectlySerializable(value)){
                    builder.append('"');
                    builder.append(value.toString());
                    builder.append('"');
                } else if (isArray(value)){

                } else if (isCollection(value)){
                    builder.append(serializeCollection((Collection) value));
                } else {
                    builder.append(serialize(value));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            outputs.add(builder.toString());
        }

        StringBuilder builder = new StringBuilder();

        builder.append("{");
        builder.append(
                String.join(", ",outputs));
        builder.append("}");

        return builder.toString();
    }

    @Override
    public void setIncludeNullFields(boolean nullFields) {

    }

    @Override
    public boolean isSetIncludeNullFields() {
        return false;
    }

    @Override
    public void setPretty(boolean pretty) {

    }

    @Override
    public boolean isPretty() {
        return false;
    }

    String serializeCollection(Collection collection){
        List<String> outputs = new ArrayList<>();

        for(Object obj: collection){
            outputs.add('"' + obj.toString() + '"');
        }

        StringBuilder builder = new StringBuilder();
        builder.append('[');
        builder.append(String.join(",", outputs));
        builder.append(']');

        return builder.toString();
    }
}




