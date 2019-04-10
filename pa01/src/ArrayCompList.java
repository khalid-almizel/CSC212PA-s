

	public class ArrayCompList <T extends Comparable<T>> implements CompList<T> {
		private T[] nodes;
		private int mx;
		private int size;
		private int current;
		
		 @SuppressWarnings("unchecked")
		public ArrayCompList(int i) {
			// TODO Auto-generated constructor stub
			mx = i;
			size = 0;
			current = -1;
			nodes = (T[]) new Comparable[i];
		}
		@Override
		public void findFirst() {
			// TODO Auto-generated method stub
			current=0;
			
		}

		@Override
		public void findNext() {
			// TODO Auto-generated method stub
			current=current+1;
		}

		@Override
		public T retrieve() {
			// TODO Auto-generated method stub
				
			
			return nodes[current];
		}

		@Override
		public void update(T e) {
			// TODO Auto-generated method stub
			nodes[current] =e;
			
		}

		@Override
		public void insert(T e) {
			// TODO Auto-generated method stub
			for(int i = size; i > current; --i) {
				nodes[i] = nodes[i];
			}
			current++;
			nodes[current] = e;
			size++;
		}
		

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			for(int i = current + 1; i < size; i++) {
				nodes[i-1] = nodes[i];
			}
			size--;
			if(size == 0) {
				current = -1;
			}
			else if(current == size) {
				current = 0;
			}
		}

		@Override
		public boolean full() {
			// TODO Auto-generated method stub
			return size == mx;

		}

		@Override
		public boolean empty() {
			// TODO Auto-generated method stub
			return size == 0;
		}

		@Override
		public boolean last() {
			// TODO Auto-generated method stub 
			return current + 1 == size;

		}

		@Override
		public int compareToPrevious() {

			int i = nodes[current].compareTo(nodes[current -1]);
		
			if(i < 0) {
				return -1;
			}else if(i> 0) {
				return 1;
			}else {
				return 0;
			}		
			

	
		
		}
		
		@Override
		public void swap() {
			// TODO Auto-generated method stub
			T temp = nodes[current];
			nodes[current] = nodes[current -1];
			nodes[current-1] = temp;
		}
		@Override
		public void findPrevious() {
			// TODO Auto-generated method stub
			current = current - 1;
		}
		@Override
		public boolean first() {
			// TODO Auto-generated method stub
			return current == 0;
		}
			
		


}
