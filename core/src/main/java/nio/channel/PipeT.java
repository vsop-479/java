package nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeT {
    void f() throws IOException {
        Pipe pipe = Pipe.open();

//        将数据写入SinkChannel.
        Pipe.SinkChannel sink = pipe.sink();
        String s = "";
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        buffer.clear();
        buffer.put(s.getBytes());
        buffer.flip();
        while(buffer.hasRemaining()){
            sink.write(buffer);
        }

//        从source中读取数据.
        Pipe.SourceChannel source = pipe.source();
        ByteBuffer readBuffer = ByteBuffer.allocate(1000);
        int read = source.read(readBuffer);
    }
}
