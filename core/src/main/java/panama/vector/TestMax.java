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
    init();
    iterator();
    vector();
    long t0 = System.nanoTime();
    iterator();
    iterator();
    iterator();
    long t1 = System.nanoTime();
    unrolled();
    unrolled();
    unrolled();
    long t2 = System.nanoTime();
    vector();
    vector();
    vector();
    long t3 = System.nanoTime();
    System.out.println("iterator: " + (t1 - t0));
    System.out.println("unrolled: " + (t2 - t1));
    System.out.println("vector: " + (t3 - t2));
    System.out.println(equals(iterator(), vector()));
    System.out.println(equals(iterator(), unrolled()));
  }

  public static void init(){
    Random random = new Random();
    for (int i = 0; i < LEN; i++) {
      a[i] = random.nextInt(MAX);
      b[i] = random.nextInt(MAX);
    }
  }

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
    for (; i < SPECIES_128.loopBound(a.length); i += SPECIES_128.length()) {
      IntVector vectorA = IntVector.fromArray(SPECIES_128, a, i);
      IntVector vectorB = IntVector.fromArray(SPECIES_128, b, i);
      IntVector vectorC = vectorA.max(vectorB);
      vectorC.intoArray(a, i);
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
