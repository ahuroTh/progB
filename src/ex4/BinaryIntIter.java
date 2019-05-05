package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryIntIter {
	public static void main(String args[]) {
		int[] myArray;

		myArray = new int[10];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		try {
			System.out.print("Input " + myArray.length + " data: ");
			for (int i = 0; i < myArray.length; i++) {
				line = reader.readLine();
				myArray[i] = Integer.parseInt(line);
			}
			System.out.print("Input key: ");
			line = reader.readLine();
			int key = Integer.parseInt(line);

			int p; // position
			p = binarySearch(myArray, 0, myArray.length - 1, key);
			if (p == -1) {
				System.out.println("Not Found");
			} else {
				System.out.println("Found at myArray[" + p + "] " + myArray[p]);
			}
		} catch (IOException e) {
		}
	}

	public static int binarySearch(int[] a, int left, int right, int x) {


		while (left <= right) {
			int mid = (left + right) / 2;
			if (a[mid] == x) {
				return mid;

			} else if (a[mid] > x) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;

	}

}
