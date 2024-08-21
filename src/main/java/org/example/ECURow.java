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
}

