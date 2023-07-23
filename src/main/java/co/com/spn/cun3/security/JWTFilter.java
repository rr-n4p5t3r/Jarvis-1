//package co.com.spn.cun3.security;
//
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JWTFilter extends OncePerRequestFilter {
//    @Autowired
//    private UserDetailsService userDetailsService;
//    @Autowired
//    private JWTUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
//            String jwt = authHeader.substring(7);
//            if (jwt.isBlank()) {
//                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "JWT Token invalido");
//            } else {
//                try {
//                    String idUsuario = jwtUtil.validateTokenAndRetrieveSubject(jwt);
//                    UserDetails userDetails = userDetailsService.loadUserByUsername(idUsuario);
//                    UsernamePasswordAuthenticationToken authToken =
//                            new UsernamePasswordAuthenticationToken(idUsuario, userDetails.getPassword(), userDetails.getAuthorities());
//                    authToken.setDetails(userDetails);
//                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
//                        SecurityContextHolder.getContext().setAuthentication(authToken);
//                    }
//                } catch (JWTVerificationException exc) {
//                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "JWT Token invalido");
//                }
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}
