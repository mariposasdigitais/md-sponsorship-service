package mariposas.service;

public interface JwtService {
    Boolean validate(String token, String email);

    Boolean isValid(String token);
}