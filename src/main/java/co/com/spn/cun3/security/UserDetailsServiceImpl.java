//package co.com.spn.cun3.security;
//
//import co.com.spn.cun3.db.entities.Usuario;
//import co.com.spn.cun3.db.repositories.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//	@Autowired
//	private UsuarioRepository repo;
//
//	@SuppressWarnings("unused")
//	@Override
//	public UserDetails loadUserByUsername(String idUsuario) throws UsernameNotFoundException {
//		Usuario us = repo.findByIdUsuario(idUsuario);
//		us.getCodigoRol();
//		if (us == null) {
//			throw new UsernameNotFoundException(String.format("No se encontro el usuario identificado por %s", idUsuario));
//		}
//		return new Cun3UserSession(us, Collections.singletonList(new SimpleGrantedAuthority("AUTENTICADO")), "");
//	}
//}
