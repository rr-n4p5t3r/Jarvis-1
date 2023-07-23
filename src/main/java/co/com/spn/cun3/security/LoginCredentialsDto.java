package co.com.spn.cun3.security;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginCredentialsDto {

    private String idUsuario;
    private String password;

}
