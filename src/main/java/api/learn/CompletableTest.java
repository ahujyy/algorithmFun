package api.learn;


import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableTest {

    public static void  main(String[] args) throws ExecutionException, InterruptedException, IOException {

        /**
         CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
         int i = 1/0;
         return 100;
         });
         //future.join();
         try {
         future.get();

         } catch (InterruptedException e) {
         e.printStackTrace();
         } catch (ExecutionException e) {
         e.printStackTrace();
         }

         Thread thread = new Thread(() ->{

         });
         **/


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            System.out.println("begin to start compute");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
            return rand.nextInt(1000);
        });
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });
        System.out.println(f.get());
        System.in.read();

    }

    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

}
