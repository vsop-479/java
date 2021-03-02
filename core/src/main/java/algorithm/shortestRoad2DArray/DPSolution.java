package algorithm.shortestRoad2DArray;

import java.util.ArrayList;
import java.util.List;

//dynamic programming: shortest[i][j] = min(shortest[i][j - 1], shortest[i - 1][j]) + a[i][j]
public class DPSolution {

    //fill all road, then find the path.
    public static int getRoad(int arr[][])
    {
        int dp[][]=new int [arr.length][arr[0].length];
        dp[0][0]=arr[0][0];
        for(int i=1;i<arr.length;i++)
        {
            dp[i][0]=dp[i-1][0]+arr[i][0];
        }
        for(int j=1;j<arr[0].length;j++)
        {
            dp[0][j]=dp[0][j-1]+arr[0][j];
        }
        for(int i=1;i<arr.length;i++) {
            for (int j = 1; j < arr[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }

        List<Integer> roadTracker = new ArrayList<>();
        int i = arr.length - 1, j = arr[0].length - 1;
        while(true){
            roadTracker.add(arr[i][j]);
            if(i == 0 && j == 0){
                break;
            }else if(i == 0){
                j--;
            }else if(j == 0){
                i--;
            }else{
                if(dp[i][j - 1] < dp[i - 1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        for(int road : roadTracker){
            System.out.print(road + ", ");
        }
        System.out.println();
        return dp[arr.length-1][arr[0].length-1];
    }

    public static int getShortestRoad(int[][] a, int i, int j){
        if(i == 0 && j == 0){
            return a[0][0];
        }else if(i == 0){
            int leftRoad = getShortestRoad(a, i, j - 1) + a[i][j];
            return leftRoad;
        }else if(j == 0){
            int upRoad = getShortestRoad(a, i - 1, j) + a[i][j];
            return upRoad;
        }else{
            int leftRoad = getShortestRoad(a, i, j - 1);
            int upRoad = getShortestRoad(a, i - 1, j);
            if(leftRoad < upRoad){
                return leftRoad + a[i][j];
            }else{
                return upRoad + a[i][j];
            }
        }
    }

    public static void main(String[] args){
        int[][] a = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        List<Integer> roadTracker = new ArrayList<>();
        System.out.println(getShortestRoad(a, 3, 3));
        System.out.println(getRoad(a));
//        for(int road : roadTracker){
//            System.out.print(road + ", ");
//        }
    }
}
