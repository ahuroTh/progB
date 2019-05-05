package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertSort2 {
	public static int findPosAndShift(int[] a, int p, int j) {
		//右にずらす
		//j     i=2tosuru  j=a[2] p=2
		//p     i=3   j=a[3] p=3
		while (p > 0 && a[p - 1] > j) {//a[1]>a[2]
			p--;
			a[p + 1] = a[p];
		}

		return p;

	}

	public static void insertSort(int[] a) {
		//d i番目の値
		//p i番目の値が入る位置
		for (int i = 1; i < a.length; i++) {
			int d = a[i];
			int p = findPosAndShift(a, i, d);
			a[p] = d;
		}
	}

	public static void main(String[] args) {
		int[] myArray;
		int nData = 10;
		if (args.length > 0) {
			nData = Integer.parseInt(args[0]);
		}
		myArray = new int[nData];
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		//引数の分、数字を入力
		try {
			System.out.println("Input " + myArray.length + " data:");
			for (int i = 0; i < myArray.length; i++) {
				line = reader.readLine();
				myArray[i] = Integer.parseInt(line);
			}
			/* ここでmyArrayをソートする．*/
			System.out.println("Result:");
			insertSort(myArray);
			for (int k = 0; k < myArray.length; k++) {
				System.out.println(myArray[k]);
			}

		} catch (IOException e) {
		}
	}

}
