package org.example;


public class ECURow {
    private String name;
    private boolean hasChildren;
    private String parentName;
    private int amountOfConnectors;
    private String longName;
    private String shortName;

    public ECURow(String name, boolean hasChildren, String parentName, int amountOfConnectors, String longName, String shortName) {
        this.name = name;
        this.hasChildren = hasChildren;
        this.parentName = parentName;
        this.amountOfConnectors = amountOfConnectors;
        this.longName = longName;
        this.shortName = shortName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfConnectors() {
        return amountOfConnectors;
    }

    public void setAmountOfConnectors(int amountOfConnectors) {
        this.amountOfConnectors = amountOfConnectors;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "ECURow{" +
                "name='" + name + '\'' +
                ", hasChildren=" + hasChildren +
                ", parentName='" + parentName + '\'' +
                ", amountOfConnectors=" + amountOfConnectors +
                ", longName='" + longName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }

    public boolean hasChildren() {
        return hasChildren;
    }
}

