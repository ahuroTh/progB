package ex2;

public class Square {
	public static void main(String[] args) {
		int i=1;
while(i<=11) {
	System.out.println(i+"の2乗は"+sq(i)+"です.");
	i=i+2;

}
	}

	public static int sq(int n) {
		return n * n;
	}
}