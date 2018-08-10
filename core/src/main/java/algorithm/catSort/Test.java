package algorithm.catSort;

import algorithm.catSort.model.Cat;
import algorithm.catSort.model.Color;

import java.util.Random;

public class Test {
    static Random random = new Random(77);
    public static Cat[] cats = new Cat[10];

    public static void generateCats(){
        for(int i = 0; i < cats.length; i++){
            if(random.nextInt() / 2 == 0){
                cats[i] = new Cat(Color.BLACK);
            }else{
                cats[i] = new Cat(Color.WHITE);
            }
        }
    }

    public static void main(String[] args){

    }

    public static void sort(Cat[] cats){
        if(cats == null || cats.length == 0)return;
        int head = 0, tail = cats.length - 1;
        while(head < tail){
            if(cats[tail].getColor().equals(Color.WHITE)){
                if(cats[head].getColor().equals(Color.BLACK)){
                        Cat temp = cats[head];
                        cats[head] = cats[tail];
                        cats[tail] = temp;
                        head++;
                        tail--;
                }else{

                }
            }
        }
    }

}
