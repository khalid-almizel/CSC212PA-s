
public class SearchHistoryUtils {
	public static int countWordOnly(SearchHistory h, List<String> words) {

		return 0;
	}

	public static int countPrefixOnly(SearchHistory h, List<String> prefixes) {

		int CPF = 0;
		if (!prefixes.empty()) {
			prefixes.findFirst();
			while (!prefixes.last()) {
				String p = prefixes.retrieve();
				if (h.findPrefix(p) && !h.findWord(p)) {
					CPF++;
				}
				prefixes.findNext();
			}
			String p = prefixes.retrieve();
			if (h.findPrefix(p) && !h.findWord(p)) {
				CPF++;
			}
		}

		return CPF;

	}
}
