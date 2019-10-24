package algorithm.print2DArray;

/**
 * 顺时针打印二维数组。
 * 1：以Min(height, weight) / 2计算环数。
 * 2：如果Min(height, weight)为奇数：
 *     min为height时，打印剩余的一行;
 *     min为weight时，打印剩余一列。
 */
public class Print2DArray {
    public static void print2DArray(int[][] a){
        int height = a.length;
        int weight = a[0].length;

        int min = Math.min(height, weight);
        int mid = min / 2;
        int reminder = min % 2;

//        先打印mid个环。
        for(int i = 0; i < mid; i++){
//            上边。
            for(int j = i; j < weight - i; j++){
                System.out.print(a[i][j] + ", ");
            }
//            右边。
            for(int j = i + 1; j < height - i; j++){
                System.out.print(a[j][weight - i - 1] + ", ");
            }
//            下边。
            for(int j = weight - i - 2; j >= i; j--){
                System.out.print(a[height - i - 1][j] + ", ");
            }
//            左边。
            for(int j = height - i - 2; j >= i + 1; j--){
                System.out.print(a[j][i] + ", ");
            }
        }
//        当min为奇数时，mid个环后，打印剩余一行或一列。
        if(reminder == 1){
//            打印剩余一行。
            if(weight >= height){
                for(int j = mid; j < weight - mid; j++){
                    System.out.print(a[mid][j] + ", ");
                }
            }else{
//               打印剩余一列。
                for(int j = mid; j < height - mid; j++){
                    System.out.print(a[j][mid] + ", ");
                }
            }

        }
        System.out.println();
    }

    public static void main(String[] args){
        int[][] a = new int[7][5];
        a[0] = new int[]{1, 2, 3, 4, 5};
        a[1] = new int[]{6, 7, 8, 9, 10};
        a[2] = new int[]{11, 12, 13, 14, 15};
        a[3] = new int[]{16, 17, 18, 19, 20};
        a[4] = new int[]{21, 22, 23, 24, 25};
        a[5] = new int[]{26, 27, 28, 29, 30};
        a[6] = new int[]{31, 32, 33, 34, 35};

        print2DArray(a);

        int[][] b = new int[3][3];
        b[0] = new int[]{1, 2, 3};
        b[1] = new int[]{4, 5, 6};
        b[2] = new int[]{7, 8, 9};

        print2DArray(b);

        int[][] c = new int[1][1];
        c[0][0] = 1;
        print2DArray(c);
    }
}
