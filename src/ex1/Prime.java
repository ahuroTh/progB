package ex1;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		System.out.println("整数を入力して下さい。");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		boolean sosu = true;
		for (int i = 2; i*i < num; i++) {
			if (num % i == 0) {
				sosu = false;
				break;
			}
		}

		if (sosu) {
			System.out.println(num + "は素数です。");
		} else {
			System.out.println(num + "は素数ではありません。");

		}
	}

}
