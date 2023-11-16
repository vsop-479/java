package panama.vector;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorMask;
import jdk.incubator.vector.VectorSpecies;

import java.util.Random;

public class TestAdd {
  static final int LEN = 256;
  static final int MAX = Integer.MAX_VALUE;
  static int[] a = new int[LEN];
  static int[] b = new int[LEN];
  static int[] c = new int[LEN];

  private static final VectorSpecies<Integer> SPECIES_128 = IntVector.SPECIES_128;
  private static final VectorSpecies<Integer> SPECIES_256 = IntVector.SPECIES_256;
  private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_128;

  public static void main(String[] args) {
// scalar will be auto unrolled, auto vectorized by JIT.
    // unroll will not be auto vectorized by JIT.
    // vector will be auto unrolled by JIT.
  }

  // Auto-Vectorization works
  public static int[] scalarDefault(){
    for(int i = 0; i < a.length; ++i){
      a[i] = a[i] + b[i];
    }
    return a;
  }

  public static int[] unroll(){
    for(int i = 0; i < a.length; i += 8){
      a[i] = a[i] + b[i];
      a[i + 1] = a[i + 1] + b[i + 1];
      a[i + 2] = a[i + 2] + b[i + 2];
      a[i + 3] = a[i + 3] + b[i + 3];
      a[i + 4] = a[i + 4] + b[i + 4];
      a[i + 5] = a[i + 5] + b[i + 5];
      a[i + 6] = a[i + 6] + b[i + 6];
      a[i + 7] = a[i + 7] + b[i + 7];
    }
    return a;
  }

  public static int[] vectorLoopBound(){
    int i = 0;
    for (; i < SPECIES_128.loopBound(a.length); i += SPECIES_128.length()) {
      IntVector vectorA = IntVector.fromArray(SPECIES_128, a, i);
      IntVector vectorB = IntVector.fromArray(SPECIES_128, b, i);
      // C[0] = A[0] * B[0], ..., C[3] = A[3] * B[3]并行计算。
      IntVector vectorC = vectorA.add(vectorB);
      vectorC.intoArray(a, i);
    }
    return a;
  }

  public static int[] vectorIndexRange(){
    for (int i = 0; i < a.length; i += SPECIES.length()) {
      VectorMask<Integer> mask = SPECIES.indexInRange(i, a.length);
      IntVector vectorA = IntVector.fromArray(SPECIES, a, i, mask);
      IntVector vectorB = IntVector.fromArray(SPECIES, b, i, mask);
      // C[0] = A[0] * B[0], ..., C[3] = A[3] * B[3]并行计算。
      IntVector vectorC = vectorA.add(vectorB);
      vectorC.intoArray(a, i);
    }
    return a;
  }



  public static void init(){
    Random random = new Random();
    for (int i = 0; i < LEN; i++) {
      a[i] = random.nextInt(MAX);
      b[i] = random.nextInt(MAX);
    }
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
