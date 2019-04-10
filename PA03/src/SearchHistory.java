public interface SearchHistory {

	// Return the number of words stored in the search history.
	int size();

	// Add word to the search history.
	void add(String word);

	// Search for word.
	boolean findWord(String word);

	// Search for prefix
	boolean findPrefix(String prefix);

	// Return all stored words that start with prefix. If none exists, the method returns an empty list. If prefix is empty, all words in the history are returned. The order of the words is not important. 
	List<String> complete(String prefix);
}
