
public class LinkedQueue <T extends Comparable<T>> implements Queue<T> {
		private Node<T> head, tail;
		private int size;
		public LinkedQueue() {
			head = tail = null;
			size = 0;
		}

		@Override
		public T serve() {
			// TODO Auto-generated method stub
			T x = head.data;
			head = head.next;
			size--;
			if(size == 0)
				tail = null;
			return x;
		
		}

		@Override
		public void enqueue(T e) {
			// TODO Auto-generated method stub
			if(tail == null){
				head = tail = new Node<T>(e);
			}
			else {
				tail.next = new Node<T>(e);
				tail = tail.next;
			}
			size++;

			
		}

		@Override
		public int length() {
			// TODO Auto-generated method stub
			return size;
		}

		@Override
		public boolean full() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int multiEnqueue(T[] els, int k) {
			int l=0;


			if(els==null) {
				return 0;
			}
			
			for (int i = 0; i < k ; i++) {

				if(i<els.length) {
					enqueue(els[i]);
					l++;
				}
				
			}
			return l;

		}


		private class Node<T> {
			public T data;
			public Node<T> next;
			
			public Node() {
				data = null;
				next = null;
			}
			
			public Node(T val) {
				data = val;
				next = null;
			}

			public T getData() {
				return data;
			}

			public void setData(T data) {
				this.data = data;
			}

			public Node<T> getNext() {
				return next;
			}

			public void setNext(Node<T> next) {
				this.next = next;
			}

			// Setters/Getters?
		}
}




