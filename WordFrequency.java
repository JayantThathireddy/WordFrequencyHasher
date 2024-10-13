/**
 * WordFrequency class to be used in a hash table.
 * 
 * @author Jayant Thathireddy
 */
public class WordFrequency {
    // declare private variables here
    private String word;
    private int count;

    /**
     * Constructor for WordFrequency.
     * Takes a String and stores it in word, initializes count to 1.
     * @param w is some String
     */
    public WordFrequency(String w) {
        word = w;
        count = 1;
    }

    /**
     * Constructor for WordFrequency when count is known.
     * @param w is some String
     * @param count is the frequency of the word
     */
    public WordFrequency(String w, int count) {
        word = w;
        this.count = count;
    }

    /**
     * Returns word.
     * @return word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns count.
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Increments count by one.
     */
    public void increment() {
        count++;
    }

    /**
     * equals() - compares two WordFrequency objects
     * checking to see if they are the same. Equality
     * is defined by string matching ignoring case.
     * 
     * @param other object to compare against
     * @return true if this and other are equals, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof String) {
            String w = (String) other;
            return getWord().equalsIgnoreCase(w);
        } else if (other instanceof WordFrequency) {
            WordFrequency wf = (WordFrequency) other;
            String w = wf.getWord();
            return getWord().equalsIgnoreCase(w);
        } else {
            return false;
        }
    }
}
