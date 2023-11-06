package com.example.reactiveprogram;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebFluxTest {

    @Test
    public void testMono() {

        Mono<String> mono = Mono.just("Test").log();
        mono.subscribe(System.out::println);
    }

    @Test
    public void testFlux(){

        Flux<String> flux = Flux.just("Kaspi", "Halyk", "RBK");
        flux.subscribe(System.out::println);
    }

    @Test
    public void mapExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.map(color -> color.charAt(0)).subscribe(System.out::println);
    }
}
