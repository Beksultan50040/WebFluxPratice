package com.example.reactiveprogram.dao;


import com.example.reactiveprogram.model.User;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class DAO {

    public Flux<User> getUsersStream(){

        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("count: " + i))
                .map(u -> new User(1, "User" + u));
    }

    public Flux<User> getUserList()  {
        return Flux.range(1,50)
                .doOnNext(i -> System.out.println("count : " + i))
                .map(i -> new User(i, "customer" + i));
    }
}
