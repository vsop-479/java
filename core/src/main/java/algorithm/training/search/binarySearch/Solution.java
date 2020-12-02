package algorithm.training.search.binarySearch;

public class Solution {
    public static int search(int[] a, int target){
        int start = 0;
        int end = a.length - 1;
        int mid;
        while(start <= end){
            mid = (start + end) / 2;
            if(a[mid] > target){
                end = mid - 1;
            }else if(a[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a1 = new int[]{1,4,5,22,24,26,30,39,40,69};
        System.out.println(search(a1, 1));
        System.out.println(search(a1, 4));
        System.out.println(search(a1, 24));
        System.out.println(search(a1, 30));
        System.out.println(search(a1, 40));
        System.out.println(search(a1, 3));
    }
}
