package algorithm.ipTree.util;

import algorithm.ipTree.model.Element;
import algorithm.ipTree.model.IPTree;

public class CommonUtil<T> {
    public <T> void put(String ip, T value){
        Element pointer = IPTree.getInstance().getRoot();
        for(String sub : ip.split("\\.")){
            int k = Integer.valueOf(sub);
            for(int i = 7; i >= 0; i--){
                int b = k >> i & 1;
                if(b == 0){
                    Element left = pointer.getLeft();
                    if(left == null){
                        left = new Element();
                        pointer.setLeft(left);
                    }
                    pointer = left;
                }else if(b == 1){
                    Element right = pointer.getRight();
                    if(right == null){
                        right = new Element();
                        pointer.setRight(right);
                    }
                    pointer = right;
                }
            }
        }
        pointer.setValue(value);
        System.out.println();
    }

    public T get(String ip){
        Element<T> pointer = IPTree.getInstance().getRoot();
        if(pointer == null){
            return null;
        }
        for(String sub : ip.split("\\.")) {
            int k = Integer.valueOf(sub);
            for (int i = 7; i >= 0; i--) {
                int b = k >> i & 1;
                if(b == 0){
                    Element left = pointer.getLeft();
                    if(left == null){
                        return null;
                    }
                    pointer = left;
                }else if(b == 1){
                    Element right = pointer.getRight();
                    if(right == null){
                        return null;
                    }
                    pointer = right;
                }
            }
        }
        return pointer.getValue();
    }

    public static void main(String[] args){
        CommonUtil<Boolean> commonUtil = new CommonUtil<>();
        commonUtil.put("220.181.171.191", true);
        commonUtil.put("10.95.134.106", true);
        commonUtil.put("10.134.134.106", false);
        commonUtil.put("225.225.225.225", false);
        commonUtil.put("220.181.10.10", false);
        commonUtil.put("127.0.0.1", true);

        Boolean aBoolean = commonUtil.get("127.0.0.1");
    }

}
