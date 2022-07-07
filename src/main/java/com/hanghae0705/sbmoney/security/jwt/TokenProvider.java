package com.hanghae0705.sbmoney.security.jwt;

import com.hanghae0705.sbmoney.exception.ApiException;
import com.hanghae0705.sbmoney.exception.ApiRuntimeException;
import com.hanghae0705.sbmoney.model.domain.User;
import com.hanghae0705.sbmoney.model.domain.baseEntity.UserRoleEnum;
import com.hanghae0705.sbmoney.model.dto.TokenDto;
import com.hanghae0705.sbmoney.security.auth.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TokenProvider {
    private static final int SEC = 1;
    private static final int MINUTE = 60 * SEC;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    //access token 유효기간 - seconds, milliseconds
    private static final int JWT_ACCESS_TOKEN_VALID_SEC = 30 * MINUTE;
    // private static final int JWT_ACCESS_TOKEN_VALID_SEC = 86400000;
    // private static final int JWT_ACCESS_TOKEN_VALID_MILLI_SEC = 1000 * JWT_ACCESS_TOKEN_VALID_SEC;
    private static final int JWT_ACCESS_TOKEN_VALID_MILLI_SEC = 1000 * JWT_ACCESS_TOKEN_VALID_SEC;

    //refresh token 유효기간 - seconds, milliseconds
    private static final int JWT_REFRESH_TOKEN_VALID_SEC = 7 * DAY;
    // private static final int JWT_REFRESH_TOKEN_VALID_SEC = 86400000;
    // public static final int JWT_REFRESH_TOKEN_VALID_MILLI_SEC = 1000 * JWT_REFRESH_TOKEN_VALID_SEC;
    public static final int JWT_REFRESH_TOKEN_VALID_MILLI_SEC = 1000 * JWT_REFRESH_TOKEN_VALID_SEC;
    private static final String AUTHORITIES_KEY = "auth";
    public static final String TOKEN_TYPE = "Bearer";

    @Value("${jwt.secret}")
    public static String JWT_SECRET;

    @Value("${jwt.issuer}")
    public static String JWT_ISSUER;

    private static Key key;

    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenDto generateAccessToken(Authentication authentication) {
        String authority = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        //accessToken 생성
        Date accessTokenExpiresIn = new Date(System.currentTimeMillis() + JWT_ACCESS_TOKEN_VALID_MILLI_SEC);
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())       // payload "sub": "name"
                .claim(AUTHORITIES_KEY, authority)          // payload "auth": "ROLE_USER"
                .setExpiration(accessTokenExpiresIn)        // payload "exp": 1516239022 (예시)
                .signWith(key, SignatureAlgorithm.HS512)    // header "alg": "HS512"
                .compact();

        return TokenDto.builder()
                .grantType(TOKEN_TYPE)
                .accessToken(accessToken)
                .refreshToken(generateRefreshToken())
                .accessTokenExpiresIn(accessTokenExpiresIn.getTime())
                .build();
    }

    public TokenDto generateAccessToken(Authentication authentication, int expiredIn) {
        String authority = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        //accessToken 생성
        Date accessTokenExpiresIn = new Date(System.currentTimeMillis() + expiredIn);
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())       // payload "sub": "name"
                .claim(AUTHORITIES_KEY, authority)          // payload "auth": "ROLE_USER"
                .setExpiration(accessTokenExpiresIn)        // payload "exp": 1516239022 (예시)
                .signWith(key, SignatureAlgorithm.HS512)    // header "alg": "HS512"
                .compact();

        return TokenDto.builder()
                .grantType(TOKEN_TYPE)
                .accessToken(accessToken)
                .refreshToken(generateRefreshToken())
                .accessTokenExpiresIn(accessTokenExpiresIn.getTime())
                .build();
    }

    //refreshToken 생성
    Date refreshTokenExpiresIn = new Date(System.currentTimeMillis() + JWT_REFRESH_TOKEN_VALID_MILLI_SEC);
    public String generateRefreshToken() {
        return Jwts.builder()
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public Authentication getAuthentication(String accessToken){
        Claims claims = parseClaims(accessToken);

        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new ApiRuntimeException(ApiException.NO_AUTHORITY_KEY);
        }

        // 클레임에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        // UserDetails 객체를 만들어서 Authentication 리턴
        UserDetailsImpl principal = new UserDetailsImpl(new User(claims.getSubject(), "", UserRoleEnum.USER));

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
            throw new IllegalArgumentException("만료된 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

    public static Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

}