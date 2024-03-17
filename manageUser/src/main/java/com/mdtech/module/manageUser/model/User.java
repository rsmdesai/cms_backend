package com.mdtech.module.manageUser.model;

import com.mdtech.module.manageUser.enums.UserType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private UserType userType;

}
