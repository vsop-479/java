package nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelT {
    void blocking() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while(true){
//            accept()方法会一直阻塞到有新连接到达
            SocketChannel socketChannel = serverSocketChannel.accept();
            //do something with socketChannel...
        }
    }

    void nonBlocking() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
//        non blocking
        serverSocketChannel.configureBlocking(false);

        while(true){
//          accept() 方法会立刻返回，如果还没有新进来的连接,返回的将是null
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel != null){
                //do something with socketChannel...
            }
        }
    }
}
