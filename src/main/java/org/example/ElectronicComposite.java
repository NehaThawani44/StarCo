package org.example;

import java.util.List;

public class ElectronicComposite {
    private String name;
    private List<ElectronicComposite> childEE;
    private ElectronicComposite parentEE;
    private List<Connector> eeLogicalConnectors;
    private String longName;
    private String shortName;

    public ElectronicComposite(String name, List<ElectronicComposite> childEE, ElectronicComposite parentEE, List<Connector> eeLogicalConnectors, String longName, String shortName) {
        this.name = name;
        this.childEE = childEE;
        this.parentEE = parentEE;
        this.eeLogicalConnectors = eeLogicalConnectors;
        this.longName = longName;
        this.shortName = shortName;
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<ElectronicComposite> getChildEE() {
        return childEE;
    }

    public ElectronicComposite getParentEE() {
        return parentEE;
    }

    public List<Connector> getEeLogicalConnectors() {
        return eeLogicalConnectors;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }
}


