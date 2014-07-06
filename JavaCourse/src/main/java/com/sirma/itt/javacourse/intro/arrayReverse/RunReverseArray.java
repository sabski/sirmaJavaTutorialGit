package com.sirma.itt.javacourse.intro.arrayReverse;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author simeon
 */
public final class RunReverseArray {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		ReverseArray reverse = new ReverseArray();
		System.out.println(arr.toString());
		System.out.println(reverse.reverseArray(arr).toString());
	}

	/**
	 * 
	 */
	private RunReverseArray() {

	}
}
