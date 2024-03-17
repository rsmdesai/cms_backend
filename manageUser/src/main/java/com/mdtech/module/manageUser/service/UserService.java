package com.mdtech.module.manageUser.service;

import com.mdtech.module.manageUser.dto.UserRequest;
import com.mdtech.module.manageUser.dto.UserResponse;
import com.mdtech.module.manageUser.enums.UserType;
import com.mdtech.module.manageUser.model.User;
import com.mdtech.module.manageUser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserRequest userRequest){
        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .userType(UserType.valueOf(userRequest.getUserType().name()))
                .build();
        userRepository.save(user);
        log.info("User {} is saved successfully",user.getId());
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToUser).toList();
    }

    public void editUser(String id, UserRequest userRequest) throws  Exception{
        User user =userRepository.findById(id).orElseThrow(()-> new Exception());
        user.setUserType(UserType.valueOf(userRequest.getUserType().name()));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        userRepository.save(user);
        log.info("Users {} updated details were saved successfully",user.getId());
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
        log.info("User {} deleted successfully",id);
    }

    private UserResponse mapToUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userType(user.getUserType())
                .build();
    }

    public UserResponse getUserById(String id) throws  Exception{
        User user =userRepository.findById(id).orElseThrow(()-> new Exception());
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userType(user.getUserType())
                .build();
    }
}
