package panama.vector;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

import java.util.Random;

public class TestMax {
  static final int LEN = 256;
  static final int MAX = Integer.MAX_VALUE;
  static int[] a = new int[LEN];
  static int[] b = new int[LEN];
  static int[] c = new int[LEN];

  private static final VectorSpecies<Integer> SPECIES_128 = IntVector.SPECIES_128;
  private static final VectorSpecies<Integer> SPECIES_256 = IntVector.SPECIES_256;
  private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_128;

  public static void main(String[] args){
    // scalar will be auto unrolled, auto vectorized by jit.
  }

  public static void init(){
    Random random = new Random();
    for (int i = 0; i < LEN; i++) {
      a[i] = random.nextInt(MAX);
      b[i] = random.nextInt(MAX);
    }
  }

  // Auto-Vectorization
  public static int[] iterator(){
    for(int i = 0; i < a.length; ++i){
      a[i] = Math.max(a[i], b[i]);
    }
    return a;
  }

  public static int[] unrolled() {
    for (int i = 0; i < LEN; i += 8) {
      a[i] = Math.max(a[i], b[i]);
      a[i + 1] = Math.max(a[i + 1], b[i + 1]);
      a[i + 2] = Math.max(a[i + 2], b[i + 2]);
      a[i + 3] = Math.max(a[i + 3], b[i + 3]);
      a[i + 4] = Math.max(a[i + 4], b[i + 4]);
      a[i + 5] = Math.max(a[i + 5], b[i + 5]);
      a[i + 6] = Math.max(a[i + 6], b[i + 6]);
      a[i + 7] = Math.max(a[i + 7], b[i + 7]);
    }
    return a;
  }


  public static int[] vector(){
    int i = 0;
    int count = 0;
    for (; i < SPECIES.loopBound(a.length); i += SPECIES.length()) {
      IntVector vectorA = IntVector.fromArray(SPECIES, a, i);
      IntVector vectorB = IntVector.fromArray(SPECIES, b, i);
      IntVector vectorC = vectorA.max(vectorB);
      vectorC.intoArray(a, i);
    }
    return a;
  }

  public static int[] vectorUnrolled(){
    int i = 0;
    IntVector vectorC1 = IntVector.zero(SPECIES);
    IntVector vectorC2 = IntVector.zero(SPECIES);
    IntVector vectorC3 = IntVector.zero(SPECIES);
    IntVector vectorC4 = IntVector.zero(SPECIES);
    for (; i < SPECIES.loopBound(a.length); i += SPECIES.length() * 4) {
      IntVector vectorA1 = IntVector.fromArray(SPECIES, a, i);
      IntVector vectorB1 = IntVector.fromArray(SPECIES, b, i);
      vectorC1 = vectorA1.max(vectorB1);

      IntVector vectorA2 = IntVector.fromArray(SPECIES, a, i + SPECIES.length());
      IntVector vectorB2 = IntVector.fromArray(SPECIES, b, i + SPECIES.length());
      vectorC2 = vectorA2.max(vectorB2);

      IntVector vectorA3 = IntVector.fromArray(SPECIES, a, i + 2 * SPECIES.length());
      IntVector vectorB3 = IntVector.fromArray(SPECIES, b, i + 2 * SPECIES.length());
      vectorC3 = vectorA3.max(vectorB3);

      IntVector vectorA4 = IntVector.fromArray(SPECIES, a, i + 3 * SPECIES.length());
      IntVector vectorB4 = IntVector.fromArray(SPECIES, b, i + 3 * SPECIES.length());
      vectorC4 = vectorA4.max(vectorB4);

      vectorC1.intoArray(a, i);
      vectorC2.intoArray(a, i + SPECIES.length());
      vectorC3.intoArray(a, i + 2 * SPECIES.length());
      vectorC4.intoArray(a, i + 3 * SPECIES.length());
    }
    return a;
  }

  public static boolean equals(int[] a, int[] b){
    for(int i = 0; i < a.length; ++i){
      if(a[i] != b[i]){
        return false;
      }
    }
    return true;
  }

}
