package ex10;

public class HashTest {
	public static void main(String[] args) {
		System.out.println("*** HashTest.main()");

		HashOpenAddressing.main(null);
		System.out.println("");

		HashList.main(null);
		System.out.println("");

		// ShowFile.main(null);
	}
}

class HashOpenAddressing {
	static int m = 23; // TRANSCODE strings into integers

	static long String2Integer(String s) {
		long result = 0;

		for (int j = 0; j < s.length(); j++)
			result = result * 31 + s.charAt(j);
		// this is the method s.hashCode()
		return result;
	}

	// Note that m is a static variable
	static int HashFunction(long l) {
		long x = l % (long) m;
		return (int) x;
	}

	// 課題5-1：下記の欄（...）を埋めてメソッドcountElementsを完成させよ。
	// このメソッドは文字列配列hashTable中に格納されたハッシュ表の要素数を返す。
	// プログラムの実行は java -ea ファイル名 のように行うこと。
	// ヒント：','の数をカウントするとよい。
	// StringクラスのcharAtメソッドにより，文字列中の文字を参照できる。
	static int countElements(String[] hashTable) {
		// ...
		int count = 0;
		for (int k = 0; k < hashTable.length; k++) {
			for (int i = 0; i < hashTable[k].length(); i++) {
				if (hashTable[k].charAt(i) == ',') {
					count += 1;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("*** HashOpenAddressing.main()");

		String[] animals = { "cat", "dog", "parrot", "horse", "fish",
				"shark", "pelican", "tortoise", "whale", "lion",
				"flamingo", "cow", "snake", "spider", "bee", "peacock",
				"elephant", "butterfly" };
		String[] hashTable = new String[m];

		for (int i = 0; i < m; i++)
			hashTable[i] = new String("--> ");

		for (int i = 0; i < animals.length; i++) {
			int pos = HashFunction(String2Integer(animals[i]));
			hashTable[pos] += (animals[i] + ", ");
		}

		for (int i = 0; i < m; i++)
			System.out.println("Position " + i + "\t" + hashTable[i]);

		// System.out.println("# of elements: " + countElements(hashTable));

		assert animals.length == countElements(hashTable);
	}
}

class HashList {
	static int m = 23; // TRANSCODE strings into integers

	static long String2Integer(String s) {
		long result = 0;

		for (int j = 0; j < s.length(); j++)
			result = result * 31 + s.charAt(j);
		// this is the method s.hashCode()
		return result;
	}

	// Note that m is a static variable
	static int HashFunction(long l) {
		long x = l % (long) m;
		return (int) x;
	}

	public static void main(String[] args) {
		System.out.println("*** HashList.main()");

		String[] animals = { "cat", "dog", "parrot", "horse", "fish",
				"shark", "pelican", "tortoise", "whale", "lion",
				"flamingo", "cow", "snake", "spider", "bee", "peacock",
				"elephant", "butterfly" };
		int i;

		ListString[] HashTable = new ListString[m];

		for (i = 0; i < m; i++)
			HashTable[i] = null;

		for (i = 0; i < animals.length; i++) {
			long s2int = String2Integer(animals[i]);
			int pos = HashFunction(s2int);
			HashTable[pos] = ListString.Insert(animals[i], HashTable[pos]);
		}

		for (i = 0; i < m; i++)
			ListString.Display(HashTable[i]);
		//HashTableを出力

		// 課題5-2：下記の欄（...）を埋めてプログラムを完成させよ。下記の欄によって，
		// 配列animalsの各要素が格納されているハッシュ配列の添字，リスト中の位置が表示される。
		// 本プログラムの出力を，本プログラムの最後にコメントして付けてあるので，
		// 参考にすること。
		// プログラムの実行は java -ea ファイル名 のように行うこと。
		for (i = 0; i < animals.length; i++) {
			// ...
			String animal = animals[i];

			int pos = HashFunction(String2Integer(animals[i]));
			int loc = 0;
			
			boolean a = true;
			while (a) {
				if (HashTable[pos].name == animal || HashTable[pos].next == null) {
					loc = 0;
					System.out.println(HashTable[pos].name);
					a = false;
					break;
				}
				if (HashTable[pos].next.name == animal || HashTable[pos].next.next == null) {
					loc = 1;
					System.out.println(HashTable[pos].next.name);
					a = false;
					break;
				}
				if (HashTable[pos].next.next.name == animal || HashTable[pos].next.next.next == null) {
					loc = 2;
					System.out.println(HashTable[pos].next.next.name);
					a = false;
					break;
				}
				if (HashTable[pos].next.next.next.name == animal || HashTable[pos].next.next.next.next == null) {
					loc = 3;
					System.out.println(HashTable[pos].next.next.next.name);
					a = false;
					break;
				}
				if (HashTable[pos].next.next.next.next.name == animal
						|| HashTable[pos].next.next.next.next.next == null) {
					loc = 4;
					System.out.println(HashTable[pos].next.next.next.next.name);
					a = false;
					break;
				}
			}

			System.out.println(animals[i] + ": pos=" + pos + ", loc=" + loc);
			if (animal.equals("dog")) {
				assert loc == 4;
			}
		}

		assert HashTable[8].next.next.next.next.name.equals("dog");

	}
}

//liststring
class ListString {
	String name;
	ListString next;

	ListString(String name, ListString tail) {
		this.name = new String(name);
		this.next = tail;
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
}
/*
        *** HashOpenAddressing.main()
        Position 0  -->
        Position 1  -->
        Position 2  --> elephant
        Position 3  -->
        Position 4  --> tortoise
        Position 5  --> snake bee
        Position 6  --> cat cow
        Position 7  --> fish
        Position 8  --> dog shark pelican whale flamingo
        Position 9  -->
        Position 10 -->
        Position 11 --> spider
        Position 12 --> butterfly
        Position 13 -->
        Position 14 --> horse
        Position 15 -->
        Position 16 -->
        Position 17 --> lion
        Position 18 --> peacock
        Position 19 -->
        Position 20 -->
        Position 21 -->
        Position 22 --> parrot

        *** HashList.main()
        null
        null
        elephant-->null
        null
        tortoise-->null
        bee-->snake-->null
        cow-->cat-->null
        fish-->null
        flamingo-->whale-->pelican-->shark-->dog-->null
        null
        null
        spider-->null
        butterfly-->null
        null
        horse-->null
        null
        null
        lion-->null
        peacock-->null
        null
        null
        null
        parrot-->null

        cat: pos=6, loc=1
        dog: pos=8, loc=4
        parrot: pos=22, loc=0
        horse: pos=14, loc=0
        fish: pos=7, loc=0
        shark: pos=8, loc=3
        pelican: pos=8, loc=2
        tortoise: pos=4, loc=0
        whale: pos=8, loc=1
        lion: pos=17, loc=0
        flamingo: pos=8, loc=0
        cow: pos=6, loc=0
        snake: pos=5, loc=1
        spider: pos=11, loc=0
        bee: pos=5, loc=0
        peacock: pos=18, loc=0
        elephant: pos=2, loc=0
        butterfly: pos=12, loc=0
*/