package ex1;

import java.util.Scanner;

public class NoDoWhile {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (i < 1) {
			String line = sc.nextLine();
			System.out.println("You said: " + line);
			if (line.equals("bye")) {
				break;
			}
		}
	}

}