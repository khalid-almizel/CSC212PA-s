
public class MyArray<T extends Comparable<T>> implements GArray<T> {

	private T[] Arr11;

	public MyArray(int n) {
		Arr11 = (T[]) new Comparable[n];
	}

	@Override
	public T get(int i) {
		return (T) Arr11[i];
	}

	@Override
	public void set(int i, T e) {
		Arr11[i] = e;

	}

	@Override
	public void resize(int n) {

		T[] tmpArray = (T[]) new Comparable[n];

		if (n >= length()) {
			for (int i = 0; i < length(); i++) {
				tmpArray[i] = Arr11[i];
			}
		} else {
			for (int i = 0; i < n; i++) {
				tmpArray[i] = Arr11[i];
			}
		}
		//		Arr11 = (T[]) new Comparable[n];

	//	for (int j = 0; j < n; j++) {
	//		Arr11[j] = tmpArray[j];

		Arr11 = (T[]) new Comparable[n];

		for (int j = 0; j < n; j++) {
			Arr11[j] = tmpArray[j];
		}
	}

	@Override
	public int length() {

		return Arr11.length;
	}

	@Override
	public void selectionSort(int n, int k) {
		int cntr =0;

		for (int i = 0; i < n && cntr < k; i++) {

			int minimum = i;
			for (int j = i + 1; j < n ; j++ )
				if (Arr11[j].compareTo(Arr11[minimum]) < 0)
					minimum = j;

	
			if(minimum!=i) {
				T base1 = Arr11[minimum];
				Arr11[minimum] = Arr11[i];
				Arr11[i] = base1;
				cntr++;
			}
			if (i >= k - 1)
				return;
		}
	}

}
