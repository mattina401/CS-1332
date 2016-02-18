import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

//name : Jongyeon Kim(jkim989)
//GTID# : 903018469

public class Sort {
	
	/**
	 * Implement insertion sort.
	 * 
	 * It should be:
	 *  inplace
	 *  stable
	 *  
	 * Have a worst case running time of:
	 *  O(n^2)
	 *  
	 * And a best case running time of:
	 *  O(n)
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<T>> void insertionsort(T[] arr) {
		// TODO Auto-generated method stub
		
		int i = 0;
		while (i < arr.length) {
			int idx = i - 1;
			T value = arr[i];
			
			// when index is more than 0 and value is smaller than index
			while ((idx >= 0) && (value.compareTo(arr[idx]) < 0)) {
				
				// swap
				arr[idx + 1] = arr[idx];
				idx--;
			}
			i++;
			arr[idx + 1] = value;
		}
	}
	
	/**
	 * Implement quick sort. 
	 * 
	 * Use the provided random object to select your pivots.
	 * For example if you need a pivot between a (inclusive)
	 * and b (exclusive) where b > a, use the following code:
	 * 
	 * int pivotIndex = r.nextInt(b - a) + a;
	 * 
	 * It should be:
	 *  inplace
	 *  
	 * Have a worst case running time of:
	 *  O(n^2)
	 *  
	 * And a best case running time of:
	 *  O(n log n)
	 * 
	 * @param arr
	 */
	public static <T extends Comparable<T>> void quicksort(T[] arr, Random r) {
		// TODO Auto-generated method stub
		
		recurcive(0, arr.length - 1, arr, r);
	}
	
	// helper for method quicksort
	private static <T extends Comparable<T>> void recurcive(int left, int right, T[] arr, Random r) {
		
		// when left index is smaller than right index
		if (left < right) {
			int partition = partition(arr, left, right, r.nextInt(right - left) + left);
			recurcive(partition, right, arr, r);
			recurcive(left, partition - 1, arr, r);
		}
	}
	
	private static <T extends Comparable<T>> int partition(T[] arr, int left, int right, int pivot) {
		
		T value = arr[pivot];
		
		// when left index is smaller than right index
		while (left <= right) {
			
			// during left value is smaller than pivot value, move to right
			while (arr[left].compareTo(value) < 0) {
				left++;
			}
			
			//// during right value is smaller than pivot value, move to left
			while (arr[right].compareTo(value) > 0) {
				right--;
			}
			
			// when left is same right or left is smaller than right
			if (left <= right) {
				
				// swap
				T temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		
		// return left
		return left;
	}

	
	/**
	 * Implement merge sort.
	 * 
	 * It should be:
	 *  stable
	 *  
	 * Have a worst case running time of:
	 *  O(n log n)
	 *  
	 * And a best case running time of:
	 *  O(n log n)
	 *  
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T[] mergesort(T[] arr) {
		// TODO Auto-generated method stub
		
		// if there is one or zero element in the array
		if (arr.length < 2) {
			return arr;
		}
		T[] array1 = (T[]) new Comparable[arr.length / 2];
		T[] array2 = (T[]) new Comparable[arr.length - array1.length];
		
		// elements copy from original array to new array
		System.arraycopy(arr, 0, array1, 0, array1.length);
		System.arraycopy(arr, array1.length, array2, 0, array2.length);
		return merging(arr, mergesort(array1), mergesort(array2));
	}

	private static <T extends Comparable<T>> T[] merging(T[] sortedArray, T[] array1, T[] array2) {
		
		int a = 0;
		int b = 0;
		int c = 0;
		while ((a < array1.length) && (b < array2.length)) {
			
			// if array1 is smaller than array2
			if (array1[a].compareTo(array2[b]) <= 0) {
				
				// put array1 into sortedArray
				sortedArray[c] = array1[a];
				a++;
			}
			
			// if array2 is smaller than array2
			else {
				
				// put array2 into sortedArray
				sortedArray[c] = array2[b];
				b++;
			}
			c++;
		}
		
		// put remaining elements of array1 into sortedArray
		while (a < array1.length) {
			sortedArray[c] = array1[a];
			a++;
			c++;
		}
		
		// put remaining elements of array2 into sortedArray
		while (b < array2.length) {
			sortedArray[c] = array2[b];
			b++;
			c++;
		}
		return sortedArray;
	}
	
	/**
	 * Implement radix sort
	 * 
	 * Hint: You can use Integer.toString to get a string
	 * of the digits. Don't forget to account for negative
	 * integers, they will have a '-' at the front of the
	 * string.
	 * 
	 * It should be:
	 *  stable
	 *  
	 * Have a worst case running time of:
	 *  O(kn)
	 *  
	 * And a best case running time of:
	 *  O(kn)
	 * 
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static int[] radixsort(int[] arr) {
		// TODO Auto-generated method stub
		
		// if there are not negative numbers in the array
		if (nagativeNum(arr) == false) {

			// make new sorted array
			String[] sorted = new String[arr.length];

			// make numbers to same length of String
			int a = 0;
			while (a < arr.length) {
				sorted[a] = addZeroes(Integer.toString(toGetMaxNum(arr)).length() - Integer.toString(arr[a]).length(), Integer.toString(arr[a]));
				a++;
			}
	
			// make a new linked-list for sort by digit numbers(0~9)
			LinkedList<String>[] list = (LinkedList<String>[]) new LinkedList[10];
			ArrayList<String> numbers = new ArrayList<String>();
			
			int b = 0;
			// initialization for linked-list
			while (b < list.length) {
				list[b] = new LinkedList<String>();
				b++;
			}
			
			// get least significant number
			int c = Integer.toString(toGetMaxNum(arr)).length();
			
			// looping
			while (c > 0) {
				int i = 0;
				while (i < arr.length) {
					
					// add the number to the linked-list
					list[Integer.parseInt(sorted[i].charAt(c - 1) + "")].add(sorted[i]);
					i++;
				}

				// looping
				int j = 0;
				while (j < list.length) {
					
					// add numbers to array
					numbers.addAll(list[j]);
					
					// make empty linked-list
					list[j].clear();
					j++;
				}
				numbers.toArray(sorted);
				
				// make empty array
				numbers.clear();
				c--;
			}
			
			// looping
			int d = 0;
			while (d < sorted.length) {
				arr[d] = Integer.parseInt(sorted[d]);
				d++;
			}
		} 
		
		// if there are negative numbers in the array
		if (nagativeNum(arr) == true) {
			int maxNeg = maxNegativeNum(arr) * -1;
			int i = 0;
			while (i < arr.length) {
				arr[i]= arr[i] + maxNeg;
				i++;
			}
			arr = radixsort(arr);
			for (int j = 0; j < arr.length; j++) {
				arr[j] = arr[j] - maxNeg;
			}
		}
		return arr;
	}

	private static boolean nagativeNum(int[] arr) {
		
		// check there is negative numbers or not
		int i = 0;
		while (i < arr.length) {
			while (arr[i] < 0) {
				
				//array have negative numbers
				return true;
			}
			i++;
		}
		
		// array does not have negative numbers
		return false;
	}

	// find max negative number
	private static int maxNegativeNum(int[] arr) {
		
		int minNum = 0;
		int i = 0;
		while (i < arr.length) {
			while (arr[i] < minNum) {
				minNum = arr[i];
			}
			i++;
		}
		return minNum;
	}

	// add zeroes at the front of numbers to make same digit as max number
	private static String addZeroes(int zeroes,String number) {
		
		int i = 0;
		while (i < zeroes) {
			number = "0" + number;
			i++;
		}
		return number;
	}

	// find max number
	private static int toGetMaxNum(int[] arr) {
		
		int maxNumber = 0;
		int i = 0;
		while (i < arr.length) {
			while (arr[i] > maxNumber) {
				maxNumber = arr[i];
			}
			i++;
		}
		return maxNumber;
	}
}