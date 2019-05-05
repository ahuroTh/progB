package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find2 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("使用法： java Find1 検索文字列 < 検索対象ファイル");
			System.out.println("例： java Find1 System < Find1.java");
			System.exit(0);
		}
		String findstring = args[0];
		System.out.println("検索文字列は「" + findstring + "」です。");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line;
			int linenum = 1;
			//lineが
			while ((line = reader.readLine()) != null) {

				if (line.startsWith(findstring)) {
					System.out.println(linenum + ":" + line);
				}
				 linenum++;

			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
