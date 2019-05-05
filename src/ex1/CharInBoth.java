package ex1;

import java.util.Scanner;

public class CharInBoth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		String line2 = sc.nextLine();
		char[] chars1 = line1.toCharArray();
		char[] chars2 = line2.toCharArray();

		char itti = ' ';

		boolean moji = false;
		outer: for (int i = 0; i < line1.length(); i++) {

			for (int a = 0; a < line2.length(); a++) {
				if (chars1[i] == chars2[a]) {
					itti = chars1[i];
					moji = true;
					break outer;

				}
			}
		}

		if (moji) {
			System.out.println("同じ文字" + "'" + itti + "'" + "が見つかりました．");
		} else {
			System.out.println("同じ文字が見つかりませんでした．");

		}

	}
}
