

	public class LinkedCompList <T extends Comparable<T>> implements CompList<T> {

			private Node<T> head;
			private Node<T> current;

			public LinkedCompList () {
				head = current = null;
			}

			public boolean empty () {
				return head == null;
			}

			public boolean last () {
				return current.next == null;
			}
			public boolean full () {
				return false;
			}
			public void findFirst () {
				current = head;
			}
			public void findNext () {
				current = current.next;
			}
			public T retrieve () {
				return current.data;
			}
			public void update (T val) {
				current.data = val;
			}
			public void insert (T val) {
				Node<T> tmp;
				if (empty()) {
					current = head = new Node<T> (val);
				}
				else {
					tmp = current.next;
					current.next = new Node<T> (val);
					current = current.next;
					current.next = tmp;
				}
			}
			public void remove () {
				if (current == head) {
					head = head.next;
				}
				else {
					Node<T> tmp = head;

					while (tmp.next != current)
						tmp = tmp.next;

					tmp.next = current.next;
				}

				if (current.next == null)
					current = head;
				else
					current = current.next;
			}

		
			@Override
			public int compareToPrevious() {
				T curr = current.data;
				findPrevious();
				int r = curr.compareTo(current.data);
				findNext();
				return r;
			}

			@Override
			public void swap() {
				T tmp = current.data;
				findPrevious();
				T tmp2 = current.data;
				current.data = tmp;
				findNext();
				current.data = tmp2;
			}

			@Override
			public void findPrevious() {
				Node<T> t = head;
				if (current == head) {
					return;
				}
				
				while (t.next != current) {
					t = t.next;
				}
				current = t;
			}

			@Override
			public boolean first() {
				return current == head;
			}
		}



