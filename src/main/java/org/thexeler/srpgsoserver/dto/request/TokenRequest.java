package org.thexeler.srpgsoserver.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRequest {
    private String username;
    private String token;
}
