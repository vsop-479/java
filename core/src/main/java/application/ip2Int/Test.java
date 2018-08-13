package application.ip2Int;

import sun.net.util.IPAddressUtil;

import java.net.Inet4Address;
import java.net.InetSocketAddress;

public class Test {
    public static int ip2Int(String ip){
        String[] strings = ip.split("\\.");
        int i = 0;
        for(String s : strings){
            Integer a = Integer.valueOf(s);
            i = i << 8;
            i = i + a;
        }
        return i;
    }

    public static String check(String ip){
//        if(ip.matches("\\d"))
        return ip;
    }

    public static void main(String[] args){
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.1.1.1", 9200);
        int i = ip2Int("1.1.1.1");
        System.out.println(i);
        int i2 = ip2Int("127.1.1.1");
        System.out.println(i2);
    }

}
