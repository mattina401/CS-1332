import java.util.ArrayList;
import java.util.List;

//jkim989(Jongyeon Kim)
// GTID : 903018469

public class StringSearch {

	/**
	 * Find all instances of pattern in text using Boyer-Moore algorithm.
	 * Use buildBoyerMooreCharTable to build your reference table.
	 * 
	 * @param pattern
	 * The String to find
	 * @param test
	 * The String to look through
	 * @return
	 * A List of starting indices where pattern was found in text
	 */
	public static List<Integer> boyerMoore(String pattern, String text) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		if (pattern != null && text != null && pattern.length() != 0 && text.length() != 0) {
			
			int[] map = buildBoyerMooreCharTable(pattern);
			int p = pattern.length();
			int t = text.length();
			
			int i = p - 1;
			if (i > t - 1)
				return list;
			
			int j = p - 1;
			
			int k = p - 1;
			do {
				if (pattern.charAt(j) == text.charAt(i))
					if (j == 0) {
						if (!list.contains(i))
						list.add(i); // match
						i = i + pattern.length();
						j = p - 1;
					} else { // looking glass heuristic: proceed right to left
						i--;
						j--;
				} else { // character jump heuristic
					
					k = k + map[text.charAt(i)];
					i = k - 1;
					j = p - 1;
				}
			} while (i <= t - 1);
			
		}
		
		
		return list; 
	}

	/**
	 * Creates a table of distances from each character to the end.
	 * Has an entry for every character from 0 to Character.MAX_VALUE.
	 * For use with Boyer-Moore.
	 *
	 * If the character is in the string:
	 * 		map[c] = length - last index of c - 1
	 * Otherwise:
	 * 		map[c] = length
	 *
	 * @param pattern
	 * The string being searched for
	 * @return
	 * An int array for Boyer-Moore
	 */
	public static int[] buildBoyerMooreCharTable(String pattern) {
		int[] map = new int[Character.MAX_VALUE + 1]; // assume ASC2 character set
		
		for (int i = Character.MIN_VALUE; i < map.length; i++) {
			map[i] = pattern.length(); // initialize array
		}
		
		for (int j = 0; j < pattern.length(); j++) {
			if (map[pattern.charAt(j)] == pattern.length()) {
				map[pattern.charAt(j)] = Math.max(pattern.length() - j - 1, 1);
			}
			else{
				map[pattern.charAt(j)] = Math.max(1,Math.min(pattern.length() - j - 1, map[pattern.charAt(j)]));
			}
				
		}
		return map;
	}	
	




	/**
	 * Find all instances of pattern in text using Knuth-Morris-Pratt algorithm.
	 * Use buildKmpSuffixTable to build your reference table.
	 * 
	 * @param pattern
	 * The String to find
	 * @param test
	 * The String to look through
	 * @return
	 * A List of starting indices where pattern was found in text
	 */
	public static List<Integer> kmp(String pattern, String text) {
		
		List<Integer> list = new ArrayList<Integer>();
		
        if (pattern != null && text != null && pattern.length() != 0 && text.length() != 0) {
        	
    		int t = text.length();
    		int p = pattern.length();
    		
       		int k = p - 1;
    			if (k > t - 1)
    				return list;
    		
    		int[] fail = buildKmpSuffixTable(pattern);
    		
    		int i = 0;
    		int j = 0;
    		while (i < t) {
    			if (pattern.charAt(j) == text.charAt(i)) {
    				if (j == p - 1) {
    					list.add(i - p + 1);
    					i = i - p + 2;
    					j = 0;
    				} else {
    					i++;
    					j++;
    				}
    			}
    			else if (j > 0) {
    				j = fail[j];
    				
    			}
    			else
    				i++;
    		}
            
        }
		
		return list; // no match
	}

	/**
	 * Creates a table of matching suffix and prefix sizes.
	 * For use with Knuth-Morris-Pratt.
	 *
	 * If i = 0:
	 * 		map[i] = -1
	 * If i > 0:
	 * 		map[i] = size of largest common prefix and suffix for substring of size i
	 *
	 * @param pattern
	 * The string bing searched for
	 * @return
	 * An int array for Knuth-Morris-Pratt
	 */
	public static int[] buildKmpSuffixTable(String pattern) {
		
		int[] fail = new int[pattern.length()];
		
		if (pattern.length() > 1) {
			fail[0] = -1;
			fail[1] = 0;
			int m = pattern.length();
			int j = 0;
			int i = 1;
			while (i < m-1) {
				if (pattern.charAt(j) == pattern.charAt(i)) {
					fail[i + 1] = j + 1;
					i++;
					j++;
				}
				else if (j > 0) {
					j = 0;
				}
		
				else {
					fail[i + 1] = 0;
					i++;
				}
			}
			
		} else if (pattern.length() == 1) {
			fail[0] = -1;
		}
		
		
		return fail;
	}

	// This is the base to be used for Rabin-Karp. No touchy.
	private static final int BASE = 997;

	/**
	 * Find all instances of pattern in text using Rabin-Karp algorithm.
	 * Use hashString and updateHash to handle hashing.
	 *
	 * @param pattern
	 * The String to find
	 * @param test
	 * The String to look through
	 * @return
	 * A List of starting indices where pattern was found in text
	 */
	public static List<Integer> rabinKarp(String pattern, String text) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		if (pattern != null && text != null && pattern.length() != 0 && text.length() != 0) {
			
			int p = pattern.length();
			int t = text.length();
			
    		int k = p - 1;
			if (k > t - 1)
				return list;
			
			
			int hashedPattern = hashString(pattern);
			int hashedFirst = hashString(text.substring(0, pattern.length()));
			
	        if (pattern == null || text == null) {
	            return list;
	    }
			
			
			int i = 0;
			
			while (i < t - p + 1) {
				if (hashedPattern == hashedFirst && compareChar(pattern, text.substring(i, i + p))) {
					list.add(i);
					i++;
					if (i!= t - p + 1) {
						hashedFirst = updateHash(hashedFirst, text.charAt(i + pattern.length() - 1), text.charAt(i - 1), pattern.length());
					}
					
				}
				else if (hashedPattern != hashedFirst) {
					i++;
					if (i!= t - p + 1) {
						hashedFirst = updateHash(hashedFirst, text.charAt(i + pattern.length() - 1), text.charAt(i - 1), pattern.length());
					}
				}
				
			}
		}
			
		return list;
	}
	
	
	private static boolean compareChar(String pattern, String text) {
		
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != text.charAt(i)) {
				return false;
			}
			
		}
			return true;
	}
	

	/**
	 * Hashes a string in a specified way.
	 * For use with Rabin-Karp.
	 *
	 * This hash function will use BASE and the indices of the characters.
	 * Each character at i is multiplied by BASE raised to the power of length - 1 - i
	 * These values are summed to determine the entire hash.
	 *
	 * For example:
	 * Hashing "bunn" as a substring of "bunny" with base 433
	 * hash = b * 433 ^ 3 + u * 433 ^ 2 + n * 433 ^ 1 + n * 433 ^ 0
	 *      = 98 * 433 ^ 3 + 117 * 433 ^ 2 + 110 * 433 ^ 1 + 110 * 433 ^ 0
	 *      = 7977892179
	 *
	 * @param pattern
	 * The String to be hashed
	 * @return
	 * A hash value for the string
	 */
	public static int hashString(String pattern) {
		
		int hashed = 0;
		for (int i = 0; i < pattern.length(); i ++) {
			hashed = hashed + pow((int)pattern.charAt(i), pattern.length() - i - 1);
			
		}
		return hashed;
	}
	
	public static int pow(int character, int length) {
		
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				character = character*BASE;
			}
		}
			return character;
	}
	

	/**
	 * Updates the oldHash in a specified way.
	 * Follows the same hash formula as hashString.
	 * For use with Rabin-Karp.
	 *
	 * To update the hash, remove the oldChar times BASE raised to the length - 1,
	 * 		multiply by BASE, and add the newChar.
	 * For example:
	 * Shifting from "bunn" to "unny" in "bunny" with base 433
	 * hash("unny") = (hash("bunn") - b * 433 ^ 3) * 433 + y * 433 ^ 0
	 *              = (7977892179 - 98 * 433 ^ 3) * 433 + 121 * 433 ^ 0
	 *              = 9519051770
	 *
	 * @param oldHash
	 * The old hash to be updated
	 * @param newChar
	 * The new character added at the end of the substring
	 * @param oldChar
	 * The old character being removed from the front of the substring
	 * @param length
	 * The length of the hashed substring
	 */
	public static int updateHash(int oldHash, char newChar, char oldChar, int length) {
		
		return (int) ((oldHash - powChar(oldChar, length))*BASE + newChar*Math.pow(BASE, 0));
	}
	
	
	public static int powChar(int character, int length) {
		
		for (int i = 0; i < length - 1; i++) {
			character = character*BASE;
		}
		
		return character;
	}

}