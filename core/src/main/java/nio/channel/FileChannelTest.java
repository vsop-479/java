package nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    void f() throws IOException {
        RandomAccessFile rFile = new RandomAccessFile("", "rw");
        FileChannel channel = rFile.getChannel();

        channel = new FileInputStream("").getChannel();

//        fileChannel  中的数据读取到buffer.
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        int byteRead = channel.read(buffer);

//        将buffer中的数据写到channel。
        String data = "";
        buffer.put(data.getBytes());
        buffer.flip();
        while (buffer.hasRemaining()){
            channel.write(buffer);
        }

        channel.close();
    }
}
