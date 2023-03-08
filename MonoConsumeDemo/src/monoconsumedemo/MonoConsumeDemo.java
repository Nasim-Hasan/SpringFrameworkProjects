package monoconsumedemo;

import reactor.core.publisher.Mono;

public class MonoConsumeDemo
{

 public static void main (String[] args)
 {
     Mono.just("Hello World !").subscribe(
             successValue -> System.out.println(successValue),
             error -> System.err.println(error.getMessage()),
             () -> System.out.println("Mono consumed.")
     );
 }



}
