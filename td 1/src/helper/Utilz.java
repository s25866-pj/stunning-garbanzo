package helper;

import java.util.ArrayList;

public class Utilz {
    public static int[][] ArrayListTo2D(ArrayList<Integer> list, int ySize, int xSize){
    int [][]  newArr =  new int [ySize][xSize];

    for (int j=0;j< newArr.length;j++){
        for(int i=0;i< newArr[j].length;i++){
            int index=j*ySize+i;
        }

    }
        return newArr;
 }
 public static int[] TwoDto1DintArr(int [][] twoArr){
    int [] oneArr = new int [twoArr.length * twoArr[0].length];

     for (int j=0;j< twoArr.length;j++){
         for(int i=0;i< twoArr[j].length;i++){
             int index=j* twoArr.length+i;
             oneArr[index] = twoArr[j][i];
         }

     }
     return oneArr;
    }
}
