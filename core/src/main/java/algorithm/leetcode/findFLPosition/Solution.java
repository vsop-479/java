package algorithm.leetcode.findFLPosition;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                first = last = mid;
                while(mid > 0){
                    mid--;
                    if(nums[mid] == target){
                        first = mid;
                    }else{
                        break;
                    }
                }
                mid = last;
                while(mid < nums.length - 1){
                    mid++;
                    if(nums[mid] == target){
                        last = mid;
                    }else{
                        break;
                    }
                }
                break;
            }
        }
        return new int[]{first, last};
    }

    public static void main(String[] args){
        int[] r1 = searchRange(new int[]{2, 2}, 2);
        System.out.println(r1[0] + ", " + r1[1]);
    }
}
