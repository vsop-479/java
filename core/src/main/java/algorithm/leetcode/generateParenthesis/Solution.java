package algorithm.leetcode.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouhui on 2019/11/3.
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        String result = "";
        generate(n, n, resultList, result);
        return resultList;
    }

    /**
     *
     * @param left：剩余左括号数量
     * @param right：剩余右括号数量
     * @param resultList
     * @param result
     */
    public static void generate(int left, int right, List<String> resultList, String result){
        if(left == 0 && right == 0){
            resultList.add(result);
            return;
        }

//        剩余的左括号数量大于右括号数量，则表示result中使用的右括号多余左括号，无效括号。
//        注意递归3，2，1都会调入left，right，再此过滤无效括号。
        if(left > right){
            return;
        }

        if(left > 0){
            generate(left - 1, right, resultList, result + "(");
        }

        if(right > 0){
            generate(left, right - 1, resultList, result + ")");
        }
    }

    public static void main(String[] args){
        List<String> list = generateParenthesis(3);
        System.out.print(list);
    }
}
