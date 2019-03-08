
public class test {
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedQueue<>();
		Stack<Integer> s = new ArrayStack<>(4);
		Stack<Integer> st = new ArrayStack<>(3);
		
		Integer arrI[] = {20, 8, 3, 1};
		
		q.multiEnqueue(arrI, 4);
		System.out.print("Queue 1: ");
		printQ(q);
		
		s.multiPush(arrI, 4);
		System.out.print("Stack 1: ");
		printS(s);
		
		st.multiPush(arrI, 4);
		System.out.print("Stack 2: ");
		printS(st);
		
		System.out.print("Stack 3: ");
		printS(s.copy());
		
		System.out.print("Stack 4: ");
		s.reverse();
		printS(s);
		
		System.out.println();
		
		
	}
	
	private static <T> void print(T e) {
		System.out.print(e + " ");
	}

	private static <T> void printQ(Queue<T> q) {
		int n = q.length();
		
		for (int i = 0; i < n; i++) {
			T e = q.serve();
			print(e);
			q.enqueue(e);
		}
		
		System.out.println();
	}

	private static <T> void printS(Stack<T> s) {
		Stack<T> sc = s.copy();
		while (!sc.empty()) {
			print(sc.pop());
		}
		System.out.println();
	}
	
	private static <T> void printSQ(Stack<Queue<T>> s) {
		Stack<Queue<T>> sc = s.copy();
		while (!sc.empty()) {
			printQ(sc.pop());
		}
		System.out.println();
	}
	
	private static <T> void printQS(Queue<Stack<T>> q) {
		int n = q.length();
		
		for (int i = 0; i < n; i++) {
			Stack<T> e = q.serve();
			printS(e);
			q.enqueue(e);
		}
		
		System.out.println();
	}
	
}
