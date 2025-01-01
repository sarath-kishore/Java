package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(user.getUsername())
                .issuer("SKR")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*10*1000))
                .and()
                .signWith(generateKey())
                .compact();
    }

    private SecretKey generateKey() {
        byte[] decode = Decoders.BASE64.decode(getSecret());
        return Keys.hmacShaKeyFor(decode);
    }

    private String getSecret(){
        return "0aaa0bb866ccce9ea2703303e9db0d60fecf814aa2c8a1e94217f15dee84915c91619f570cf481f13208d7c5500f0f76c9db3b30c2de11f4eb0b99478cac6a88e4de11d23fee1008240df3dd90d633907c444451089fc23fe7f58463d762b0622f9402d6be2c98d50b6f0770952a9ff827271a5faf23127db99c58de2b29ddc865924f64ca1a84323879c425a94478be5126d794f0f77aa976cd32d8e36422fe22a6f356a72646878280d2e2deb9c4735e4c7b616776a3e4b3a76fe376a95c3eac472b59ca7d09fad05a9bc381d1379f507ff3a65c55bc24292cac9a9949b08bbd9dd9b8f92dee94e370a92382a835753413f11d7ab02a089bf7121bcef8bc14";
    }

    public String extractUsername(String jwt) {
        return extractClaims(jwt, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimResolver) {
        Claims claims = extractClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        final String username = extractUsername(jwt);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
    }

    private boolean isTokenExpired(String jwt) {
        return extractExpirationTime(jwt).before(new Date());
    }

    private Date extractExpirationTime(String jwt) {
        return extractClaims(jwt, Claims::getExpiration);
    }


}
