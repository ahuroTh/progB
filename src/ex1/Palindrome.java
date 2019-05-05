package ex1;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println("文字列を入力してください。");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		boolean iskaibun = true;
		for (int i = 0; i < line.length() / 2; i++) {
			if (line.charAt(i) != line.charAt(line.length() - i - 1)) {
				iskaibun = false;
				break;
			}
		}

		if (iskaibun) {
			System.out.println(line + "は回文です。");
		} else {
			System.out.println(line + "は回文ではありません。");
		}
	}
}
