package concurrent.threadPool;

import java.util.concurrent.*;

public class CompletionServiceTest {
    private void f() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletionService<Result> completionService = new ExecutorCompletionService<>(executor);
        completionService.submit(new A("s", 1));
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