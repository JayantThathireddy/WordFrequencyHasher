import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tester class for WordFrequency.
 */
public class WordFrequencyTest {
    // Object to be tested
    private WordFrequency runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new WordFrequency("Hello");
    }

    /**
     * testGetWord() testing getWord().
     */
    @Test
    public void testGetWord() {
        assertEquals("Word stored is wrong", "Hello", runner.getWord());
    }

    /**
     * testGetCount() testing getCount().
     */
    @Test
    public void testGetCount() {
        assertEquals(1, runner.getCount());
        WordFrequency runner2 = new WordFrequency("hi", 3);
        assertEquals(3, runner2.getCount());
    }

    /**
     * testIncrement() testing increment().
     */
    @Test
    public void testIncrement() {
        assertEquals(1, runner.getCount());
        runner.increment();
        assertEquals(2, runner.getCount());
    }

    /**
     * testEquals() testing equals().
     */
    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testEquals() {
        WordFrequency runner2 = new WordFrequency("Hello");
        WordFrequency runner3 = new WordFrequency("NotHello");


        assertTrue(runner.equals(runner));
        assertTrue(runner.equals(runner2));
        assertFalse(runner.equals(runner3));
        assertFalse(runner.equals("Hi"));
        assertFalse(runner.equals((Integer) 3));

    }
}
