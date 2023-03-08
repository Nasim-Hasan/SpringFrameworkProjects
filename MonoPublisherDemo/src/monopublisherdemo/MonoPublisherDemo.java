package monopublisherdemo;

import reactor.core.publisher.Mono;

public class MonoPublisherDemo {

    public static void main(String[] args)
    {
        Mono.fromRunnable(() -> System.out.println("Hello"))
                .subscribe(
                        i -> System.out.println("Received :: " + i),
                        err -> System.out.println("Error :: " + err),
                        () -> System.out.println("Successfully completed"));
    }
}
