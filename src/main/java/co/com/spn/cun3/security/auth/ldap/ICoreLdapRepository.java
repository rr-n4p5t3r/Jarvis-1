package co.com.spn.cun3.security.auth.ldap;

import co.com.spn.cun3.security.auth.ldap.dto.CoreLdapPersonDto;

/**
 * 
 * @author joslopez
 *
 */
// @RepositoryRestResource(exported = false)
public interface ICoreLdapRepository {
	/**
	 * Valida si la cedula enviada como parametro esta asociada a un unico usuario del LDAP
	 * 
	 * @param identity
	 *            cedula a consulta
	 * @return true si la cedula se encuentra una unica vez en el LDAP
	 */
	boolean isUnique(final String identity);

	CoreLdapPersonDto getByIdentity(String identity);

	CoreLdapPersonDto getByUserName(final String username);

	boolean existsByEmail(String email);

	public String getDnForUser(String username);

	void update(final String dn, final CoreLdapPersonDto dto);

	void changePwd(String username, String newPass);

	void disableEnableUser(String dnUser, Boolean enable);

	void update(CoreLdapPersonDto dto);
}
