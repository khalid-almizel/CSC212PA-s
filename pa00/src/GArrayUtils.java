
public class GArrayUtils {

	public static <T extends Comparable<T>> GArray<T> union(GArray<T> A, int n, GArray<T> B, int m) {

		GArray<T> GARRAYUNION = GArrayFactory.getGArray(n + m);

		int cntr = 0;

		for (int i = 0; i < n; i++) {
			GARRAYUNION.set(cntr++, A.get(i));
		}

		for (int i = 0; i < m; i++) {
			boolean flag = false;
			T VALUE = B.get(i);

			for (int j = 0; j < GARRAYUNION.length(); j++) {

				if ( GARRAYUNION.get(j) != null) {

					if (GARRAYUNION.get(j).compareTo(VALUE) == 0) {
						flag = true;
					}
				}
			}

			if (!flag)
				GARRAYUNION.set(cntr++, B.get(i));
		}
		GARRAYUNION.resize(cntr);
		return GARRAYUNION;
	}

//	public static interset (GArray<T> A , int n , GArray<T> B,int m)


	public static <T extends Comparable<T>> GArray<T> intersect(GArray<T> A, int n, GArray<T> B, int m) {

		GArray<T> ARR11 = GArrayFactory.getGArray(n + m);

		int counter = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				if (A.get(i).compareTo((B.get(j))) == 0) {

					if (!check(ARR11, A.get(i)))
						ARR11.set(counter++, A.get(i));

				}
			}
		}
		ARR11.resize(counter);
		return ARR11;
	}
    //Helper method
	
	/*for (int j = 0; j < arr.length(); j++) {

			if (arr.get(j) != null) {

				if (arr.get(j).compareTo(val) == 0) {
					checking = true;
				}
			} */
	private static <T extends Comparable<T>> boolean check(GArray<T> arr, T val) {

		boolean checking = false;

		for (int i = 0; i < arr.length(); i++) {

			if (arr.get(i) != null) {
				//if (arr.get(i).equals(val) == 0) {
				if (arr.get(i).compareTo(val) == 0) {
					checking = true;
				}
			}
		}

		return checking;

	}

}
