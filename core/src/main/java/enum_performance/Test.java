package enum_performance;

public class Test {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      enumSymbol();
      enumEquals();
      rawValue();
    }

  }

  public static void enumSymbol(){
    long t0 = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
    if (MatchState.HIGH == MatchState.LOW) {

    }
    if (MatchState.MATCH == MatchState.LOW) {

    }
    if (MatchState.LOW == MatchState.LOW) {

    }}
    long t1 = System.nanoTime();
    System.out.println("enum ==: " + (t1 - t0));
  }

  public static void enumEquals(){
    long t0 = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
      if (MatchState.HIGH.equals(MatchState.LOW)) {

      }
      if (MatchState.MATCH.equals(MatchState.LOW)) {

      }
      if (MatchState.LOW.equals(MatchState.LOW)) {

      }
    }
    long t1 = System.nanoTime();
    System.out.println("enum equals: " + (t1 - t0));
  }

  public static void rawValue(){
    long t0 = System.nanoTime();
    for (int i = 0; i < 10000; i++) {
      if (0 == 1) {

      }
      if (2 == 1) {

      }
      if (2 == 2) {

      }
    }
    long t1 = System.nanoTime();
    System.out.println("raw ==: " + (t1 - t0));
  }
}


enum MatchState{
    MATCH,
  LOW,
HIGH
}