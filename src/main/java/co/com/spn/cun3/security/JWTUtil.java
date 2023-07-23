//package co.com.spn.cun3.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JWTUtil {
//
//    @Value("${jwt_secret}")
//    private String secret;
//
//    public String generateToken(String idUsuario) throws IllegalArgumentException, JWTCreationException {
//        return JWT.create()
//                .withSubject("cun3Login")
//                .withClaim("idUsuario", idUsuario)
//                .withIssuedAt(new Date())
//                .withIssuer("4-72")
//                .sign(Algorithm.HMAC256(secret));
//    }
//
//    public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
//                .withSubject("cun3Login")
//                .withIssuer("4-72")
//                .build();
//        DecodedJWT jwt = verifier.verify(token);
//        return jwt.getClaim("idUsuario").asString();
//    }
//}
//package co.com.spn.cun3.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JWTUtil {
//
//    @Value("${jwt_secret}")
//    private String secret;
//
//    public String generateToken(String idUsuario) throws IllegalArgumentException, JWTCreationException {
//        return JWT.create()
//                .withSubject("cun3Login")
//                .withClaim("idUsuario", idUsuario)
//                .withIssuedAt(new Date())
//                .withIssuer("4-72")
//                .sign(Algorithm.HMAC256(secret));
//    }
//
//    public String validateTokenAndRetrieveSubject(String token)throws JWTVerificationException {
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
//                .withSubject("cun3Login")
//                .withIssuer("4-72")
//                .build();
//        DecodedJWT jwt = verifier.verify(token);
//        return jwt.getClaim("idUsuario").asString();
//    }
//}
