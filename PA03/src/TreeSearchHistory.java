public class TreeSearchHistory implements SearchHistory {
	public TSHNode root; // Do not change
	public int n; // Do not change

	public TreeSearchHistory() { // Do not change
		root = new TSHNode();
		n = 0;
	}

	// Change the code staring from this point

	@Override
	public int size() {
		return n;
	}

	@Override
	public void add(String word) {
		if (!findWord(word) && word.length() != 0) {
			add(root, word, 0);
			n += 1;
		}
	}

	private void add(TSHNode TreeNode, String word, int index) {
		if (index == word.length()) {
			TreeNode.end = true;
			return;
		}
		List<Pair<Character, TSHNode>> List = TreeNode.children;
		if (!List.empty()) {
			int size = Length(List);
			List.findFirst();
			for (int k = 0; k < size; k++) {
				if (List.retrieve().first == word.charAt(index)) {
					add(List.retrieve().second, word, index + 1);
					return;
				}
				List.findNext();
			}
		}

		Pair<Character, TSHNode> p = new Pair<Character, TSHNode>(word.charAt(index), new TSHNode());
		Length(List);
		List.insert(p);
		add(p.second, word, index + 1);
	}

	private int Length(List<Pair<Character, TSHNode>> L) {
		if (L.empty()) {
			return 0;
		}
		int count = 1;
		L.findFirst();
		while (!L.last()) {
			count++;
			L.findNext();
		}
		return count;
	}

	@Override
	public boolean findWord(String word) {
		List<Pair<Character, TSHNode>> L = root.children;
		return findWord(root, word, 0);
	}

	private boolean findWord(TSHNode p, String word, int i) {
		if (i == word.length())
			return p.end;

		List<Pair<Character, TSHNode>> L = p.children;

		if (!L.empty()) {
			int size = Length(L);
			L.findFirst();
			for (int k = 0; k < size; k++) {
				if (L.retrieve().first == word.charAt(i)) {
					return findWord(L.retrieve().second, word, i+1);
				}
				L.findNext();
			}
		}

		return false;
	}

	@Override
	public boolean findPrefix(String prefix) {
		if (prefix.length() == 0) {
			return true;
		}
		
		TSHNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			boolean flag = false;
			if (!curr.children.empty()) {
				curr.children.findFirst();
				while (!curr.children.last()) {
					if (curr.children.retrieve().first == prefix.charAt(i)) {
						curr = curr.children.retrieve().second;
						flag  = true;
						break;
					}
					curr.children.findNext();
				}
				if (!flag && curr.children.retrieve().first == prefix.charAt(i)) {
					curr = curr.children.retrieve().second;
					flag  = true;
				}
			}
			
			if (!flag) {
				return false;
			}
		}
		
		return true;
	}

	private boolean findPrefix(TSHNode Node, String prefix, int i) {
	if(Node.end && i==prefix.length()){
		return true;
	}
	List <Pair<Character , TSHNode>> List=Node.children;
	if(List.empty()) {
		return false;
	}
	boolean Check=false;
	int size = Length(List);
	List.findFirst();
	for (int j = 1; j < size; j++) {
		if(List.retrieve().first==prefix.charAt(i)) {
			Check = true;
			break;
		}
		List.findNext();
		
	}
	if(List.retrieve().first==prefix.charAt(i)) {
		Check=true;
		
	}
	if(Check&&i==prefix.length()-1) {
		return true;
	}
	if(!Check) {
		return false;
	}else
		return findPrefix(List.retrieve().second,prefix,i+1);
	}

	@Override
	public List<String> complete(String prefix) {
		List<String> res = new LinkedList<String>();
		collect_words(root, prefix, "", res, 0);
		return res;
	}

	private void collect_words(TSHNode Node, String prefix, String string, List<String> result, int i) {
		if (Node.end && i >= prefix.length()) {
			result.insert(string);
		}
		List<Pair<Character, TSHNode>> List = Node.children;
		if (List.empty())
			return;

		if (i < prefix.length()) {
			boolean flag = false;
			int size = Length(List);
			List.findFirst();
			for (int index = 1; index < size; index++) {
				if (List.retrieve().first == prefix.charAt(i)) {
					flag = true;
					break;
				}
				List.findNext();
			}
			if (List.retrieve().first == prefix.charAt(i))
				flag = true;
			if (!flag) {
				return;
			}
			string += List.retrieve().first;
			collect_words(List.retrieve().second, prefix, string, result, i + 1);
		} else {
			int size = Length(List);
			List.findFirst();
			for (int ii = 1; ii <= size; ii++) {
				string += List.retrieve().first;
				collect_words(List.retrieve().second, prefix, string, result, i + 1);
				string = string.substring(0, string.length() - 1);
				List.findNext();
			}

		}
	}
}
