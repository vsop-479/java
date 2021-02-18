package algorithm.training.loopNumber;

public class Solution {

    public static void main(String[] args){
        float a = 1/7f;
        double b = 0.25;
        System.out.println(1/7f);
        System.out.println(2/7f);
        System.out.println(3/7f);
        System.out.println(4/7f);
        System.out.println(5/7f);
        System.out.println(6/7f);

        isLoop(7);

    }

    public void f(){
        for(int i = 3; i <= 100; i++){

        }
    }

    public static boolean isLoop(int N){
        float base = 1f/N;
        for(int i = 2; i < N; i++){
            float f = i/N;
            System.out.println(f);
        }
        return true;
    }
}
