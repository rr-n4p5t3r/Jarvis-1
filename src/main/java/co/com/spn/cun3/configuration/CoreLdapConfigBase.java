package co.com.spn.cun3.configuration;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.pool.factory.PoolingContextSource;
import org.springframework.ldap.pool.validation.DefaultDirContextValidator;
import org.springframework.ldap.transaction.compensating.manager.TransactionAwareContextSourceProxy;
import org.springframework.stereotype.Component;

/**
 * Clase para configuración ldap
 *
 * @author joslopez
 */

@ConfigurationProperties(prefix = "ldap", ignoreUnknownFields = true, ignoreInvalidFields = true)
@Component
@ConditionalOnProperty(name = "ldap.contextSource.url") // TODO se habilita para QA y PROD
public @Data class CoreLdapConfigBase {

    private static final Logger logger = LoggerFactory.getLogger(CoreLdapConfigBase.class);

    private String url;
    private String userDn;
    private String password;

    @Bean
    public ContextSource ldapContextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(url);
        contextSource.setUserDn(userDn);
        contextSource.setPassword(password);
        contextSource.setReferral("follow");
        contextSource.setPooled(false);// para que el pool sea manejado por el siguiente contexto
        contextSource.afterPropertiesSet(); // *** need this ***

        PoolingContextSource poolingContextSource = new PoolingContextSource();
        poolingContextSource.setDirContextValidator(new DefaultDirContextValidator());
        poolingContextSource.setContextSource(contextSource);
        poolingContextSource.setTestOnBorrow(true);
        poolingContextSource.setTestWhileIdle(true);

        TransactionAwareContextSourceProxy proxy =
                new TransactionAwareContextSourceProxy(poolingContextSource);
        logger.debug("Retorno ldapContextSource proxy" + proxy);
        return proxy;
    }

    @Bean
    public LdapTemplate ldapTemplate(final ContextSource contextSource) {
        final LdapTemplate ldap = new LdapTemplate(contextSource);
        ldap.setIgnorePartialResultException(true);
        logger.debug("Retorno ldapContextSource ldap");
        return ldap;
    }
}
