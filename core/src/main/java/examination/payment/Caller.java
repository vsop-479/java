package examination.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Caller {
    static PaymentRemoteService service;
    static String[] payments = new String[]{"A", "B", "C", "D", "E"};

    ConsultResult[] getEnabledPayments() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(executor);
        for(String payment : payments){
            executorCompletionService.submit(new CRCallable(payment));
        }
        List<ConsultResult> crs = new ArrayList<>(payments.length);
        for(int i = 0; i < payments.length; i++){
            ConsultResult r = (ConsultResult) executorCompletionService.take().get();
            crs.add(r);
        }
        return crs.toArray(new ConsultResult[0]);
    }

    class CRCallable implements Callable<ConsultResult>{
        private String payment;

        CRCallable(String payment){
            this.payment = payment;
        }

        @Override
        public ConsultResult call() throws Exception {
            return service.isEnabled(payment);
        }
    }
}

