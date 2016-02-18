import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import struct.Worth;

public class StringSearchTests {
	
	private String text1 = "there are countries like the country there with the therin language there. there is the chance the country is not there but there is the therin language there. so remember to find therin in that country there.";
	private String pattern1 = "there is the therin language there";
	private Integer[] ans1 = {124};
	private List<Integer> answer1 = new ArrayList<Integer>(Arrays.asList(ans1));

	private String text2 = "Sometimes a phrase is just a phrase so take a phrase at face value";
	private String pattern2 = "a phrase";
	private Integer[] ans2 = {10, 27, 44};
	private List<Integer> answer2 = new ArrayList<Integer>(Arrays.asList(ans2));

	private String text3 = "Don't We Say! 'don't do that' So 'Don't do that'";
	private String pattern3 = "Don't";
	private Integer[] ans3 = {0, 34};
	private List<Integer> answer3 = new ArrayList<Integer>(Arrays.asList(ans3));

	private String text4 = "aaaaaaaaaaaaa";
	private String pattern4 = "aaa";
	private Integer[] ans4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	private List<Integer> answer4 = new ArrayList<Integer>(Arrays.asList(ans4));

	private String text5 = "aabbaadabbaadoobaabbaabbaa";
	private String pattern5 = "aabbaa";
	private Integer[] ans5 = {0, 16, 20};
	private List<Integer> answer5 = new ArrayList<Integer>(Arrays.asList(ans5));

	private String text6 = "in a short haystack";
	private String pattern6 = "here is a long string to find";
	private Integer[] ans6 = { };
	private List<Integer> answer6 = new ArrayList<Integer>(Arrays.asList(ans6));

	private String text7 = "Sometimes a string at the end is a troublesome string";
	private String pattern7 = "string";
	private Integer[] ans7 = {12, 47};
	private List<Integer> answer7 = new ArrayList<Integer>(Arrays.asList(ans7));
	
	
	@Test (timeout = 300)
	@Worth (points = 4)
	public void testBoyerMoore1() {
		assertEquals(answer1, StringSearch.boyerMoore(pattern1, text1));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testBoyerMoore2() {
		assertEquals(answer2, StringSearch.boyerMoore(pattern2, text2));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testBoyerMoore3() {
		assertEquals(answer3, StringSearch.boyerMoore(pattern3, text3));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testBoyerMoore4() {
		assertEquals(answer4, StringSearch.boyerMoore(pattern4, text4));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testBoyerMoore5() {
		assertEquals(answer5, StringSearch.boyerMoore(pattern5, text5));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testBoyerMoore6() {
		assertEquals(answer6, StringSearch.boyerMoore(pattern6, text6));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testBoyerMoore7() {
		assertEquals(answer7, StringSearch.boyerMoore(pattern7, text7));
	}
	
	
	@Test (timeout = 300)
	@Worth (points = 4)
	public void testKMP1() {
		assertEquals(answer1, StringSearch.kmp(pattern1, text1));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testKMP2() {
		assertEquals(answer2, StringSearch.kmp(pattern2, text2));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testKMP3() {
		assertEquals(answer3, StringSearch.kmp(pattern3, text3));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testKMP4() {
		assertEquals(answer4, StringSearch.kmp(pattern4, text4));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testKMP5() {
		assertEquals(answer5, StringSearch.kmp(pattern5, text5));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testKMP6() {
		assertEquals(answer6, StringSearch.kmp(pattern6, text6));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testKMP7() {
		assertEquals(answer7, StringSearch.kmp(pattern7, text7));
	}
	
	
	@Test (timeout = 300)
	@Worth (points = 4)
	public void testRabinKarp1() {
		assertEquals(answer1, StringSearch.rabinKarp(pattern1, text1));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testRabinKarp2() {
		assertEquals(answer2, StringSearch.rabinKarp(pattern2, text2));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testRabinKarp3() {
		assertEquals(answer3, StringSearch.rabinKarp(pattern3, text3));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testRabinKarp4() {
		assertEquals(answer4, StringSearch.rabinKarp(pattern4, text4));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testRabinKarp5() {
		assertEquals(answer5, StringSearch.rabinKarp(pattern5, text5));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testRabinKarp6() {
		assertEquals(answer6, StringSearch.rabinKarp(pattern6, text6));
	}

	@Test (timeout = 300)
	@Worth (points = 4)
	public void testRabinKarp7() {
		assertEquals(answer7, StringSearch.rabinKarp(pattern7, text7));
	}


	@Test (timeout = 300)
	@Worth (points = 4)
	public void testHash1() {
		int orig = StringSearch.hashString("tire");
		int prev = StringSearch.hashString("xtir");
		int update = StringSearch.updateHash(prev, 'e', 'x', 4);
		assertEquals(orig, update);
	}
	
	@Test (timeout = 300)
	@Worth (points = 4)
	public void testHash2() {
		int orig = StringSearch.hashString("reallylongthingthatwilloverflow");
		int prev = StringSearch.hashString("xreallylongthingthatwilloverflo");
		int update = StringSearch.updateHash(prev, 'w', 'x', 31);
		assertEquals(orig, update);
	}
	
	@Test (timeout = 300)
	@Worth (points = 4)
	public void testKMPTable1() {
		int[] output = StringSearch.buildKmpSuffixTable("aabcaaaabc");
		int[] answer = {-1, 0, 1, 0, 0, 1, 2, 2, 2, 3};
		
		assertEquals(answer.length, output.length);
		
		boolean method1 = true;
		boolean method2 = true;
		for (int i = 1; i < output.length; i++) {
			if (output[i] != answer[i]) {
				method1 = false;
			}
			if (output[i - 1] != answer[i]) {
				method2 = false;
			}
		}
		
		assertTrue(method1 || method2);
	}
	
	@Test (timeout = 300)
	@Worth (points = 4)
	public void testBoyerMooreTable1() {
		int[] output = StringSearch.buildBoyerMooreCharTable("Don't We Say! 'don't do that' So 'Don't do that'");
		int[] answer1 = new int[Character.MAX_VALUE + 1];
		Arrays.fill(answer1, -1);
		answer1['\''] = 1;
		answer1['t'] = 1;
		answer1['a'] = 2;
		answer1['h'] = 3;
		answer1[' '] = 5;
		answer1['o'] = 6;
		answer1['d'] = 7;
		answer1['n'] = 11;
		answer1['D'] = 13;
		answer1['S'] = 17;
		answer1['!'] = 35;
		answer1['y'] = 36;
		answer1['e'] = 40;
		answer1['W'] = 41;
		int[] answer2 = new int[Character.MAX_VALUE + 1];
		Arrays.fill(answer2, -1);
		answer2['\''] = 47;
		answer2['t'] = 46;
		answer2['a'] = 45;
		answer2['h'] = 44;
		answer2[' '] = 42;
		answer2['o'] = 41;
		answer2['d'] = 40;
		answer2['n'] = 36;
		answer2['D'] = 34;
		answer2['S'] = 30;
		answer2['!'] = 12;
		answer2['y'] = 11;
		answer2['e'] = 7;
		answer2['W'] = 6;
		
		assertEquals(answer1.length, output.length);
		
		
		boolean method1 = true;
		boolean method2 = true;
		for (int i = 0; i < output.length; i++) {
			if (answer1[i] > 0 && output[i] != answer1[i]) {
				method1 = false;
			}
			if (answer2[i] > 0 && output[i] != answer2[i]) {
				method2 = false;
			}
		}
		
		assertTrue(method1 || method2);
	}
	

}