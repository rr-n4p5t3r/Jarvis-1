//package co.com.spn.cun3.security.auth.ldap.mapper;
//
//import co.com.spn.cun3.security.auth.ldap.dto.CoreLdapPersonDto;
//import co.com.spn.cun3.util.CoreLogger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ldap.core.AttributesMapper;
//
//import javax.naming.NamingException;
//import javax.naming.directory.Attribute;
//import javax.naming.directory.Attributes;
//import java.lang.reflect.Field;
//
///**
// *
// * @author joslopez
// *
// */
//public class LdapMapper implements AttributesMapper<CoreLdapPersonDto> {
//
//	private static final Logger logger = LoggerFactory.getLogger(LdapMapper.class);
//
//	@Override
//	public CoreLdapPersonDto mapFromAttributes(final Attributes attrs) throws NamingException {
//		final CoreLdapPersonDto ret = new CoreLdapPersonDto();
//		for (final Field f : ret.getClass().getDeclaredFields()) {
//			if (f.isAnnotationPresent(LdapAnnotation.class)) {
//				final LdapAnnotation ann = f.getAnnotation(LdapAnnotation.class);
//				String name = ann.name();
//				try {
//					CoreLogger.trace(logger, "Analizando campo : {} con anotacion: {}", f, name);
//					final Attribute attribute = attrs.get(name);
//					if (attribute != null) {
//						Object value = attribute.get();
//						CoreLogger.trace(logger, "Asignando atributo: {}", value);
//						f.setAccessible(true);
//						f.set(ret, value);
//					}
//
//				} catch (IllegalArgumentException | IllegalAccessException | NullPointerException e) {
//					CoreLogger.error(logger, "Error mapeando campo: {} con anotacion: {}", f, name);
//				}
//			}
//		}
//		return ret;
//	}
//}
