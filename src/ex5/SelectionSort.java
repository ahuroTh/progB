package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {

	public static int selectMax(int i, int[] a) {
		//最大値をだす
		int max = 0;
		for (int j = 1; j <= i; j++) {
			if (a[j] > a[max]) {
				max = j;
			}
		}
		return max;//最大値の引数
					//maxをi-1に格納する必要がある
	}

	public static void swap(int[] a, int pos1, int pos2) {
		//pos1とpos2を交換する
		//maxとi-1を交換
		int tmp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = tmp;
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

			for (int i = myArray.length - 1; i >= 0; i--) {
				int maxPos = selectMax(i, myArray);//最大値
				swap(myArray, maxPos, i);
			}
			for (int k = 0; k < myArray.length; k++) {
				System.out.println(myArray[k]);
			}

		} catch (IOException e) {
		}
	}

}