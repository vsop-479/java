package algorithm.maxSubArray;

//dynamic programming: maxSum[i] = max(maxSum[i-1], 0) + a[i]
public class DPSolution {
    static void maxSubArraySum(int a[]){
        int[] maxSums = new int[a.length];
        int maxSum = a[0], end = 0, start = 0, subStart = 0;
        for(int i = 0; i < a.length; i++){
            if(i == 0){
                maxSums[i] = a[i];
            }else{
                if(maxSums[i - 1] > 0){
                    maxSums[i] = maxSums[i - 1] + a[i];
                }else {
                    maxSums[i] = a[i];
                    subStart = i;
                }
                if(maxSums[i] > maxSum){
                    maxSum = maxSums[i];
                    end = i;
                    start = subStart;
                }
            }
        }
        System.out.println(maxSum + ", " + start + ", " + end);
    }

    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        maxSubArraySum(a);
    }
}
