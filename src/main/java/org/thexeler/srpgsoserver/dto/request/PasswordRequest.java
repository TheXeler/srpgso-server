package org.thexeler.srpgsoserver.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordRequest {
    private String username;
    private String password;
}