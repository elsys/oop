package org.elsys.serializer;

public interface Serializer {
    String serialize(Object object);

    boolean isPretty();

    void setPretty(boolean pretty);

    boolean getIncludeNullFields();

    void setIncludeNullFields(boolean nullFields);
}