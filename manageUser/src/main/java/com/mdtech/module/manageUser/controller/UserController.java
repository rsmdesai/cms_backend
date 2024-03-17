package com.mdtech.module.manageUser.controller;

import com.mdtech.module.manageUser.dto.UserRequest;
import com.mdtech.module.manageUser.dto.UserResponse;
import com.mdtech.module.manageUser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000",
        methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@PathVariable(value = "id") String id,
                         @RequestBody UserRequest userRequest) throws  Exception{
        userService.editUser(id, userRequest);
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(value = "id") String id){
        userService.deleteUser(id);
    }
}
