package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {
	public static void main(String args[]) {
		int[] myArray;
		int nData = 10;
		if (args.length > 0) {
			nData = Integer.parseInt(args[0]);
		}
		myArray = new int[nData];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		try {
			System.out.println("Input " + myArray.length + " data:");
			for (int i = 0; i < myArray.length; i++) {
				line = reader.readLine();
				myArray[i] = Integer.parseInt(line);
			}
			/* ここでmyArrayをソートする．*/
			System.out.println("Result:");
			for (int x : myArray) {
				System.out.println(x);
			}
		} catch (IOException e) {
		}
	}
}
