package panama.vector;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

import java.util.Random;

import static jdk.incubator.vector.VectorOperators.ADD;

public class TestDotProduct {
  static final int LEN = 256;
  static final int MAX = Integer.MAX_VALUE;
  static int[] a = new int[LEN];
  static int[] b = new int[LEN];
  static int[] c = new int[LEN];

  private static final VectorSpecies<Integer> SPECIES_128 = IntVector.SPECIES_128;
  private static final VectorSpecies<Integer> SPECIES_256 = IntVector.SPECIES_256;
  private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_128;


  public static void init(){
    Random random = new Random();
    for (int i = 0; i < LEN; i++) {
      a[i] = random.nextInt(MAX);
      b[i] = random.nextInt(MAX);
    }
  }

  public static void main(String[] args){
    init();
    iterator();
    vector();
    long t0 = System.nanoTime();
    iterator();
    iterator();
    iterator();
    long t1 = System.nanoTime();
    vector();
    vector();
    vector();
    long t2 = System.nanoTime();
    vectorUnrolled();
    vectorUnrolled();
    vectorUnrolled();
    long t3 = System.nanoTime();
    System.out.println("iterator: " + (t1 - t0));
    System.out.println("vector: " + (t2 - t1));
    System.out.println("vectorUnrolled: " + (t3 - t2));
    System.out.println(iterator() == vector());
    System.out.println(iterator() == vectorUnrolled());
  }

  public static int iterator(){
    int total = 0;
    for (int i = 0; i < a.length; i++) {
      total += a[i] * b[i];
    }
    return total;
  }

  public static int vector(){
    int i = 0;
    IntVector vectorC = IntVector.zero(SPECIES);
    for (; i < SPECIES.loopBound(a.length); i += SPECIES.length()) {
      IntVector vectorA = IntVector.fromArray(SPECIES, a, i);
      IntVector vectorB = IntVector.fromArray(SPECIES, b, i);
      vectorC = vectorC.add(vectorA.mul(vectorB));
    }
    return vectorC.reduceLanes(ADD);
  }

  public static int vectorUnrolled(){
    int i = 0;
    IntVector vectorC1 = IntVector.zero(SPECIES);
    IntVector vectorC2 = IntVector.zero(SPECIES);
    IntVector vectorC3 = IntVector.zero(SPECIES);
    IntVector vectorC4 = IntVector.zero(SPECIES);
    for (; i < SPECIES.loopBound(a.length); i += SPECIES.length() * 4) {
      IntVector vectorA1 = IntVector.fromArray(SPECIES, a, i);
      IntVector vectorB1 = IntVector.fromArray(SPECIES, b, i);
      vectorC1 = vectorC1.add(vectorA1.mul(vectorB1));

      IntVector vectorA2 = IntVector.fromArray(SPECIES, a, i + SPECIES.length());
      IntVector vectorB2 = IntVector.fromArray(SPECIES, b, i + SPECIES.length());
      vectorC2 = vectorC2.add(vectorA2.mul(vectorB2));

      IntVector vectorA3 = IntVector.fromArray(SPECIES, a, i + 2 * SPECIES.length());
      IntVector vectorB3 = IntVector.fromArray(SPECIES, b, i + 2 * SPECIES.length());
      vectorC3 = vectorC3.add(vectorA3.mul(vectorB3));

      IntVector vectorA4 = IntVector.fromArray(SPECIES, a, i + 3 * SPECIES.length());
      IntVector vectorB4 = IntVector.fromArray(SPECIES, b, i + 3 * SPECIES.length());
      vectorC4 = vectorC4.add(vectorA4.mul(vectorB4));
    }
    IntVector res1 = vectorC1.add(vectorC2);
    IntVector res2 = vectorC3.add(vectorC4);

    return res1.add(res2).reduceLanes(ADD);
  }

}
