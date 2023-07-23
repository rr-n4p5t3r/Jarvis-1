package co.com.spn.cun3.security.auth.ldap.dto;

import co.com.spn.cun3.security.auth.ldap.mapper.LdapAnnotation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor(onConstructor = @__({@JsonCreator}))
@ToString(includeFieldNames = true)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public final @Data class CoreLdapPersonDto implements Serializable {

  private static final long serialVersionUID = 3945984675635424305L;

  @LdapAnnotation(name = "mail", update = false)
  private String email;

  @LdapAnnotation(name = "sAMAccountName", update = false)
  private String username;

  @LdapAnnotation(name = "userAccountControl", update = false)
  private String userAccountControl;

  @LdapAnnotation(name = "description")
  private String identity;

  @LdapAnnotation(name = "employeeID")
  private String employeeId;

  @LdapAnnotation(name = "employeeType")
  private String employeeType;

  // TODO SE OMITE SU ACTUALIZACION DE MOMENTO
  @LdapAnnotation(name = "Identificacion", update = false)
  private String identityID;

  /* todos los nombres en ldap */
  @LdapAnnotation(name = "name", update = false)
  private String name;

  @LdapAnnotation(name = "displayName")
  private String displayName;

  // @LdapAnnotation(name = "firstName")
  @LdapAnnotation(name = "givenName")
  private String names;

  // @LdapAnnotation(name = "lastName")
  @LdapAnnotation(name = "sn")
  private String surnames;

  @LdapAnnotation(name = "cn", update = false)
  private String nameCn;

  @LdapAnnotation(name = "distinguishedName", update = false)
  private String dn;
  /**/

  @LdapAnnotation(name = "title")
  private String job;
  @LdapAnnotation(name = "physicalDeliveryOfficeName")
  private String dependency;

  @LdapAnnotation(name = "department")
  private String workGroup;

  @LdapAnnotation(name = "telephoneNumber")
  private String officePhone;

  @LdapAnnotation(name = "office")
  private String office;

  @LdapAnnotation(name = "facsimileTelephoneNumber")
  private String faxPhone;

  @LdapAnnotation(name = "homePhone")
  private String phone;

  @LdapAnnotation(name = "mobile")
  private String mobilePhone;

  @LdapAnnotation(name = "ipPhone")
  private String secretaryPhone;

  @LdapAnnotation(name = "streetAddress")
  private String location;

  @LdapAnnotation(name = "l")
  private String city;

  @LdapAnnotation(name = "company")
  private String company;

  @LdapAnnotation(name = "manager")
  private String manager;

  @LdapAnnotation(name = "info")
  private String notes;

  private String status;

  private String picture;
}
