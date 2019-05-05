package ex3;

public class Matrix {
	public static void main(String[] args) {
		double[][] retu1 = { { 1.0, 2.0 }, { 3.0, 4.0 } };
		double[][] retu2 = { { 1.5, 0.0 }, { 0.0, 1.5 } };

		double[][] kekka = { { 0.0, 0.0 }, { 0.0, 0.0 } };

		kekka[0][0] = retu1[0][0] * retu2[0][0] + retu1[0][1] * retu2[1][0];
		kekka[0][1] = retu1[0][0] * retu2[0][1] + retu1[0][1] * retu2[1][1];
		kekka[1][0] = retu1[1][0] * retu2[0][0] + retu1[1][1] * retu2[1][0];
		kekka[1][1] = retu1[1][0] * retu2[0][1] + retu1[1][1] * retu2[1][1];

		for (int i = 0; i < 2; i++) {
			for (int k = 0; k < 2; k++)

				System.out.print(kekka[i][k] + " ");
			System.out.println("");
		}
	}
}
