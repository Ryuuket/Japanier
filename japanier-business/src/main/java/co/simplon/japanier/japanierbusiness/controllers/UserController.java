package co.simplon.japanier.japanierbusiness.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.japanier.japanierbusiness.dto.CreateUser;
import co.simplon.japanier.japanierbusiness.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService service;

    UserController(UserService service) {
	this.service = service;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid CreateUser inputs) {
	service.register(inputs);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody @Valid CreateUser inputs) {
	service.login(inputs);
    }
}
