package driverScript;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class InterviewPrograms {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * removeDupStr();
		 * 
		 * stringManipulation("Hello welcome to India");
		 */

		/* arrayToLinkedList(); */

		/* reverseString("kannan"); */

		/* System.out.println(reverseNumber(121)); */

		/*findMaxChar("Hello World");*/
		
		int[] test = new int[]  { 0, 1, 2, 2, 2, 2, 5 };
		System.out.println(removeDuplicateValue(test));

	}

	/*
	 * Method to remove duplicates from array in Java, without using Collection
	 * classes e.g. Set or ArrayList. Algorithm for this method is simple, it first
	 * sort the array and then compare adjacent objects, leaving out duplicates,
	 * which is already in the result.
	 */

	public static void removeDupStr() throws IOException {

		int[][] test = new int[][] { { 1, 1, 2, 2, 3, 4, 5 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 1, 1, 1, 1, 1 }, };

		for (int[] input : test) {
			System.out.println("Array with Duplicates       : " + Arrays.toString(input));
			System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
		}

	}

	public static int[] removeDuplicates(int[] numbersWithDuplicates) throws IOException {

		Arrays.sort(numbersWithDuplicates);

		int[] result = new int[numbersWithDuplicates.length];

		int previous = numbersWithDuplicates[0];

		result[0] = previous;

		for (int i = 1; i < numbersWithDuplicates.length; i++) {

			int ch = numbersWithDuplicates[i];

			if (previous != ch) {

				result[i] = ch;
			}

			previous = ch;
		}

		return result;

	}

	public static void stringManipulation(String str) throws IOException {

		String[] str1 = str.split(" ");

		for (int i = 0; i <= str1.length; i++) {

			char[] ch = str1[i].toCharArray();

			System.out.println(ch[0]);
		}
	}

	/*
	 * To convert an array into a java.util.LinkedList we can use the
	 * java.util.Arrays class�s asList() method. The Arrays class in the java.util
	 * package provides a utility method to convert an array to a List. The
	 * Arrays.asList() method will convert an array to a fixed size List. To create
	 * a LinkedList, we just need to pass the List to the constructor of the
	 * java.util.LinkedList class. A java.util.ArrayList could be created in this
	 * way too.
	 */
	public static void arrayToLinkedList() throws IOException {

		String[] str = new String[] { "Koushic", "Priya", "Kannan" };

		LinkedList<String> ll = new LinkedList<>(Arrays.asList(str));

		Iterator iterator = ll.iterator();

		while (iterator.hasNext()) {

			System.out.println((String) iterator.next());
		}
	}

	public static void reverseString(String str) throws IOException {

		int len = str.length();

		String revWord = "";

		for (int i = len - 1; i >= 0; i--) {

			revWord = revWord + str.charAt(i);
			System.out.println(revWord);
		}

	}

	public static boolean reverseNumber(int num) throws IOException {

		/* System.out.println("Before Reversing :: "+num); */

		int r, re = 0, originalNum;
		originalNum = num;

		while (num != 0) {

			r = num % 10;
			re = re * 10 + r;
			num = num / 10;
		}

		/* System.out.println("After reversing :: "+re); */

		if (originalNum == re) {

			return true;
		}
		return false;

	}

	public static boolean isPrime(int n) throws IOException {

		for (int i = 2; i <= n; i++) {

			if (n % i == 0) {
				return false;
			}
		}

		return true;

	}

	public static void findMaxChar(String str) throws IOException {

		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		

			char[] charArray = str.toLowerCase().toCharArray();

		
				for (char c : charArray) {

					if (hashMap.containsKey(c)) {

						hashMap.put(c, hashMap.get(c) + 1);
					} else {

						hashMap.put(c, 1);
					}
				}
				
				
				Character repeatedWord = null;
				int count = 0;
				
				Set<Entry<Character, Integer>> entrySet = hashMap.entrySet();
				
				for(Entry<Character, Integer> entry : entrySet) {
					
					if(entry.getValue() > count) {
						
						repeatedWord = entry.getKey();
						count = entry.getValue();
					}
				}
				
				System.out.println("The most repeated word in input file is : "+repeatedWord);
		        
		        System.out.println("Number Of Occurrences : "+count);

			}

		
	public static int[] removeDuplicateValue(int[] arr) throws IOException{
		
		Set<Integer> setMap = new HashSet<Integer>();
		
		int len = arr.length;
		
		for(int i = 0; i < len; i++) {
			
			setMap.add(arr[i]);
		}
		
		Iterator<Integer> it = setMap.iterator();
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
		}
		
		return arr;
	}

}
