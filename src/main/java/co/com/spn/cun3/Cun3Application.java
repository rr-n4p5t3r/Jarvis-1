package co.com.spn.cun3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration;

@SpringBootApplication(exclude = {LdapAutoConfiguration.class, org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
//@EnableLdapRepositories({ "co.com.spn.cun3.security.auth.ldap" })
//@SessionAttributes("authorizationRequest")
public class Cun3Application {
    public static void main(String[] args) {
        SpringApplication.run(Cun3Application.class, args);
    }
}
