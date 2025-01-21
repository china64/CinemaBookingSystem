package com.myproject.cinemabookingsystem_backend.utils;

import com.myproject.cinemabookingsystem_backend.model.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationTime; // 秒數

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getAccount()) // 使用 account 作為主體
                .claim("id", user.getId())
                .claim("account", user.getAccount())
                .claim("role", user.getRole()) // 加入 role 資訊
                .setIssuer("CinemaBookingSystem")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime * 1000)) // 轉換為毫秒
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public User validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            User user = new User();
            user.setId(claims.get("id",Integer.class));
            user.setAccount(claims.get("account", String.class));
            user.setRole(claims.get("role", Integer.class));
            return user; // 返回包含解析後資料的 User 對象
        } catch (JwtException | IllegalArgumentException e) {
            throw new RuntimeException("錯誤的token"+"\n");
        }
    }
}
