import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tester class for HashWords.
 */
public class HashWordsTest {
    // Object to be tested
    private HashWords runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new HashWords(10);
    }

    /**
     * testSize() testing size().
     */
    @Test
    public void testSize() {
        assertEquals("Size of table is wrong",
                10, runner.size());
    }

    /**
     * testHashKey testing hashKey().
     */
    @Test
    public void testHashKey() {
        assertEquals(2, runner.hashKey("Hello"));
        assertEquals(2, runner.hashKey("HELLO"));
        assertEquals(0, runner.hashKey("bye"));
        assertEquals(0, runner.hashKey(""));
    }

    /**
     * Tests addWord() and contains().
     */
    @Test
    public void testAddWord() {
        assertFalse(runner.contains("hello"));
        runner.addWord("hello");
        assertTrue(runner.contains("hello"));
        runner.addWord("olleh");
        assertTrue(runner.contains("olleh"));
        assertFalse(runner.contains("hi"));
        assertEquals(2, runner.numUniqueWordsInTable());
        assertEquals(2, runner.totalNumOfWords());
        HashWords runner2 = new HashWords(2);
        runner2.addWord("hey");
        runner2.addWord("yeh");
        assertEquals(2, runner2.size());
        assertEquals(2, runner2.numUniqueWordsInTable());
        runner2.addWord("umm");
        assertEquals(6, runner2.size());
    }

    /**
     * Tests frequency().
     */
    @Test
    public void testfrequency() {
        assertEquals(0, runner.frequency("hello"));
        runner.addWord("hello");
        runner.addWord("Hello");
        assertEquals(2, runner.frequency("hello"));
        assertEquals(1, runner.numUniqueWordsInTable());
        assertEquals(2, runner.totalNumOfWords());
    }

    /**
     * Tests getIndex().
     */
    @Test 
    public void testGetIndex() {
        runner.addWord("hello");
        assertEquals(2, runner.getIndex("hello"));
        runner.addWord("olleh");
        assertEquals(3, runner.getIndex("olleh"));
    }

    /**
     * Tests resize().
     */
    @Test
    public void testResize() {
        assertEquals(10, runner.size());
        runner.resize();
        assertEquals(30, runner.size());
        runner.resize();
        assertEquals(90, runner.size());
    }

    /**
     * Tests mostCommonWord().
     */
    @Test
    public void testMostCommon() {
        assertNull(runner.mostCommonWord());
        runner.addWord("hello");
        assertEquals("hello", runner.mostCommonWord());
        runner.addWord("hi");
        runner.addWord("hi");
        assertEquals("hi", runner.mostCommonWord());
    }

    /**
     * Tests termFrequency().
     */
    @Test
    public void testTermFrequency() {
        assertTrue(0 == runner.termFrequency(null));
        runner.addWord("hello");
        assertTrue(1 == runner.termFrequency("hello"));
        runner.addWord("hi");
        assertTrue(0.5 == runner.termFrequency("hello"));
    }
}
