package org.elsys.duzunov;

public enum Region {
    SOFIA("CB"),
    BURGAS("A"),
    VARNA("B"),
    PLOVDIV("PB"),
    RUSE("P"),
    GABROVO("EB"),
    VIDIN("BH"),
    VRATSA("BP");

    private final String prefix;

    Region(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
