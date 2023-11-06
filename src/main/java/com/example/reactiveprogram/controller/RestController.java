package com.example.reactiveprogram.controller;


import com.example.reactiveprogram.dao.DAO;
import com.example.reactiveprogram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {

    @Autowired
    private DAO dao;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getUsers(){

        return dao.getUsersStream();

    }
}
