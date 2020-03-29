package algorithm.leetcode.examRoom;

/**
 * https://leetcode-cn.com/problems/exam-room/
 */
public class ExamRoom {
    private final int N;
    private int[] a;

    public ExamRoom(int N) {
        this.N = N;
        a = new int[N];
    }

    public int seat() {
        if(a[0] == 0){
            a[0] = 1;
            return 0;
        }
        int maxS = 0;
        int currentStart = 0, currentEnd = 0;
        int targetStart = 0, targetEnd = 0, target;
        boolean startFlag = false;

        for(int i = 0; i < a.length; i++){
            if(!startFlag && a[i] == 1 && a[i + 1] == 0){
                currentStart = i;
                startFlag = true;
            }

            if(i > currentStart && startFlag &&
                    ((a[i] == 1 && a[i - 1] == 0) || ( i == a.length - 1))){
                currentEnd = i;
                startFlag = false;
                if(currentEnd - currentStart > maxS){
                    maxS = currentEnd - currentStart;
                    targetStart = currentStart;
                    targetEnd = currentEnd;

                    if(maxS >= a.length / 2) break;
                }
            }

            if(!startFlag && a[i] == 1 && a[i + 1] == 0){
                currentStart = i;
                startFlag = true;
            }

        }

        if(targetStart + 1 == targetEnd){
            return -1;
        }

        target = targetStart + targetEnd / 2;
        a[target] = 1;
        return target;
    }

    public void leave(int p) {
        a[p] = 0;
    }

    public static void main(String[] args){
        ExamRoom examRoom = new ExamRoom(9);
        int seat0 = examRoom.seat();
        int seat1 = examRoom.seat();
        System.out.println();
    }
}
