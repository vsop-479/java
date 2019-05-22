package nio.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesT {
    void f() throws IOException {
        Path path = Paths.get("/opt/work");

//        不考虑系统中的软连接
        boolean exists = Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});

        Files.createDirectories(path);

    }
}
