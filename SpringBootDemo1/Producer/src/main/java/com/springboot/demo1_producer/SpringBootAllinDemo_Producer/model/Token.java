package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "jwt_tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use AUTO or UUID if preferred
    private Long id;

    @Column(nullable = false)
    private String username; // Foreign key to the user table

    @Column(nullable = false, unique = true, length = 2048)
    private String refreshToken; // Actual refresh token

//    @Column(nullable = false)
//    private LocalDateTime createdAt; // Token creation time
//
//    @Column(nullable = false)
//    private LocalDateTime expiresAt; // Token expiration time

    @Column(nullable = false)
    private Boolean revoked = false; // Flag for revocation

    private String userAgent; // User agent from the request

    private String ipAddress; // IP address from the request

    private LocalDateTime lastUsedAt; // Tracks last usage of the token

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getExpiresAt() {
//        return expiresAt;
//    }
//
//    public void setExpiresAt(LocalDateTime expiresAt) {
//        this.expiresAt = expiresAt;
//    }

    public Boolean getRevoked() {
        return revoked;
    }

    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getLastUsedAt() {
        return lastUsedAt;
    }

    public void setLastUsedAt(LocalDateTime lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
    }

}
