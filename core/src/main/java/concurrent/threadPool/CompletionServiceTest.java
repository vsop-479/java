package concurrent.threadPool;

import java.util.concurrent.*;

public class CompletionServiceTest {
    private void f() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletionService<Result> completionService = new ExecutorCompletionService<>(executor);
        Future<Result> future = completionService.submit(new A("s", 1));
//        等future执行完成。
        Result result1 = future.get();
//        取出一个完成的future，没有则等待。
        Future<Result> take = completionService.take();
        Result result = take.get();
    }
}

class A implements Callable<Result>{
    private String s;
    private int i;

    public A(String s, int i){
        this.s = s;
        this.i = i;
    }

    @Override
    public Result call() throws Exception {
        return new Result(s, i);
    }
}

class Result {
    private String s;
    private int i;
    public Result(String s, int i){
        this.s = s;
        this.i = i;
    }
}
