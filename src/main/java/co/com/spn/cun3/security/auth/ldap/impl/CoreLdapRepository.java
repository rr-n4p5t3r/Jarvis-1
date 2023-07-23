//package co.com.spn.cun3.security.auth.ldap.impl;
//
//import co.com.spn.cun3.exception.Cun3Exception;
//import co.com.spn.cun3.security.auth.ldap.ICoreLdapRepository;
//import co.com.spn.cun3.security.auth.ldap.dto.CoreLdapPersonDto;
//import co.com.spn.cun3.security.auth.ldap.mapper.LdapContextMapper;
//import co.com.spn.cun3.security.auth.ldap.mapper.LdapMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.ldap.SchemaViolationException;
//import org.springframework.ldap.core.AttributesMapper;
//import org.springframework.ldap.core.DirContextOperations;
//import org.springframework.ldap.core.LdapTemplate;
//import org.springframework.ldap.core.support.AbstractContextMapper;
//import org.springframework.ldap.query.ContainerCriteria;
//import org.springframework.ldap.query.LdapQuery;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import javax.naming.directory.BasicAttribute;
//import javax.naming.directory.DirContext;
//import javax.naming.directory.ModificationItem;
//import java.util.List;
//
//import static org.springframework.ldap.query.LdapQueryBuilder.query;
//
///**
// *
// * @author joslopez
// *
// */
//
//@Repository
//
//public class CoreLdapRepository implements ICoreLdapRepository {
//
//	private static final Logger logger = LoggerFactory.getLogger(CoreLdapRepository.class);
//
//	private static final String WARN_MSG = "Funcionalidad LDAP no soportada. Definal las Variables cun3.ldap.contextSource.{url, base, userDn, password}";
//
//	private static final String FULL_DN = "distinguishedName";
//
//	private static String base;
//
//	@Autowired(required = false)
//	private LdapTemplate ldapTemplate;
//
//	@Value("${ldap.contextSource.domain}")
//	private String domain;
//
//	@Value("${ldap.contextSource.url}")
//	private String url;
//
//	@Value("${ldap.contextSource.root}")
//	private String rootDn;
//
//	@Value("${ldap.contextSource.context.base}")
//	private String bases;
//
//	@PostConstruct
//	protected void setLdapBase() throws Exception {
//
//		if (ldapTemplate == null) {
////			CoreLogger.warn(logger, WARN_MSG);
//		} else {
//			base = bases;// ldapTemplate.getContextSource().getReadOnlyContext().getNameInNamespace();
////			CoreLogger.debug(logger, base);
//		}
//	}
//
//	@Override
//
//	public boolean isUnique(final String identity) {
//
//		final LdapQuery query = query().attributes("description").where("objectclass").is("person").and("description").is(identity);
//		final List<String> users = ldapTemplate.search(query, (AttributesMapper<String>) attrs -> attrs.get("description").get().toString());
//		return users.size() == 1;
//
//	}
//
//	@Override
//	public CoreLdapPersonDto getByIdentity(final String identity) {
//		// se busca primero por nombre de usuarios
//		final LdapQuery query = query().countLimit(1).where("objectclass").is("person").and("description").is(identity);
//		final List<CoreLdapPersonDto> list = ldapTemplate.search(query, new LdapMapper());
//		return list.isEmpty() ? null : list.get(0);
//	}
//
//	@Override
//	public CoreLdapPersonDto getByUserName(final String username) {
//		final LdapQuery query = query().countLimit(1).where("objectclass").is("person").and("sAMAccountName").is(username);
//		final List<CoreLdapPersonDto> list = ldapTemplate.search(query, new LdapMapper());
//		return list.isEmpty() ? null : list.get(0);
//	}
//
//	@Override
//	public boolean existsByEmail(final String email) {
//		final LdapQuery query = query().countLimit(1).where("objectclass").is("person").and("mail").is(email);
//		final List<CoreLdapPersonDto> list = ldapTemplate.search(query, new LdapMapper());
//		return !list.isEmpty();
//	}
//
//	@Override
//	public String getDnForUser(String username) {
//		final List<String> result = ldapTemplate.search(query().where("sAMAccountName").is(username), new AbstractContextMapper<String>() {
//
//			@Override
//			protected String doMapFromContext(DirContextOperations ctx) {
//				return ctx.getNameInNamespace();
//			}
//		});
//
//		if (result.size() != 1) {
//			throw new RuntimeException("Usuario no encontrado o no es unico: " + username);
//		}
//		return result.get(0);
//	}
//
//	@Override
//	// TODO arreglar la búsqueda
//	public void update(final String dn, final CoreLdapPersonDto dto) {
//		try {
//			final DirContextOperations context = ldapTemplate.lookupContext(dn);
//			LdapContextMapper.mapToContext(dto, context);
//			ldapTemplate.modifyAttributes(context);
//		} catch (final Exception e) {
//			throw new Cun3Exception(e, "Error al actualizar la información del usuario en el LDAP: " + dto.getIdentity());
//		}
//	}
//
//	@Override
//	// TODO arreglar la búsqueda
//	public void update(final CoreLdapPersonDto dto) {
//		try {
//			DirContextOperations context;
//			String dnAnt = dto.getDn();
//			if (dnAnt != null) {
//				// se limpia el DN de forma temporal para evitar errores de actualizacion
//				dto.setDn(null);
//				context = ldapTemplate.lookupContext(dnAnt);
//			} else {
//				final LdapQuery query = query().countLimit(1).where("objectclass").is("person").and("sAMAccountName").is(dto.getUsername());
//				context = ldapTemplate.searchForContext(query);
//				dnAnt = context.getDn().toString();
//			}
//
//			LdapContextMapper.mapToContext(dto, context);
//			ldapTemplate.modifyAttributes(context);
//			// se asigna el dn
//			dto.setDn(dnAnt);
//
//		} catch (final EmptyResultDataAccessException e) {
//			final String msg = "El usuario " + dto.getUsername() + " no existe en el LDAP";
//			throw new Cun3Exception(e, msg);
//		} catch (final SchemaViolationException e) {
//			final String msg = "El usuario no se puede actualizar debido a que violaria el esquema LDAP. La actualización debe hacerse manual";
//			throw new Cun3Exception(e, msg);
//		} catch (final Exception e) {
//			throw new Cun3Exception(e, "Error al realizar la actualizacion de datos en el LDAP", e.getMessage(), "para el susuario:",
//					dto.getIdentity());
//		}
//	}
//
//	protected ContainerCriteria buildCriteria(final String username) {
//		return query().where("objectclass").is("person").and("sAMAccountName").is(username);
//	}
//
//	@Override
//	public void changePwd(final String username, final String newPass) {
//		final long init = System.currentTimeMillis();
//		// se consulta el dn desde la sesion
////		String dn = CoreUserUtils.getDetails().getDn();
//		// si no tiene, se consulta desde el LDAP (Mas lento)
//		if (dn == null) {
//			dn = getDnForUser(username).replace("," + base, "");
//		}
//		try {
//			final ModificationItem[] mods = new ModificationItem[1];
//			mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, new BasicAttribute("unicodePwd", encodePassword(newPass)));
//			// Perform the update
//			ldapTemplate.modifyAttributes(dn, mods);
//			CoreLogger.info(logger, "Modificación Ldap: {} ms", System.currentTimeMillis() - init);
//		} catch (final Exception e) {
//			CoreLogger.error(logger, "Error al cambiar la clave. Excepcion: {}", e.getMessage());
//			throw new Cun3Exception(e, "Error al cambiar la clave. Excepcion.", e.getMessage());
//		}
//	}
//
//	private byte[] encodePassword(String pwd) {
//		final String password = "\"" + pwd + "\"";
//		final char unicodePwd[] = password.toCharArray();
//		final byte pwdArray[] = new byte[unicodePwd.length * 2];
//		for (int i = 0; i < unicodePwd.length; i++) {
//			pwdArray[i * 2 + 1] = (byte) (unicodePwd[i] >>> 8);
//			pwdArray[i * 2 + 0] = (byte) (unicodePwd[i] & 0xff);
//		}
//		return pwdArray;
//
//	}
//
//	protected ContainerCriteria getQuery(String username) {
//		return query().attributes(FULL_DN).countLimit(1).where("objectclass").is("user").and("sAMAccountName").is(username);
//	}
//
//	@Override
//	public void disableEnableUser(String dnUser, Boolean enable) {
//
//		final ModificationItem[] mods = new ModificationItem[1];
//		final long init = System.currentTimeMillis();
//		// se consulta el dn desde la sesion
//		final String dn = getDnForUser(dnUser).replace("," + base, "");
//		if (enable) {
//			// To enable user
//			final int UF_ACCOUNT_ENABLE = 0x0001;
//			mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
//					new BasicAttribute("userAccountControl", Integer.toString(UF_ACCOUNT_ENABLE)));
//		} else {
//			// To disable user
//			final int UF_ACCOUNT_DISABLE = 0x0002;
//			mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE,
//					new BasicAttribute("userAccountControl", Integer.toString(UF_ACCOUNT_DISABLE)));
//		}
//
//		ldapTemplate.modifyAttributes(dn, mods);
//		CoreLogger.info(logger, "Se Realiza la modificación en el Ldap para el usuario {} con un tiempo {} ms ", dnUser,
//				System.currentTimeMillis() - init);
//	}
//}
