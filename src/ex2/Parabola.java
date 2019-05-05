package ex2;

public class Parabola {
	public static void main(String[] args) {
		int i = 0;
		while (i < 17) {
			printGraph(sq(i - 8));
			i=i+1;
		}

	}

	public static void printGraph(int x) {
		for (int i = 0; i < x; i++) {
			System.out.print("*");
		}
		System.out.println("");
	}

	public static int sq(int x) {
		return x * x;
	}
}
