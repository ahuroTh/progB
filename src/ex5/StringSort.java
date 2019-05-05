package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSort {
	public static int selectMax(int i, String[] a) {
		//最大値をだす
		int max = 0;
		for (int j = 1; j <= i; j++) {
			if (a[j].compareTo(a[max]) > 0) {
				max = j;
			}
		}
		return max;//最大値の引数
					//maxをi-1に格納する必要がある

	}

	public static void swap(String[] a, int pos1, int pos2) {
		//pos1とpos2を交換する
		//maxとi-1を交換
		String tmp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = tmp;
	}

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			//入力
			String line;
			String[] lists = new String[1000];
			int linenum = 0;
			while ((line = reader.readLine()) != null) {
				linenum++;
				lists[linenum - 1] = line;

			}

			//文字列ソート
			for (int i = 0; i < linenum; i++) {
				int minPos = selectMax(i, lists);
				swap(lists, minPos, i);
			}

			//出力
			System.out.println("ソート後");
			for (int k = 0; k < linenum; k++) {
				System.out.println(lists[k]);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
