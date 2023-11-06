package com.example.reactiveprogram.handler;

import com.example.reactiveprogram.dao.DAO;
import com.example.reactiveprogram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserHandler {

    @Autowired
    private DAO dao;


    public Mono<ServerResponse> loadCustomers(ServerRequest request){
        Flux<User> userList = dao.getUsersStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(userList, User.class);
    }

    public Mono<ServerResponse> findCustomer(ServerRequest request){
        int userId= Integer.parseInt( request.pathVariable("id"));
        Mono<User> userMono = dao.getUserList().filter(c -> c.getId() == userId).next();
        return ServerResponse.ok().body(userMono, User.class);
    }

}