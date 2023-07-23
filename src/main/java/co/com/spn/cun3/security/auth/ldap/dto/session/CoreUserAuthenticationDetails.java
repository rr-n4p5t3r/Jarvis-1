package co.com.spn.cun3.security.auth.ldap.dto.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @author joslopez
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class CoreUserAuthenticationDetails implements Serializable {

	private static final long serialVersionUID = -1295305913265155885L;
	private Integer id;
	private String ip;
	private String email;
	private String dn;
	private String identity;
	private String names;
	private Integer userType;
}
