package org.thexeler.srpgsoserver.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllSecurityRequest {
    private String username;
    private String password;
    private String token;
}
