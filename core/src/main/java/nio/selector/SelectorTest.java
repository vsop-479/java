package nio.selector;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {
    ServerSocketChannel getChannel(){
        return null;
    }
    void f() throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel channel = getChannel();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT);

        while(true){
            int readyChannels = selector.select();
            if(readyChannels == 0){
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if(key.isAcceptable()){
                    // a connection was accepted by a ServerSocketChannel.
                }else if(key.isConnectable()){
                    // a connection was established with a remote server.
                }else if(key.isReadable()){
                    // a channel is ready for reading
                }else if(key.isWritable()){
                    // a channel is ready for writing
                }
                keyIterator.remove();
            }
        }
    }
}
