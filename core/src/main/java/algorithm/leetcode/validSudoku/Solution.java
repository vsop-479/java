package algorithm.leetcode.validSudoku;

import java.util.BitSet;

/**
 * Created by zhouhui on 2019/11/3.
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
//            i行
            if(!isValidSudoku(board[i])){
                return false;
            }
//            i列
            char[] chars = new char[]{board[0][i], board[1][i], board[2][i],
                    board[3][i], board[4][i], board[5][i], board[6][i], board[7][i], board[8][i]};
            if(!isValidSudoku(chars)){
                return false;
            }
        }

//        9个3*3的宫。
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                char[] chars = new char[]{board[j * 3][i * 3], board[j * 3][i * 3 + 1], board[j * 3][i * 3 + 2],
                        board[j * 3 + 1][i * 3], board[j * 3 + 1][i * 3 + 1], board[j * 3 + 1][i * 3 + 2],
                        board[j * 3 + 2][i * 3], board[j * 3 + 2][i * 3 + 1], board[j * 3 + 2][i * 3 + 2]};
                if(!isValidSudoku(chars)){
                    return false;
                }
            }
        }
        return true;
    }

//    判断9个char是否无重复。
//    1-9分别对应bitSet 0-8，当位置无值时，设置bit为1，当有值，说明会重复。
    public static boolean isValidSudoku(char[] chars){
        BitSet bitSet = new BitSet(9);
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c == '.') continue;
            if(bitSet.get(c - 1)){
                return false;
            }else{
                bitSet.set(c - 1);
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[] c = new char[]{'5','3','.','.','7','.','.','.','.'};
        boolean validSudoku = isValidSudoku(c);
        System.out.println();
    }
}
