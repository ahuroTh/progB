package ex3;

public class InnerProduct {
	public static void main(String[] args) {
		double[] nums1 = { 1.0, 1.5, 2.0, 2.5 };
		double[] nums2 = { 3.1, 2.1, 1.1, 0.1 };

		double naiseki = 0;

		for (int i = 0; i < nums1.length; i++) {
			double na = nums1[i] * nums2[i];
			naiseki += na;
		}

		System.out.println("内積は" + naiseki + "です。");

	}
}
