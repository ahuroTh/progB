package ex2;

import java.util.Scanner;

public class Ack {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int num2 = scan.nextInt();

		System.out.print("ack(" + num + "," + num2 + ")=" + ack(num, num2));

	}

	public static int ack(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if (n == 0) {
			return ack(m - 1, 1);
		} else {
			return ack(m - 1, ack(m, n - 1));
		}

	}
}
