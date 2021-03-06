import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import struct.Worth;


public class SortTests {

	/*
	 * INSERTION SORT
	 */
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testInsertionsortSmallArr() {
		Integer[] smallArr = {1000,7,15,28,387,-56,-999999999,123123};
		Integer[] smallArrSorted = {-999999999,-56,7,15,28,387,1000,123123};
		Sort.insertionsort(smallArr);
		for (int i = 0; i < smallArr.length; i++) assertEquals(smallArr[i],smallArrSorted[i]);
	}
	
	@Worth (points = 5)
	@Test(timeout = 20)
	public void testInsertionsortLargeArr() {
		Integer[] largeArr = {1,23,22,25,1,4,58,59,23,-58,-77,-9956,123,556,-487,56,-98,-987,-563,584,2364,471,
				-5487,-512741,5624788,568,69532,5481,37,-952,365,65,-9874,5265,1234,66,654,-98752,-3248,
				-8547,2235,22,1,2,3,4,5,6,7,8,9,10,11,112,-1,-2,-3,-4,-5,-6,-7,-8,-9,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		Integer[] largeArrSorted = {-512741,-98752,-9956,-9874,-8547,-5487,-3248,-987,-952,-563,-487,-98,-77,
				-58,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,2,3,4,4,5,6,7,8,9,10,11,22,22,23,23,25,37,56,58,59,65,66,
				112,123,365,471,556,568,584,654,1234,2235,2364,5265,5481,69532,5624788};
		Sort.insertionsort(largeArr);
		for (int i = 0; i < largeArr.length; i++) assertEquals(largeArr[i],largeArrSorted[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testInsertionsortReverseArr() {
		Integer[] reverseArr = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
		Integer[] reverseArrSorted = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Sort.insertionsort(reverseArr);
		for (int i = 0; i < reverseArr.length; i++) assertEquals(reverseArr[i],reverseArrSorted[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testInsertionsortInOrderArr() {
		Integer[] inOrderArr = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Integer[] inOrderArrSorted = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Sort.insertionsort(inOrderArr);
		for (int i = 0; i < inOrderArr.length; i++) assertEquals(inOrderArr[i],inOrderArrSorted[i]);
	}
	
	
	
	/*
	 * QUICKSORT
	 */
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testQuicksortSmallArr() {
		Integer[] smallArr = {1000,7,15,28,387,-56,-999999999,123123};
		Integer[] smallArrSorted = {-999999999,-56,7,15,28,387,1000,123123};
		Random r = new Random();
		Sort.quicksort(smallArr, r);
		for (int i = 0; i < smallArr.length; i++) assertEquals(smallArr[i],smallArrSorted[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 20)
	public void testQuicksortLargeArr() {
		Integer[] largeArr = {1,23,22,25,1,4,58,59,23,-58,-77,-9956,123,556,-487,56,-98,-987,-563,584,2364,471,
				-5487,-512741,5624788,568,69532,5481,37,-952,365,65,-9874,5265,1234,66,654,-98752,-3248,
				-8547,2235,22,1,2,3,4,5,6,7,8,9,10,11,112,-1,-2,-3,-4,-5,-6,-7,-8,-9,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		Integer[] largeArrSorted = {-512741,-98752,-9956,-9874,-8547,-5487,-3248,-987,-952,-563,-487,-98,-77,
				-58,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,2,3,4,4,5,6,7,8,9,10,11,22,22,23,23,25,37,56,58,59,65,66,
				112,123,365,471,556,568,584,654,1234,2235,2364,5265,5481,69532,5624788};
		Random r = new Random();
		Sort.quicksort(largeArr, r);
		for (int i = 0; i < largeArr.length; i++) assertEquals(largeArr[i],largeArrSorted[i]);
	}

	@Worth (points = 3)
	@Test(timeout = 300)
	public void testQuicksortReverseArr() {
		Integer[] reverseArr = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
		Integer[] reverseArrSorted = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Random r = new Random();
		Sort.quicksort(reverseArr, r);
		for (int i = 0; i < reverseArr.length; i++) assertEquals(reverseArr[i],reverseArrSorted[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testQuicksortInOrderArr() {
		Integer[] inOrderArr = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Integer[] inOrderArrSorted = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Random r = new Random();
		Sort.quicksort(inOrderArr, r);
		for (int i = 0; i < inOrderArr.length; i++) assertEquals(inOrderArr[i],inOrderArrSorted[i]);
	}
	
	
	
	/*
	 * MERGESORT
	 */
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testMergesortSmallArr() {
		Comparable[] smallArr = {1000,7,15,28,387,-56,-999999999,123123};
		Comparable[] smallArrSorted = {-999999999,-56,7,15,28,387,1000,123123};
		//Comparable[] arr = {1000,7,15,28,387,-56,-999999999,123123};
		smallArr = Sort.mergesort(smallArr);
		for (int i = 0; i < smallArr.length; i++) assertEquals(smallArr[i],smallArrSorted[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 15)
	public void testMergesortLargeArr() {
		Comparable[] largeArr = {1,23,22,25,1,4,58,59,23,-58,-77,-9956,123,556,-487,56,-98,-987,-563,584,2364,471,
				-5487,-512741,5624788,568,69532,5481,37,-952,365,65,-9874,5265,1234,66,654,-98752,-3248,
				-8547,2235,22,1,2,3,4,5,6,7,8,9,10,11,112,-1,-2,-3,-4,-5,-6,-7,-8,-9,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		Comparable[] largeArrSorted = {-512741,-98752,-9956,-9874,-8547,-5487,-3248,-987,-952,-563,-487,-98,-77,
				-58,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,2,3,4,4,5,6,7,8,9,10,11,22,22,23,23,25,37,56,58,59,65,66,
				112,123,365,471,556,568,584,654,1234,2235,2364,5265,5481,69532,5624788};
		largeArr = Sort.mergesort(largeArr);
		for (int i = 0; i < largeArr.length; i++) assertEquals(largeArr[i],largeArrSorted[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testMergesortReverseArr() {
		Comparable[] reverseArr = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
		Comparable[] reverseArrSorted = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		reverseArr = Sort.mergesort(reverseArr);
		for (int i = 0; i < reverseArr.length; i++) assertEquals(reverseArr[i],reverseArrSorted[i]);
	}

	@Worth (points = 3)
	@Test(timeout = 300)
	public void testMergesortInOrderArr() {
		Comparable[] inOrderArr = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Comparable[] inOrderArrSorted = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		inOrderArr = Sort.mergesort(inOrderArr);
		for (int i = 0; i < inOrderArr.length; i++) assertEquals(inOrderArr[i],inOrderArrSorted[i]);
	}
	
	
	
	/*
	 * RADIXSORT
	 */
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testRadixsortSmallArr() {
		int[] smallArr = {1000,7,15,28,387,-56,-999999999,123123};
		Integer[] smallArrSorted = {-999999999,-56,7,15,28,387,1000,123123};
		smallArr = Sort.radixsort(smallArr);
		for (int i = 0; i < smallArr.length; i++) assertEquals(smallArrSorted[i], (Integer) smallArr[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 30)
	public void testRadixsortLargeArr() {
		int[] largeArr = {1,23,22,25,1,4,58,59,23,-58,-77,-9956,123,556,-487,56,-98,-987,-563,584,2364,471,
				-5487,-512741,5624788,568,69532,5481,37,-952,365,65,-9874,5265,1234,66,654,-98752,-3248,
				-8547,2235,22,1,2,3,4,5,6,7,8,9,10,11,112,-1,-2,-3,-4,-5,-6,-7,-8,-9,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		Integer[] largeArrSorted = {-512741,-98752,-9956,-9874,-8547,-5487,-3248,-987,-952,-563,-487,-98,-77,
				-58,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,2,3,4,4,5,6,7,8,9,10,11,22,22,23,23,25,37,56,58,59,65,66,
				112,123,365,471,556,568,584,654,1234,2235,2364,5265,5481,69532,5624788};
		largeArr = Sort.radixsort(largeArr);
		for (int i = 0; i < largeArr.length; i++) assertEquals(largeArrSorted[i], (Integer) largeArr[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testRadixsortReverseArr() {
		int[] reverseArr = {10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
		Integer[] reverseArrSorted = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		reverseArr = Sort.radixsort(reverseArr);
		for (int i = 0; i < reverseArr.length; i++) assertEquals(reverseArrSorted[i], (Integer) reverseArr[i]);
	}
	
	@Worth (points = 3)
	@Test(timeout = 300)
	public void testRadixsortInOrderArr() {
		int[] inOrderArr = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Integer[] inOrderArrSorted = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		inOrderArr = Sort.radixsort(inOrderArr);
		for (int i = 0; i < inOrderArr.length; i++) assertEquals(inOrderArrSorted[i], (Integer) inOrderArr[i]);
	}
	
}
