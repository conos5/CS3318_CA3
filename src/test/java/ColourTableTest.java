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
        // Add more assertions based on the expected behavior of the constructor
    }

    @Test
    public void testConstructorWithInvalidSize() {
        // Test with an invalid palette size (less than 2)
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1));

        // Test with an invalid palette size (greater than 1024)
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(2000));

        // Test with an invalid palette size (not a power of 2)
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(5));
    }

    @Test
    public void testConstructorWithNoParams() {
        // Test with no params
        assertThrows(IllegalArgumentException.class, () -> new ColourTable());
    }

    @Test
    public void testConstructorWithIncorrectParams() {
        // Test with invalid number of params
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(4, "someValue"));
    }
}
