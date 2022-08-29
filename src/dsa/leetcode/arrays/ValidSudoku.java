package dsa.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
    }

    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rowSets = new ArrayList<>();
        ArrayList<HashSet<Character>> colSets = new ArrayList<>();
        ArrayList<HashSet<Character>> tiles = new ArrayList<>();

        for(int i=0;i<9;i++){
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
            tiles.add(new HashSet<>());
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    continue;
                }

                if(rowSets.get(i).contains(board[i][j])){
                    return false;
                }

                if(colSets.get(j).contains(board[i][j])){
                    return false;
                }

                int tileIndex = getTileIndex(i,j);

                if(tiles.get(tileIndex).contains(board[i][j])){
                    return false;
                }
                rowSets.get(i).add(board[i][j]);
                colSets.get(j).add(board[i][j]);
                tiles.get(tileIndex).add(board[i][j]);
            }
        }

        return true;
    }

    public int getTileIndex(int row,int col){
        if(row <3 && col < 3){
            return 0;
        }
        if(row < 3 && col < 6){
            return 1;
        }

        if(row <3 && col < 9){
            return 2;
        }

        if(row <6 && col < 3){
            return 3;
        }
        if(row < 6 && col < 6){
            return 4;
        }

        if(row <6 && col < 9){
            return 5;
        }

        if(row <9 && col < 3){
            return 6;
        }

        if(row < 9 && col < 6){
            return 7;
        }

        return 8;
    }
}
