package ex2;

import java.util.Scanner;

public class Fib {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		System.out.println(num + "番目のフィボナッチ数は" + fibo(num) + "です.");

	}

	public static int fibo(int n) {
		if(n==0) {
			return 0;
		}else if(n==1) {
			return 1;
		}else {
			return fibo(n-2)+fibo(n-1);
		}

	}

}
