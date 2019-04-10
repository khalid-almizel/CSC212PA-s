
public class Test {

	public static void main(String[] args) {
		CompList<Integer> l1 = new LinkedCompList<>();
		Integer arr1[] = new Integer[] {
				1, 2, -1, 10, 3, 44, 1, -10, 222, 1, -10
		};
		insert(l1, arr1);
		
		CompList<Character> l2 = new ArrayCompList<>(13);
		Character arr2[] = new Character[] {
			'a', 'c', 'z', 't', 'y', 'j', 'k', 'a', 'k', 'l', 'e', 'v', 't'
		};
		insert(l2, arr2);
		
		System.out.print("LinkedList (Before Bubble Sort): ");
		print(l1);
		CompListUtils.bubbleSort(l1);
		System.out.print("Linked List (After Bubble Sort): ");
		print(l1);
		
		System.out.print("Array List (Before Bubble Sort): ");
		print(l2);
		CompListUtils.bubbleSort(l2);
		System.out.print("Array List (After Bubble Sort): ");
		print(l2);
		
		CompList<Character> l3 = new ArrayCompList<>(4);
		Character arr3[] = new Character[] {
			'A', 'B', 'C', 'D'
		};
		insert(l3, arr3);
		
		CompList<Character> l4 = new ArrayCompList<>(4);
		Character arr4[] = new Character[] {
			'H', 'I', 'J', 'K'
		};
		insert(l4, arr4);
		
		System.out.print("List 3: ");
		print(l3);
		System.out.print("List 4: ");
		print(l4);
		
		System.out.print("Combine(l3, l4, 3): ");
		print(CompListUtils.combine(l3, l4, 0));
		
		System.out.print("Combine(l3, l4, 5): ");
		print(CompListUtils.combine(l3, l4, 5));
	}

	private static <T extends Comparable<T>> void insert(CompList<T> l1, T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			l1.insert(arr[i]);
		}
	}

	private static <T extends Comparable<T>> void print(CompList<T> l) {
		if (!l.empty()) {
			boolean last = false;
			l.findFirst();
			while (!last) {
				last = l.last();
				System.out.print(l.retrieve() + " ");
				if (!last) {
					l.findNext();
				}
			}
			System.out.println();
		}
	}
	
}
