package ex4;

import java.util.Scanner;

public class LinearInt {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Input 10 data: ");
		int[] myArray = new int[10];

		for (int i = 0; i < myArray.length; i++) {

			int num = scan.nextInt();
			myArray[i] = (num);

		}
		System.out.print("Input key: ");
		int key = scan.nextInt();

		for (int k = 0; k < myArray.length; k++) {
			if (key == myArray[k]) {
				System.out.print("Found");
				System.out.println("[" + k + "]: " + myArray[k]);
			}
		}

	}

}
