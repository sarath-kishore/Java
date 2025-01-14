package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.Token;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;

    public TokenService(TokenRepository tokenRepository, JwtService jwtService) {
        this.tokenRepository = tokenRepository;
        this.jwtService = jwtService;
    }

    public boolean validateRefreshToken(String refreshJWT){
        Optional<Token> token = tokenRepository.findByRefreshToken(refreshJWT);
        if(token.isPresent() && !token.get().getRevoked())
            return true;
        return false; // token not found in db.
    }

    public void saveRefreshToken(String refreshJWT, String username, String ipAddress, String userAgent) {
        Token token = new Token();
        token.setRefreshToken(refreshJWT);
        token.setUsername(username);
        token.setIpAddress(ipAddress);
        token.setUserAgent(userAgent);
        token.setRevoked(false);

        tokenRepository.save(token);
    }

    // add methods to revoke token, delete token
}
