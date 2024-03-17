package com.mdtech.module.manageUser.repository;

import com.mdtech.module.manageUser.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
