// Do not change this class
public class TSHNode {
	public List<Pair<Character, TSHNode>> children;
	public boolean end;

	public TSHNode() {
		children = new LinkedList<Pair<Character, TSHNode>>();
		end = false;
	}
}

