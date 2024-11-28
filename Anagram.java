/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		while (str1.length() == str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				int testar = 0;
				for (int j = 0; j < str2.length(); j++) {
					if (str1.charAt(i) == str2.charAt(j)) {
						testar++;
						break;
					}
				}
				if (testar == 0) {
					return false;
				}
				if (testar == str1.length()) {
					return true;

				}
			}

		}

		return false;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		str = str.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
		int x = 0;
		while (x < str.length() && str.charAt(x) != ' ') {
			x++;
		}

		String word1 = "";
		String word2 = "";

		if (x < str.length())
			word1 = str.substring(0, x + 1);
		else
			word1 = str;

		if (x + 1 < str.length())
			word2 = str.substring(x + 1);
		else
			word2 = "";

		word2 = word2.replaceAll("[^a-zA-Z]", "");
		return word1 + word2;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		int count = 0;
		String workString = str;
		String newString = "";

		while (count < str.length()) {
			if (workString.isEmpty()) {
				break;
			}

			else {
				int n = (int) (Math.random() * (str.length() - count));
				// bulding the new string, check n in test kus amak!
				newString = newString + workString.charAt(n);
				// take the char and rpalce with ""
				workString = workString.replace(String.valueOf(newString.charAt(newString.length() - 1)), "");
				count++;
			}

			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) == str.charAt(i) && j != i) {
						return newString + str.charAt(j);
					}
				}
			}
		}
		return newString + " " + workString;
	}

}
