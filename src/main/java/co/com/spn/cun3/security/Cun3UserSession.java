//package co.com.spn.cun3.security;
//
//import co.com.spn.cun3.db.entities.Usuario;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class Cun3UserSession implements UserDetails {
//
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//
//	private final Usuario usuario;
//
//	private final Collection<? extends GrantedAuthority> authorities;
//
//	private final Long codigoRol;
//
//	private final String dn;
//
//	private final Long codigoUsuario;
//
//	Cun3UserSession(Usuario usuario, Collection<? extends GrantedAuthority> authorities, String dn) {
//		this.usuario = usuario;
//		this.authorities = authorities;
//		this.codigoRol = usuario.getCodigoRol();
//		this.dn = dn;
//		this.codigoUsuario = usuario.getId();
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return usuario.getContraseña();
//	}
//
//	@Override
//	public String getUsername() {
//		return usuario.getIdUsuario();
//	}
//
//	public Long getUserCode() {
//		return usuario.getId();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return usuario.getEstado() == 'A';
//	}
//
//	public Long getRol() {
//		return codigoRol;
//	}
//
//	public Long getCodigoUsuario() {
//		return codigoUsuario;
//	}
//
//	public String getDn() {
//		return dn;
//	}
//
//}
