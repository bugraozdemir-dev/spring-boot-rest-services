package com.rest.webservices.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService userDaoService) {
        this.service = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable int id) {
        User user = service.findById(id);
        if (user == null)
            throw new UserNotFoundException("id: " + id);
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(UserResource.class).retrieveAllUsers()
        );
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping(path = "/users/{id}")
    public User deleteUserById(@PathVariable int id) {
        User user = service.deleteById(id);
        if (user == null)
            throw new UserNotFoundException("id: " + id);
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
