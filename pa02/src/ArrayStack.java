
	public class ArrayStack <T> implements Stack<T> {
		private int maxsize;
		private int top;
		private T[] nodes;
		public ArrayStack(int n) {
			maxsize = n;
			top = -1;
			nodes = (T[]) new Object[n];
		}

		@Override
		public T pop() {
			// TODO Auto-generated method stub
			return nodes[top--];
		}

		@Override
		public void push(T e) {
			// TODO Auto-generated method stub
			nodes[++top] = e;

		}

		@Override
		public boolean empty() {
			// TODO Auto-generated method stub
			return top == -1;
		}

		@Override
		public boolean full() {
			// TODO Auto-generated method stub
			return top == maxsize - 1;
		}

		@Override
		public void multiPush(T[] els, int k) {

			// TODO Auto-generated method stub
		if(els==null) {
			return;
		}
			

		for (int i = 0; i < k; i++) {
			if(full()) {
				return;
			}
			
			if((els[i])!=null)
				push(els[i]);			
		
		}
			
		}
//		multiPush(Type els[], int k): requires: None. input: Type els[], int k. results:
//			The k elements of the array els are pushed to the stack one at a time until the
//			stack is full or all k elements are added. output: none.
		@Override
		public Stack<T> copy() {
     		ArrayStack<T> St1 = new ArrayStack<T>(maxsize);
			ArrayStack<T> St2 = new ArrayStack<T>(maxsize);
			
			while(!empty()) {
				T tmp = pop();
				St1.push(tmp);
				
			}
			while(!St1.empty()) {
				T tmp = St1.pop();
				St2.push(tmp);
				push(tmp);
			}
			return St2;
		}
		//copy(Stack: ns): requires: none. input: none. results: Create ns, a copy of
	//	S. S does not change. output: ns.

		@Override
		public void reverse() {
			ArrayStack<T> temp = new ArrayStack<T>(maxsize);
			ArrayStack<T> temp1 = new ArrayStack<T>(maxsize);
			
			while(!empty()) {
				T tmp = pop();
				temp.push(tmp);
			}
			while(!temp.empty()) {
				T tmp = temp.pop();
				temp1.push(tmp);
			}
			while(!temp1.empty()) {
				T tmp = temp1.pop();
				push(tmp);
			}
	
			
			

		}
			
		}


