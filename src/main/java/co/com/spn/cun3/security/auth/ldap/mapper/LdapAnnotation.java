package co.com.spn.cun3.security.auth.ldap.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author joslopez
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LdapAnnotation {

	String name();

	/**
	 * Indica si esta variable se debe actualizar en ldap
	 * 
	 * @return
	 */
	boolean update() default true;

}
