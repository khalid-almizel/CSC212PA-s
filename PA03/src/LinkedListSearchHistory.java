
public class LinkedListSearchHistory implements SearchHistory {
	private List<String> l;
	private int n;

	public LinkedListSearchHistory() {
		l = new LinkedList<String>();
		n = 0;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public void add(String word) {
		if (!findWord(word)) {
			l.insert(word);
		}
	}

	@Override
	public boolean findWord(String word) {
		if (l.empty()) {
			return false;
		} else {
			l.findFirst();
			while (!l.last()) {
				if (l.retrieve().equals(word)) {
					return true;
				}
				l.findNext();
			}
			return l.retrieve().equals(word);
		}
	}

	@Override
	public boolean findPrefix(String prefix) {
		if (l.empty()) {
			return false;
		} else {
			l.findFirst();
			while (!l.last()) {
				if (l.retrieve().startsWith(prefix)) {
					return true;
				}
				l.findNext();
			}
			return l.retrieve().startsWith(prefix);
		}
	}

	@Override
	public List<String> complete(String prefix) {
		List<String> res = new LinkedList<String>();
		if (!l.empty()) {
			l.findFirst();
			while (!l.last()) {
				String word = l.retrieve();
				if (word.startsWith(prefix)) {
					res.insert(word);
				}
				l.findNext();
			}
			String word = l.retrieve();
			if (word.startsWith(prefix)) {
				res.insert(word);
			}
		}
		return res;
	}

}
