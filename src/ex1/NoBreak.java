package ex1;

import java.util.Scanner;

public class NoBreak {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char[] chars = line.toCharArray();

		boolean found = true;
		for (int i = 0; i < line.length(); i++) {
			if (found) {
				if (chars[i] == 'X') {

					found = false;
					continue;

				}
				System.out.print(".");

			}

		}

		if (found) {
			System.out.println("Xが見つかりませんでした．");
		} else {
			System.out.println("Xが見つかりました．");
		}
	}
}
