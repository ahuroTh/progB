package ex9;

class ListIntSort {
	int container;
	ListIntSort next;

	ListIntSort(int element, ListIntSort tail) {
		this.container = element;
		this.next = tail;
	}

	ListIntSort insert(int el) {
		return new ListIntSort(el, this);
	}

	static boolean isEmpty(ListIntSort list) {
		if (list == null)
			return true;
		else
			return false;
	}

	static int head(ListIntSort list) {
		return list.container;
	}

	static ListIntSort tail(ListIntSort list) {
		return list.next;
	}

	static int length(ListIntSort list) {
		int l = 0;
		while (list != null) {
			l++;
			list = list.next;
		}
		return l;
	}

	void Display() {
		ListIntSort u = this;
		while (u != null) {
			System.out.print(u.container + "-->");
			u = u.next;
		}
		System.out.println("null");
	}

	static ListIntSort mergeRec(ListIntSort u, ListIntSort v) {
		if (u == null)
			return v;
		if (v == null)
			return u;
		if (u.container < v.container) {
			u.next = mergeRec(u.next, v);
			return u;
		} else {
			v.next = mergeRec(u, v.next);
			return v;
		}
	}

	static ListIntSort sortRec(ListIntSort u) {
		int l = length(u);
		if (l <= 1)
			return u;
		else {
			int i, lr;
			ListIntSort u1, u2, split, prevSplit;
			u1 = u;
			prevSplit = split = u;
			i = 0;
			lr = l / 2;
			while (i < lr) {
				i++;
				prevSplit = split;
				split = split.next;
			}
			u2 = split;
			prevSplit.next = null;
			return mergeRec(sortRec(u1), sortRec(u2));
		}
	}

	public static void main(String[] args) {
		System.out.println("ListIntSort started.");
		ListIntSort u0 = new ListIntSort(5, null);
		u0 = u0.insert(3);
		u0 = u0.insert(1);
		u0.Display();
		// 1-->3-->5-->null

		ListIntSort v0 = new ListIntSort(6, null);
		v0 = v0.insert(4);
		v0 = v0.insert(2);
		v0.Display();
		// 2-->4-->6-->null

		ListIntSort mergedList0 = ListIntSort.mergeRec(u0, v0);
		mergedList0.Display();
		// 1-->2-->3-->4-->5-->6-->null

		ListIntSort lst = new ListIntSort(2, null);
		lst = lst.insert(3);
		lst = lst.insert(4);
		lst = lst.insert(1);
		lst.Display();
		// 1-->4-->3-->2-->null

		System.out.println("Sorted result:");
		ListIntSort sortedList = sortRec(lst);
		sortedList.Display();
		// 1-->2-->3-->4-->null

		int x[] = { 1, 2, 3, 6, 5, 4 };
		ListIntSort xlist = null;

		// 課題1：下記の欄（...）を埋めて，配列xに格納した値を，
		// (a) リストxlistに格納し（ヒント：insertメソッドを使用），
		// (b) Display()メソッドで表示し，
		// (c) sortRecを用いて整列し，
		// (d) 整列結果をDisplay()メソッドで表示する
		// プログラムを作成せよ。
		// 整列していることを，本プログラム最後のassert文によって確認すること。
		// プログラムの実行は java -ea ファイル名 のように行うこと。

		// ...
		xlist = new ListIntSort(x[x.length - 1], xlist);
		for (int k = x.length - 2; k >= 0; k--) {
			xlist = xlist.insert(x[k]);
		}
		xlist.Display();

		ListIntSort xlist1 = null;
		xlist1 = new ListIntSort(x[x.length - 1], xlist1);
		for (int k = x.length - 2; k >= 0; k--) {
			xlist1 = xlist1.insert(x[k]);
		}

		ListIntSort xlistSorted = sortRec(xlist1);
		xlistSorted.Display();

		assert xlistSorted.container == 1;
		assert xlistSorted.next.container == 2;
		assert xlistSorted.next.next.container == 3;
		assert xlistSorted.next.next.next.container == 4;
		assert xlistSorted.next.next.next.next.container == 5;
		assert xlistSorted.next.next.next.next.next.container == 6;

		// 課題2：クラスメソッドequalRecの空欄（...）を埋めて，二つのリストが等値か（同じ値のリストか）を検査する再帰呼び出しプログラムを作れ。
		// プログラムの実行は java -ea ファイル名 のように行うこと。
		System.out.println("---");
		xlist.Display();
		xlistSorted.Display();
		assert equalRec(null, null);
		assert !equalRec(xlist, null);
		assert !equalRec(null, xlist);
		assert equalRec(xlist, xlist);
		assert equalRec(xlistSorted, xlistSorted);
		assert !equalRec(xlist, xlistSorted);
		assert !equalRec(xlistSorted, xlist);
	}

	static boolean equalRec(ListIntSort u, ListIntSort v) {
		// ...
		if (u != null && v != null&&u.container==v.container) {
			return equalRec(u.next, v.next);
		} else if (u == null && v == null) {
			return true;
		} else {
			return false;
		}
	}
}
