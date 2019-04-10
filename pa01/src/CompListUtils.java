
public class CompListUtils {

	public static <T extends Comparable<T>> void bubbleSort(CompList<T> l) {
		int count = 0;
		boolean sort = false;
		if (l.empty()) return;
		while (!sort) {
			l.findFirst();
			sort = true;
			while (!l.last()) {
				l.findNext();
				if (l.compareToPrevious() < 0) {
					l.swap();
					sort = false;
				}
			}
		}

	}

	public static <T extends Comparable<T>> CompList<T> combine(CompList<T> list1, CompList<T> list2, int k) {
		CompList<T> TheList = new LinkedCompList<T>();


		if (!list1.empty()) {
			int count = 1;
			list1.findFirst();
			while (!list1.last()) {
				list1.findNext();
				count++;
			}
			list1.findFirst();
			for (int i = 0; i < k && i < count; i++) {
				TheList.insert(list1.retrieve());
				list1.findNext();
			}
		}

		if (!list2.empty()) {
			int count = 1;
			list2.findFirst();
			while (!list2.last()) {
				list2.findNext();
				count++;
			}
			int i = 0;
			while (!list2.first() && i < k-1) {
				list2.findPrevious();
				i++;
			}
			
			for (i = 0; i < k && i < count; i++) {
				TheList.insert(list2.retrieve());
				list2.findNext();
			}
			
		}
		return TheList;
	}
}