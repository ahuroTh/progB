package ex3;

public class AddArgs {
	public static void main(String[] args) {

		int listSum = 0;
		for (int i = 0; i < args.length; i++) {

			Integer inte1 = Integer.valueOf(args[i]);
			listSum += inte1;

		}
		System.out.println(listSum);
	}

}
