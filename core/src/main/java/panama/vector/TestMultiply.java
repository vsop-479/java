package panama.vector;

import java.util.Random;
import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorOperators;

public class TestMultiply {
	static final int LEN = 10_000;
	static final int MAX = 10_000;
	static int[] a = new int[LEN];
	static int[] b = new int[LEN];
	static int[] c = new int[LEN];

	public static void main(String[] args) {
		init();
		multiply();
		multiplyUnrolled();
		multiplyVector2();
	}

	public static void multiplyVector2() {
		int i = 0;
		for (; i < IntVector.SPECIES_128.loopBound(a.length); i += IntVector.SPECIES_128.length()) {
			IntVector vectorA = IntVector.fromArray(IntVector.SPECIES_128, a, i);
			IntVector vectorB = IntVector.fromArray(IntVector.SPECIES_128, b, i);
			IntVector vectorC = vectorA.mul(vectorB);
			vectorC.intoArray(c, i);
		}
		System.out.println(c[LEN - 1]);
	}


	public static void multiplyVector() {
		int i = 0;
		IntVector vectorA = IntVector.fromArray(IntVector.SPECIES_128, a, 0);
		IntVector vectorB = IntVector.fromArray(IntVector.SPECIES_128, b, 0);
		IntVector vectorC = vectorA.mul(vectorB);
		c = vectorC.toArray();
		// sum.
		int sum = vectorA.reduceLanes(VectorOperators.ADD);
		System.out.println(sum);
	}

	/**
	 * unrolled优化，java JIT会尽量自动转化为向量计算，但有诸多限制。
	 */
	public static void multiplyUnrolled() {
		for (int i = 0; i < LEN; i += 8) {
			c[i] = a[i] * b[i];
			c[i + 1] = a[i + 1] * b[i + 1];
			c[i + 2] = a[i + 2] * b[i + 2];
			c[i + 3] = a[i + 3] * b[i + 3];
			c[i + 4] = a[i + 4] * b[i + 4];
			c[i + 5] = a[i + 5] * b[i + 5];
			c[i + 6] = a[i + 6] * b[i + 6];
			c[i + 7] = a[i + 7] * b[i + 7];
		}
		System.out.println(c[LEN - 1]);
	}

	/**
	 * scalar（标记）实现，java JIT会尽量自动转化为向量计算，但有诸多限制。
	 */
	public static void multiply() {
		for (int i = 0; i < LEN; i++) {
			c[i] = a[i] * b[i];
		}
		System.out.println(c[LEN - 1]);
	}

	public static void init(){
		Random random = new Random();
		for (int i = 0; i < LEN; i++) {
			a[i] = random.nextInt(MAX);
			b[i] = random.nextInt(MAX);
		}
	}

}
