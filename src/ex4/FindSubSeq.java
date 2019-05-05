package ex4;

import java.util.Scanner;

public class FindSubSeq {
	public static void main(String[] args) {

		//１０つ数字を受け取る
		Scanner scan = new Scanner(System.in);

		System.out.print("Input 10 data: ");
		int[] sequence = new int[10];

		for (int i = 0; i < sequence.length; i++) {

			int num = scan.nextInt();
			sequence[i] = (num);
		}

		//引数（[k]番目　string→int　新しい配列？リスト？）と配列([i]番目)を比べる　二重ループ
		int[] subSeq = new int[args.length];
		for (int in = 0; in < args.length; in++) {

			int komando = Integer.parseInt(args[in]);
			subSeq[in] = (komando);
		}

		//一つ目が一致したら二つ目、subSeq(args).lengthまで続ける

		int perfect = -1;

		for (int l = 0; l < sequence.length - subSeq.length + 1; l++) {

			if (subSeq[0] == sequence[l]) {

				for (int a = 1; a < subSeq.length; a++) {

					if (subSeq[a] == sequence[l + a]) {

						if (a == subSeq.length - 1) {
							perfect = 1;
							System.out.print("Found at " + l + " Sequence: ");

							for (int w = 0; w < args.length; w++) {
								System.out.print(args[w] + " ");

							}
							System.out.println("");

						}
					}

				}

			}
		}
		

		
		if (perfect == -1)

		{
			System.out.println("Not Found");

		}
	}
}