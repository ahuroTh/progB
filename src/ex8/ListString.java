package ex8;

class ListString {
	String name;
	ListString next;

	ListString(String name, ListString tail) {
		this.name = new String(name);
		this.next = tail;
	}

	static boolean isEmpty(ListString list) {
		return (list == null);
	}

	static String head(ListString list) {
		return list.name;
	}

	static ListString tail(ListString list) {
		return list.next;
	}

	static boolean belongTo(String s, ListString list) {
		while (list != null) {
			if (s.equals(list.name))
				return true;
			list = list.next;
		}
		return false;
	}

	static int length(ListString list) {
		int l = 0;
		while (list != null) {
			l++;
			list = list.next;
		}
		return l;
	}

	static ListString Insert(String s, ListString list) {
		return new ListString(s, list);
	}

	static void Display(ListString list) {
		while (list != null) {
			System.out.print(list.name + "-->");
			list = list.next;
		}
		System.out.println("null");
	}

	static ListString Delete(String s, ListString list) {
		if (list == null) // if list is empty
			return null;

		if (list.name.equals(s)) // If element is at the head
			return list.next;

		ListString v = list;
		ListString w = list.next; //tail

		while (w != null && !((w.name).equals(s))) {
			v = w;
			w = v.next;
		}
		if (w != null)
			v.next = w.next;

		return list;
	}

	static int lengthRec(ListString list) {
		if (list == null)
			return 0;
		else
			return 1 + lengthRec(list.next);
	}

	// 課題：下記の欄を埋めてプログラムを完成させよ。

	// 課題3-1：リストの最後の要素を求める反復的（再帰を使わない）クラスメソッド
	// static String last(ListString list) を定義せよ。

	// 課題3-2：リストの最後の要素を求める再帰的クラスメソッド
	// static String lastRec(ListString list) を定義せよ。

	// ...
	static String last(ListString list) {
		boolean check = true;
		while (check) {
			list = list.next;
			if (list.next == null) {
				check = false;
			}
		}
		return list.name;

	}

	static String lastRec(ListString list) {
		if (list.next == null) {
			return list.name;
		} else {
			return lastRec(list.next);
		}
	}

	static boolean belongToRec(String s, ListString list) {
		if (list == null)
			return false;
		else {
			if (s.equals(list.name))
				return true;
			else
				return belongToRec(s, list.next);
		}
	}

	static void DisplayRec(ListString list) {
		if (list == null)
			System.out.println("null");
		else {
			System.out.print(list.name + "==>");
			DisplayRec(list.next);
		}
	}

	static ListString copy(ListString l) {
		ListString result = null;

		while (l != null) {
			result = new ListString(l.name, result);
			l = l.next;
		}
		return result;
	}

	static ListString copyRec(ListString l) {
		if (l == null)
			return null;
		else
			return new ListString(l.name, copyRec(l.next));
	}

	static ListString Build(String[] array) {
		ListString result = null;

		// To ensure that head is the first array element
		// decrement: from largest to smallest index
		for (int i = array.length - 1; i >= 0; i--)
			result = new ListString(array[i], result);
		// 配列の最後からリストを作成

		return result;
	}
}

class ListStringTest {
	public static void main(String[] args) {
		ListString l = new ListString("Frank", null);
		l = new ListString("Marc", l);
		l = new ListString("Frederic", l); //lにfredericを追加 先頭が最後に追加されたもの 連結??
		l = new ListString("Audrey", l);
		l = new ListString("Steve", l);
		l = new ListString("Sophie", l);

		// System.out.println(ListString.belongTo("Marc", l));
		// System.out.println(ListString.belongTo("Sarah", l));
		assert ListString.belongTo("Marc", l);
		assert !ListString.belongTo("Sarah", l);
		assert ListString.belongTo("Sophie", l);

		System.out.println("ListString.length():"); //print1
		assert ListString.length(l) == 6;

		l = ListString.Insert("Philippe", l);
		l = new ListString("Sylvie", l);
		assert ListString.length(l) == 8;
		System.out.println("ListString.length(l) = " + ListString.length(l)); //print2 出力8
		ListString.Display(l);

		ListString.Delete("Steve", l);
		ListString.Display(l);

		assert ListString.length(l) == ListString.length(l);
		assert ListString.belongToRec("Audrey", l);
		ListString.DisplayRec(l);

		System.out.println("ListString.copy() and Display():"); ///////print3
		ListString lcopy = ListString.copy(l);
		ListString.Display(lcopy);

		System.out.println("ListString.copyRec() and DisplayRec():");//////print4
		ListString lcopy2 = ListString.copyRec(l);
		ListString.DisplayRec(l);

		String[] colors = { "green", "red", "blue", "purple", "orange", "yellow" };
		ListString lColors = ListString.Build(colors);
		ListString.Display(lColors);

		System.out.println("* ListString.last(lColors) = " + ListString.last(lColors));///////print5 yellow出力するはず
		System.out.println("* ListString.lastRec(lColors) = " + ListString.lastRec(lColors));//////////print6 yellow出力するはず
		assert ListString.length(lColors) == 6;
		assert ListString.last(lColors).equals("yellow");
		assert ListString.lastRec(lColors).equals("yellow");
	}
}
