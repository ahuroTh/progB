package ex2;

import java.util.Scanner;

public class Combination {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int num2 = scan.nextInt();

		System.out.println("comb(" + num + "," + num2 + ")=" + comb(num, num2));

	}

	public static int comb(int m, int n) {
		if (m == n || n == 0) {
			return 1;
		} else {
			return comb(m - 1, n - 1) + comb(m - 1, n);
		}
	}

}
