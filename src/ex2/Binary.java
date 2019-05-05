package ex2;

import java.util.Scanner;

public class Binary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		printBinary(num);

	}

	public static void printBinary(int n) {
		if (n != 0) {
			printBinary(n / 2);
			System.out.print(n % 2);
		}

	}
}