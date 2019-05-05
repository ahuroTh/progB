package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertSort1 {
	public static int findPos(int[] a, int left, int right, int key) {
		//二分探索
		//keyは探したい値＝i番目のあたい
		//left サタン　  right 右端　i-1banme
		while (left <= right) {
			int mid = (left + right) / 2;
			if (a[mid] == key) {
				return mid;

			} else if (a[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;

	}

	public static void shiftPos(int[] a, int p, int j) {
		//右にずらす
		//jは未ソートの右端部分
		//pは
		while (j >= p) {
			a[j + 1] = a[j];
			j--;
		}
	}

	public static void insertSort(int[] a) {
		//d i番目
		//p ibanmeno値が入る位置
		for (int i = 1; i < a.length; i++) {
			int d = a[i];
			int p = findPos(a, 0,i-1, d);
			shiftPos(a, p, i - 1);
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
