package algorithm.leetcode.letterCombination;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 1:取第一个数字，将结果放入current.
 * 2:递归求当digits[1,end)的结果subResult，当digits length为1时结束递归。
 * 3：将current添加到subResult的头部。
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return result;
        }
        char[][] db = new char[][]{new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'},
                new char[]{'g', 'h', 'i'},
                new char[]{'j', 'k', 'l'},
                new char[]{'m', 'n', 'o'},
                new char[]{'p', 'q', 'r', 's'},
                new char[]{'t', 'u', 'v'},
                new char[]{'w', 'x', 'y', 'z'}};
        List<String> current = new ArrayList<>();
//        取第一个数字，将结果放入current。
        char[] single = db[digits.charAt(0) - 48 - 2];
        for(char c : single){
            current.add(c + "");
        }
//        只有一个数字时，结束递归。
        if(digits.length() == 1){
            result.addAll(current);
            return result;
        }
//        获取后面数字的结果。
        List<String> subResult = letterCombinations(digits.substring(1,  digits.length()));
//        将第一个数字的结果，添加到子结果头部。
        for(String s : subResult){
            for(int i = 0; i < single.length; i++){
                result.add(single[i] + s);
            }
        }
        return result;
    }

    public static void main(String[] args){

    }
}
