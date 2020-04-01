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
        int maxS = 0;
        int currentStart = -1, currentEnd = -1, currentS = 0;
        int targetStart = -1, targetEnd = -1, target = -1;
        boolean startFlag = false;

        for(int i = 0; i < a.length; i++){
            if(!startFlag && a[i] == 0){
                currentStart = i;
                startFlag = true;
            }
            if(startFlag && a[i] == 0 &&
                    (i == a.length - 1 || a[i + 1] == 1)){
                currentEnd = i;
                startFlag = false;
                currentS = currentEnd - currentStart + 1;
                if(currentStart != 0 && currentEnd != a.length - 1){
                    currentS = currentS %2 == 0 ? currentS / 2 : currentS / 2 + 1;
                }

                if(currentS > maxS){
                    maxS = currentS;
                    targetStart = currentStart;
                    targetEnd = currentEnd;
                }

                if(currentS >= a.length / 2){
                    break;
                }
            }
        }

        if(targetStart == 0){
            target = 0;
        }else if(targetEnd == a.length - 1){
            target = targetEnd;
        }else if(targetStart > 0){
            target = (targetStart + targetEnd) / 2;
        }

        if(target != -1){
            a[target] = 1;
        }
        return target;
    }

    public void leave(int p) {
        a[p] = 0;
    }

    public static void main(String[] args){
        ExamRoom examRoom = new ExamRoom(4);
        int seat = examRoom.seat();
        System.out.println(seat);
        seat = examRoom.seat();
        System.out.println(seat);
        seat = examRoom.seat();
        System.out.println(seat);
        seat = examRoom.seat();
        System.out.println(seat);
        examRoom.leave(1);
        examRoom.leave(3);
        seat = examRoom.seat();
        System.out.println(seat);
    }
}
