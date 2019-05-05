package ex3;

import java.util.Scanner;

public class Inverse {
	public static void main(String[] args) {
		int[] myArray;

		myArray = new int[10];
		System.out.println("Input 10 values");
		for (int i = 0; i < myArray.length; i++) {

			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			myArray[i] = (num);

		}
		System.out.println("Result: ");
		calcSum(myArray);

	}

	public static void calcSum(int myArray[]) {

		for (int i = myArray.length - 1; i >= 0; i--) {
			System.out.println(myArray[i]);
		}

	}

}
