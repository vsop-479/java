package algorithm.inplace;

public class CompressionArray {
    public static void compression(char[] chars){
        char count = 1;
        int i = 0;
        char current = chars[0];
        for(char c : chars){
            if(i == 0){
                i++;
                continue;
            }
            if(c == current){
                count++;
            }else{
                if(count > 1){
                    chars[i] = count;
                }
                i++;
                chars[i] = c;
                current = c;
                count = 1;
            }
        }
        chars[i] = current;
        i++;
        if(i < chars.length){
            chars[i] = count;
            i++;
        }
        //将后面的char截取
        for(int k = i; k < chars.length; k++){
            chars[k] = ' ';
        }
    }
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'a', 'b', 'b'};
       compression(chars);
    }
}
