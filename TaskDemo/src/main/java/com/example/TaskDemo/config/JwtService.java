package com.example.TaskDemo.config;

<<<<<<< HEAD
import com.example.TaskDemo.services.UserService;
=======
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="KcPUoz3CSlHdsEKyytcKCjnI6JA0fiS6";
<<<<<<< HEAD
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    public JwtService(UserService userService) {
        this.userService = userService;
    }

=======
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
    public String extractUserName(String token){

        return extractClaim(token,Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){

        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    public String generateToken(
            Map<String,Object> extraClaims,
            UserDetails userDetails
    ){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        final String userName=extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);

    }

<<<<<<< HEAD
    public boolean isTokenExpired(String token) {
=======
    private boolean isTokenExpired(String token) {
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
<<<<<<< HEAD
        return Jwts.parserBuilder()
=======
        return jwts.parseBuilder()
>>>>>>> 3831ec33809aa84166b1a5d2636e98a4387f030d
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

