package com.rest.oauth2.dto;

import com.rest.oauth2.Enum.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String userId;
    private String password;
    private String name;
    private Role role;
}
