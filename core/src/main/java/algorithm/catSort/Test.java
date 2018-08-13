package algorithm.catSort;

import algorithm.catSort.model.Cat;
import algorithm.catSort.model.Color;
import java.util.Random;

/**
 * 将数组中的白猫排在黑猫前面。
 */
public class Test {
    static Random random = new Random(77);

    public static Cat[] generateCats(int length){
        Cat[] cats = new Cat[length];
        for(int i = 0; i < cats.length; i++){
            if(random.nextInt() % 2 == 0){
                cats[i] = new Cat(Color.BLACK, i + "");
            }else{
                cats[i] = new Cat(Color.WHITE, i + "");
            }
        }
        return cats;
    }

    public static void main(String[] args){
        Cat[] cats = generateCats(10);
        printCats(cats);
        sort(cats);
        printCats(cats);
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
                        head++;
                }
            }else{
                tail--;
            }
        }
    }

    public static void printCats(Cat[] cats){
        for(Cat cat : cats){
            System.out.print(cat);
            System.out.print(",");
        }
        System.out.println();
    }

}
