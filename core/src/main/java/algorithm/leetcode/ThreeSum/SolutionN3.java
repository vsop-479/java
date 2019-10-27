package algorithm.leetcode.ThreeSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhouhui on 2019/10/26.
 * 三元组中三个数和为0；
 * 三元组不能重复。
 * https://leetcode-cn.com/problems/3sum/
 *直接三重遍历，太慢，时间复杂度O(n^3)
 */
public class SolutionN3 {
    public static void main(String[] args){
        int[] a = new int[]{6};
        long t1 = System.currentTimeMillis();
        List<List<Integer>> lists = threeSum(a);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
        public static List<List<Integer>> threeSum(int[] a) {
            List<List<Integer>> list = new ArrayList();
            HashSet<String> keySet = new HashSet();
            for(int i = 0; i < a.length - 2; i++){
                for(int j = i + 1; j < a.length - 1; j++){
                    int target = 0 - a[i] - a[j];
                    for(int k = j + 1; k < a.length; k++){
                        if(a[k] == target){
                            int[] tmpA = new int[]{a[i], a[j], a[k]};

                            popSort(tmpA);

                            String key = "" + tmpA[0] + tmpA[1] + tmpA[2];
                            if(!keySet.contains(key)){
                                List<Integer> subList = new ArrayList(3);
                                subList.add(a[i]);
                                subList.add(a[j]);
                                subList.add(a[k]);
                                list.add(subList);
                                keySet.add(key);
                            }

                        }
                    }
                }
            }
            return list;
        }

    public static void popSort(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
}
