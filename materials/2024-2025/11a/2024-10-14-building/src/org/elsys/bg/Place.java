package org.elsys.bg;

public class Place {
    private String tenantName;
    private double area;
    private int floor;

    public Place() {
        tenantName = "";
        area = 0;
        floor = 0;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        if (tenantName.isEmpty())
            throw new IllegalArgumentException("Tenant name cannot be empty");
        this.tenantName = tenantName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area < 0)
            throw new IllegalArgumentException("Area cannot be negative");
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
