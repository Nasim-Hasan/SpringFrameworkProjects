package fluxobserverdemo;

import reactor.core.publisher.Flux;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class FluxObserverDemo {

    public static void main(String[] args)
    {
            System.out.println("Starts");

       //flux emits one element per second
            Flux<Character> flux = Flux.just('a', 'b', 'c', 'd')
                    .delayElements(Duration.ofSeconds(1));
       //Observer 1 - takes 500ms to process
            flux
                    .map(Character::toUpperCase)
                    .subscribe(i -> {
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Observer-1 : " + i);
                    });
       //Observer 2 - process immediately
            flux.subscribe(i -> System.out.println("Observer-2 : " + i));

            System.out.println("Ends");
    }

}
