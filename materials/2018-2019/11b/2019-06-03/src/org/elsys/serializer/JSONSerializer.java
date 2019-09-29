package org.elsys.serializer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONSerializer
        extends AbstractSerializer {
    @Override
    public String serialize(Object object) {
        List<Field> fields = getFields(object.getClass());
        List<String> outputs = new ArrayList<>();

        for(Field field: fields){
            StringBuilder builder = new StringBuilder();

            Ignore[] ignores = field.getDeclaredAnnotationsByType(Ignore.class);
            if (ignores.length > 0){
                continue;
            }

            String fieldName = field.getName();

            MapAs[] maps = field.getDeclaredAnnotationsByType(MapAs.class);
            if (maps.length > 0){
                MapAs map = maps[0];
                fieldName = map.value();
            }

            builder.append('"');
            builder.append(fieldName);
            builder.append('"');
            builder.append(" : ");

            try {
                field.setAccessible(true);
                Object value = field.get(object);

                if (isDirectlySerializable(value)){
                    builder.append('"' + value.toString() + '"');
                } else if (isCollection(value)){
                    String result = serializeCollection((Collection)value);
                    builder.append(result);
                } else if (isArray(value)){

                } else {
                    builder.append(serialize(value));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            outputs.add(builder.toString());
        }

        StringBuilder builder = new StringBuilder();
        builder.append('{');
        builder.append(String.join(", ", outputs));
        builder.append('}');

        return builder.toString();
    }

    @Override
    public boolean isPretty() {
        return false;
    }

    @Override
    public void setPretty(boolean pretty) {

    }

    @Override
    public boolean getIncludeNullFields() {
        return false;
    }

    @Override
    public void setIncludeNullFields(boolean nullFields) {

    }

    private String serializeCollection(Collection collection){
        List<String> outputs = new ArrayList<>();
        for(Object object: collection){
            outputs.add('"' + object.toString() + '"');
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        builder.append(String.join(",", outputs));
        builder.append(']');

        return builder.toString();
    }
}




