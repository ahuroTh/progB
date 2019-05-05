package ex3;

import java.util.Scanner;

public class MaxMin {
	public static void main(String[] args) {

		int[] myArray = new int[10];
		System.out.println("Input 10 values");
		int i = 0;
		while (i < myArray.length) {
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			myArray[i] = (num);
			i += 1;

		}
		max(myArray);
		min(myArray);

	}

	public static void max(int myArray[]) {

		int a = 0;
		int b = 0;

		for (int i = 0; i < myArray.length; i++) {
			if (a <= myArray[i]) {
				a = myArray[i];

				b = i;

			}

		}
		System.out.print("Max: myArray[" + b + "] ");
		System.out.println(a);
	}

	public static void min(int myArray[]) {

		int a = 2147483647;
		int b = 0;

		for (int i = 0; i < myArray.length; i++) {
			if (a >= myArray[i]) {
				a = myArray[i];

				b = i;

			}

		}
		System.out.print("Min: myArray[" + b + "] ");
		System.out.println(a);

	}
}
