package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class MainTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MainTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }



    public void testProcessECUs() {
        // Arrange
        ElectronicComposite childECU = new ElectronicComposite("ChildECU", new ArrayList<>(), null, new ArrayList<>(), "LongNameChildECU", "ShortNameChildECU");
        List<ElectronicComposite> children = new ArrayList<>();
        children.add(childECU);
        ElectronicComposite parentECU = new ElectronicComposite("ParentECU", children, null, new ArrayList<>(), "LongNameParentECU", "ShortNameParentECU");
        List<ElectronicComposite> startList = new ArrayList<>();
        startList.add(parentECU);

        // Act
        List<ECURow> result = Main.processECUs(startList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        // Checking Parent ECU

        ECURow parentRow = result.get(0);
        assertEquals("ParentECU", parentRow.getName());
        assertTrue(parentRow.hasChildren());
        assertNull(parentRow.getParentName());
        assertEquals("LongNameParentECU", parentRow.getLongName());
        assertEquals("ShortNameParentECU", parentRow.getShortName());

        // Checking Child ECU
        ECURow childRow = result.get(1);
        assertEquals("ChildECU", childRow.getName());
        assertFalse(childRow.hasChildren());
        assertEquals("ParentECU", childRow.getParentName());
        assertEquals("LongNameChildECU", childRow.getLongName());
        assertEquals("ShortNameChildECU", childRow.getShortName());
    }
}
