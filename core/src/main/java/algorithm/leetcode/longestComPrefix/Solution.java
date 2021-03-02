package algorithm.leetcode.longestComPrefix;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        for(int i = 0; i < strs[0].length(); i++){
            char base = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
//                sort can return early.
                if(strs[j].length() - 1 < i || strs[j].charAt(i) != base){
                    if(i == 0){
                        return "";
                    }
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args){
        String[] strs = new String[]{"apple", "apbanana", "appearl"};
        System.out.println(longestCommonPrefix(strs));
    }
}
