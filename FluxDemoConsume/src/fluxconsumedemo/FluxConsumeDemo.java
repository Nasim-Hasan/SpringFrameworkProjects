package fluxconsumedemo;

import reactor.core.publisher.Flux;

public class FluxConsumeDemo
{
   public static void main (String[] args)
   {
       Flux.range(1, 5).subscribe(
               successValue -> System.out.println(successValue),
               error -> System.err.println(error.getMessage()),
               () -> System.out.println("Flux consumed.")
       );

   }

}
