package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            List<ElectronicComposite> startList = createStartList();

            // Process the ECUs
            List<ECURow> result = processECUs(startList);

            // Pass the result to setResult
            setResult(result);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during processing", e);
        }
    }

    private static List<ElectronicComposite> createStartList() {
        // Create dummy data
        ElectronicComposite childChildECU1 = new ElectronicComposite("ChildChildECU1", new ArrayList<>(), null, new ArrayList<>(), "LongNameChildChildECU1", "ShortNameChildChildECU1");
        ElectronicComposite childChildECU2 = new ElectronicComposite("ChildChildECU2", new ArrayList<>(), null, new ArrayList<>(), "LongNameChildChildECU2", "ShortNameChildChildECU2");

        List<ElectronicComposite> childECUs1 = new ArrayList<>();
        childECUs1.add(childChildECU1);

        List<ElectronicComposite> childECUs2 = new ArrayList<>();
        childECUs2.add(childChildECU2);

        ElectronicComposite childECU1 = new ElectronicComposite("ChildECU1", childECUs1, null, new ArrayList<>(), "LongNameChildECU1", "ShortNameChildECU1");
        ElectronicComposite childECU2 = new ElectronicComposite("ChildECU2", childECUs2, null, new ArrayList<>(), "LongNameChildECU2", "ShortNameChildECU2");

        List<ElectronicComposite> parentECUs = new ArrayList<>();
        parentECUs.add(childECU1);
        parentECUs.add(childECU2);

        ElectronicComposite parentECU = new ElectronicComposite("ParentECU", parentECUs, null, new ArrayList<>(), "LongNameParentECU", "ShortNameParentECU");

        List<ElectronicComposite> startList = new ArrayList<>();
        startList.add(parentECU);

        return startList;
    }

    public static List<ECURow> processECUs(List<ElectronicComposite> ecus) {
        List<ECURow> result = new ArrayList<>();
        Set<String> seenECUs = new HashSet<>();
        for (ElectronicComposite ecu : ecus) {
            processECU(ecu, null, result, seenECUs);
        }
        return result;
    }

    private static void processECU(ElectronicComposite ecu, String parentName, List<ECURow> result, Set<String> seenECUs) {
        if (seenECUs.contains(ecu.getName())) {
            return; // Skip already processed ECUs to avoid duplicates
        }
        seenECUs.add(ecu.getName());

        boolean hasChildren = ecu.getChildEE() != null && !ecu.getChildEE().isEmpty();
        int connectorCount = (ecu.getEeLogicalConnectors() != null) ? ecu.getEeLogicalConnectors().size() : 0;

        ECURow row = new ECURow(
                ecu.getName(),
                hasChildren,
                parentName,
                connectorCount,
                ecu.getLongName(),
                ecu.getShortName()
        );

        result.add(row);

        if (hasChildren) {
            for (ElectronicComposite child : ecu.getChildEE()) {
                processECU(child, ecu.getName(), result, seenECUs);
            }
        }
    }

    public static void setResult(List<ECURow> result) {
        for (ECURow row : result) {
            System.out.println(row.toString());
        }
    }
}

