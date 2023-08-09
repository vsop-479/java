package panama.vector;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorOperators;
import jdk.incubator.vector.VectorSpecies;

import java.util.Random;

public class TestPack {
	private static final VectorSpecies<Integer> SPECIES_128 = IntVector.SPECIES_128;

	public static void main(String[] args) {
		int bitPerValue = 64 - Long.numberOfLeadingZeros(2 << (23 - 2));
		int[] a = new int[8];
		int[] b = new int[8];
		int[] c = new int[8];
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(2 << (23 - 2));
		}
		pack23(a, b);

		unPack23(b, c);
		System.out.println(bitPerValue);
	}

	public static void pack23(int[] input, int[] output) {
		int inOffset = 0;
		int outOffset = 0;
		IntVector outVec;
		IntVector inVec = IntVector.fromArray(SPECIES_128, input, inOffset);
		outVec = inVec;
		inVec = IntVector.fromArray(SPECIES_128, input, inOffset += 4);

		// inVector左移，空出23位，存放outVec
		outVec = inVec.lanewise(VectorOperators.LSHL, 23).or(outVec);
		// 此时outVector的32bit中，高9bit存放了inVector的低9bit，低23bit存放了原来的outVec。
		outVec.intoArray(output, outOffset);

		outOffset += 4;
		// 将inVec的剩余高14bit(移除已经存放的低9bit)，存放到outVec。
		outVec = inVec.lanewise(VectorOperators.LSHR, 9);

		outVec.intoArray(output, outOffset);
	}
	public static void unPack23(int[] input, int[] output) {
		IntVector inVec = IntVector.fromArray(SPECIES_128, input, 0);
		IntVector outVec;
		int inOffset = 0;
		int outOffset = 0;
		final int mask = (1 << 23) - 1;

		outVec = inVec.and(mask);
		outVec.intoArray(output, outOffset);

		outVec = inVec.lanewise(VectorOperators.LSHR, 23);
		inVec = IntVector.fromArray(SPECIES_128, input, inOffset += 4);
		outVec = outVec.or(inVec.lanewise(VectorOperators.LSHL, 9).and(mask));
		outVec.intoArray(output, outOffset += 4);
	}

}
