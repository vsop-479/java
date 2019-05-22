package nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynchronousFileChannelT {
//    使用future异步读
    void futureRead() throws IOException, InterruptedException {
        Path path = Paths.get("");

        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1000);
        long position = 0;

        Future<Integer> operation = fileChannel.read(buffer, position);

        while(!operation.isDone()){
            Thread.sleep(1);
        }
        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();
    }

//    使用completionHandler异步读
    void completionHandlerRead() throws IOException {
        Path path = Paths.get("");

        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1000);
        long position = 0;

        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);
                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }

    //    使用future异步写
    void futureWrite() throws IOException, InterruptedException {
        Path path = Paths.get("");

        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(1000);
        long position = 0;

        buffer.put("test data".getBytes());
        buffer.flip();
        Future<Integer> operation = fileChannel.write(buffer, position);
        buffer.clear();
        while(!operation.isDone()){
            Thread.sleep(1);
        }
        System.out.println("Write done");

    }

    //    使用completionHandler异步写
    void completionHandlerWrite() throws IOException {
        Path path = Paths.get("");

        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(1000);
        long position = 0;

        buffer.put("test data".getBytes());
        buffer.flip();

        fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("bytes written: " + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }
}
