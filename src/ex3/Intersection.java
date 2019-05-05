package ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class Intersection {
	public static void main(String[] args) {
		int[] myArrayA = new int[10];
		System.out.println("myArrayA:");
		int i = 0;
		while (i < myArrayA.length) {
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			myArrayA[i] = (num);
			i += 1;
		}
		int[] myArrayB = new int[10];
		System.out.println("myArrayB:");
		int k = 0;
		while (k < myArrayB.length) {
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			myArrayB[k] = (num);
			k += 1;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int l = 0; l < myArrayA.length; l++) {
			for (int m = 0; m < myArrayB.length; m++) {
				if (myArrayA[l] == myArrayB[m]) {
					list.add(new Integer(myArrayA[l]));
				}

			}
		}
		System.out.println("Result:");

		for (int n = 0; n < list.size(); n++) {

			Integer[] array = list.toArray(new Integer[list.size()]);
			System.out.println(array[n]);
		}
	}
}
