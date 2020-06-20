package me.zhyx.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @auther zhyx
 * @Date 2020/5/21 7:59
 * @Description
 */
public class EveryDay13 {
    public static void main(String[] args) {
        char [][] board = new char[][]{
                          {'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
    /**
     * 给定一个数独，判断该数独是否有效
     * 有效性的判断是：
     * 1. 数字1-9在每一行只能出现一次。
     * 2. 数字1-9在每一列只能出现一次。
     * 3. 数字1-9在每一个九宫格内只能出现一次。
     * 有效不等于可解
     */
    public static boolean isValidSudoku(char [] [] board){
       if(board==null||board.length<=1){
           return false;
       }
       for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
               if(board[i][j]!='.'){
                   if(!isValidHelp(board,board[i][j],i,j)){
                       return false;
                   }
               }
           }
       }
       return true;
    }

    private static boolean isValidHelp(char[][] board, char c, int row, int column) {
        if(board==null){
            return false;
        }
        for (int i=0;i<row;i++){
            if(board[i][column]==c&&i!=row){
                return false;
            }
        }
        for (int i=0;i<column;i++){
            if(board[row][i]==c&&i!=column){
                return false;
            }
        }
        int n=row/3;
        int m=column/3;
        for(int i=n*3;i<n*3+3;i++){
            for (int j=m*3;j<m*3+3;j++){
                if(board[i][i]==c){
                    if(i!=row&&j!=column){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
