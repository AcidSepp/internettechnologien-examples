package de.haw.landshut.itt.rest;

import de.haw.landshut.itt.rest.pojo.User;
import de.haw.landshut.itt.rest.pojo.UserWithId;
import de.haw.landshut.itt.rest.users.UserDatabaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserRestController {

    private final UserDatabaseService userDatabaseService;

// snippet: autoWired
    @Autowired
    public UserRestController(final UserDatabaseService userDatabaseService) {
        this.userDatabaseService = userDatabaseService;
    }
// snippet: /autoWired


// snippet: post
    @PostMapping(value = "/users")
    @ResponseBody
    public UserWithId postUser(@Valid @RequestBody User user) {
        return userDatabaseService.createUser(user);
    }
// snippet: /post

// snippet: get
    @GetMapping(value = "/users")
    @ResponseBody
    public List<UserWithId> getUsers() {
        return userDatabaseService.listUsers();
    }
// snippet: /get

// snippet: pathVariables
    @GetMapping(value = "/users/{id}")
    @ResponseBody
    public ResponseEntity<UserWithId> getUser(@PathVariable String id) {
        final var userWithId = userDatabaseService.readUser(id);
        if (userWithId == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userWithId);
    }
// snippet: /pathVariables


// snippet: put
    @PutMapping(value = "/users/{id}")
    @ResponseBody
    public UserWithId putUser(@PathVariable String id, @RequestBody User user) {
        return userDatabaseService.updateUser(id, user);
    }
// snippet: /put


// snippet: delete
    @DeleteMapping(value = "/users/{id}")
    @ResponseBody
    public UserWithId deleteUser(@PathVariable String id) {
        return userDatabaseService.deleteUser(id);
    }
// snippet: /delete

}
