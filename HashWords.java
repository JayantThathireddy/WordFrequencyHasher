import itsc2214.*; // not needed now, but you might in your projects

/**
 * HashWords class.
 * @author Jayant Thathireddy
 */
@SuppressWarnings("unused")
public class HashWords {

    private WordFrequency[] hashTable;
    private int uniqueWords;
    private int totalWords;
    /**
     * Constructor for HashWords.
     * @param initialSize is the initial size of the hash table.
     */
    public HashWords(int initialSize) {
        hashTable = new WordFrequency[initialSize];
    }

    /**
     * Returns size of hash table.
     * @return Returns size
     */
    public int size() {
        return hashTable.length;
    }

    /**
     * Hashes the given String.
     * @param w is the String to be hashed
     * @return the hashKey
     */
    public int hashKey(String w) {
        int sumOfLetters = 0;
        String lowerCaseWord = w.toLowerCase();
        for (char letter : lowerCaseWord.toCharArray()) {
            sumOfLetters += letter;
        }
        return sumOfLetters % this.size();
    }

    /**
     * Returns the frequency of a word in the table (0 if not there).
     * @param w is the String whose frequency is being found.
     * @return the count for that String in the table.
     */
    public int frequency(String w) {
        if (!this.contains(w)) {
            return 0;
        }
        int index = this.getIndex(w);
        return hashTable[index].getCount();
    }

    /**
     * Adds a word to the table.
     * @param w is the word to be added
     */
    public void addWord(String w) {
        int index = this.hashKey(w);
        if (this.numUniqueWordsInTable() >= this.size()) {
            this.resize();
        }

        if (this.contains(w)) {
            index = this.getIndex(w);
            hashTable[index].increment();
            totalWords++;
            return;
        }

        while (hashTable[index] != null) {
            index++;
            index = index % this.size();
        }
        hashTable[index] = new WordFrequency(w);
        uniqueWords++;
        totalWords++;
    }

    /**
     * Checks if there is a certain word in the hash table.
     * @param w The word to be checked
     * @return True or false
     */
    public boolean contains(String w) {
        int index = this.hashKey(w);

        while (hashTable[index] != null) {
            if (hashTable[index].getWord().equals(w.toLowerCase())) {
                return true;
            }
            index++;
            index %= this.size();
        }
        return false;
    }

    /**
     * Getter for uniqueWords.
     * @return the number of unique words
     */
    public int numUniqueWordsInTable() {
        return uniqueWords;
    }

    /**
     * Getter for totalWords.
     * @return the number of total words
     */
    public int totalNumOfWords() {
        return totalWords;
    }

    /**
     * Searches for the word with the highest frequency.
     * @return the most common word
     */
    public String mostCommonWord() {
        int highest = 0;
        WordFrequency mostCommon = null;
        for (WordFrequency word : hashTable) {
            if (word == null) {
                continue;
            }
            if (word.getCount() > highest) {
                mostCommon = word;
                highest = word.getCount();
            }
        }
        if (mostCommon == null) {
            return null;
        }
        return mostCommon.getWord();
    }

    /**
     * Calculates the frequency the given word appears in relation to the 
     * total number of words in the table.
     * @param w is the word whose term frequency is calculated
     * @return the term frequency as a ratio
     */
    public double termFrequency(String w) {
        if (totalNumOfWords() == 0) {
            return 0.0;
        }
        return this.frequency(w) / (double) this.totalNumOfWords();
    }

    /**
     * Internal method for tripling the size of the hash table.
     */
    public void resize() {
        int newSize = this.size() * 3;
        HashWords temp = new HashWords(newSize);
        for (WordFrequency wordF : hashTable) {
            if (wordF == null) {
                continue;
            }
            String word = wordF.getWord();
            int count = wordF.getCount();

            int index = temp.hashKey(word);
            while (temp.getHashTable()[index] != null) {
                index++;
                index = index % temp.size();
            }
            temp.getHashTable()[index] = new WordFrequency(word, count);
        }
        hashTable = temp.getHashTable();
    }

    /**
     * Internal method for getting the index where a certain word is stored in the 
     * hash table (the word must be in the table).
     * @param w is the word whose index we are getting
     * @return is the index of that word;
     */
    public int getIndex(String w) {
        int index = this.hashKey(w);
        while (!hashTable[index].getWord().equals(w.toLowerCase())) {
            index++;
            index = index % this.size();
        }
        return index;
    }

    /**
     * Getter method for hash table.
     * @return the hash table
     */
    public WordFrequency[] getHashTable() {
        return hashTable;
    }
}
