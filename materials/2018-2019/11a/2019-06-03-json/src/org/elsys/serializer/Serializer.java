package org.elsys.serializer;

public interface Serializer {
    String serialize(Object object);

    void setIncludeNullFields(boolean nullFields);

    boolean isSetIncludeNullFields();

    void setPretty(boolean pretty);

    boolean isPretty();
}
