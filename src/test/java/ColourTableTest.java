import com.conorshipsey.colourtableca3.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ColourTableTest {
    /*
        Requirements:
            - Constructor takes single parameter that specifies number of colours in the palette
                - This number must be a power of 2, and greater than 1, and less than 1025.
                - Creating a ColourTable with an invalid palette size throws an exception.
     */
    @Test
    public void testConstructorWithValidSize() {
        // Test with a valid palette size
        ColourTable ct = new ColourTable(4);
        assertNotNull(ct);
    }

    @Test
    public void testConstructorWithSizeLessThanTwo() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1));
    }

    @Test
    public void testConstructorWithSizeGreaterThan1024() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(2000));
    }

    @Test
    public void testConstructorWithSizeNotPowerOfTwo() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(5));
    }

    @Test
    public void testAddValidColour() {
        // Testing a method add that enables a developer to add a 24-bit RGB
        // colour to the colour table
        // Black in hexadecimal = 0x000000 ->
        // equivalent to 0b00000000_00000000_00000000 (24 bits)
        // We should then test that the colour was added to the
        // colour table with the isPresent() method
        ColourTable ct = new ColourTable(4);
        ct.add("000000");
        assertTrue(ct.isPresent("000000"));
    }

    @Test
    public void testAddDuplicateColour() {
        ColourTable ct = new ColourTable(4);
        ct.add("000000");
        assertThrows(IllegalArgumentException.class, () -> ct.add("000000"));
    }

    @Test
    public void testAddInvalidColour() {
        // Testing adding an invalid hexadecimal colour
        ColourTable ct = new ColourTable(4);
        assertThrows(IllegalArgumentException.class, () -> ct.add("00000X"));
    }

    @Test
    public void testAddColourToFullTable() {
        ColourTable ct = new ColourTable(4);
        ct.add("FF0000");
        ct.add("00FF00");
        ct.add("0000FF");
        ct.add("000000");
        // to add to full colour table should throw an exception
        assertThrows(IllegalArgumentException.class, () -> ct.add("FFFFFF"));
    }

    @Test
    public void testRemoveColour() {
        ColourTable ct = new ColourTable(4);
        ct.add("000000");
        assertTrue(ct.isPresent("000000"));
        ct.remove("000000");
        assertFalse(ct.isPresent("000000"));
    }

    @Test
    public void testRemoveColourNotInTable() {
        ColourTable ct = new ColourTable(4);
        ct.add("0000FF");
        assertThrows(IllegalArgumentException.class, () -> ct.remove("000000"));
    }

    @Test
    public void testRemoveColourInEmptyTable() {
        ColourTable ct = new ColourTable(4);
        assertThrows(IllegalArgumentException.class, () -> ct.remove("000000"));
    }

    @Test
    public void testGetColour() {
        ColourTable ct = new ColourTable(4);
        ColourTable.Colour colour = ct.add("000000");
        // Asserting that the colour returned from getColour()
        // is the same as the colour added. Where getColour() returns
        // an integer representation of the colour.
        assertEquals(0, colour.getColour());
    }

    @Test
    public void testGetHexColour() {
        ColourTable ct = new ColourTable(4);
        ColourTable.Colour colour = ct.add("000000");
        // Asserting that the colour returned from getColour()
        // is the same as the colour added. Where getHexColour() returns
        // a string representation of the colour with "0x" in front of it.
        assertEquals("0x000000", colour.getHexColour());
    }
}
