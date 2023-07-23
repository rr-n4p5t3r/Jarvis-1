//package co.com.spn.cun3.security.auth.ldap.mapper;
//
//import co.com.spn.cun3.security.auth.ldap.dto.CoreLdapPersonDto;
//import co.com.spn.cun3.util.CoreLogger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.ldap.core.DirContextOperations;
//
//import java.lang.reflect.Field;
//
//public class LdapContextMapper {
//
//	private static final Logger logger = LoggerFactory.getLogger(LdapContextMapper.class);
//
//	private LdapContextMapper() {
//	}
//
//	public static void mapToContext(final CoreLdapPersonDto person, final DirContextOperations context) {
//		for (final Field f : person.getClass().getDeclaredFields()) {
//			if (f.isAnnotationPresent(LdapAnnotation.class)) {
//				final LdapAnnotation ann = f.getAnnotation(LdapAnnotation.class);
//				String name = ann.name();
//				if (ann.update()) {
//					try {
//						f.setAccessible(true);
//						Object value = f.get(person);
//						if (value != null) {
//							CoreLogger.trace(logger, "Analizando campo : {} con anotacion: {}", f, name);
//							CoreLogger.trace(logger, "Asignando atributo: {} a: {}", value, name);
//							context.setAttributeValue(name, value);
//						}
//
//					} catch (IllegalArgumentException | IllegalAccessException | NullPointerException e) {
//						CoreLogger.error(logger, "Error mapeando campo: {} con anotacion: {}", f, name);
//					}
//				}
//			}
//		}
//	}
//}
