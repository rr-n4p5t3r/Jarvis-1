package co.com.spn.cun3.security;

/**
 * 
 * @author joslopez
 *
 * @param <T>
 */
public interface ICoreEntity<T> {
	/**
	 * Crea un dto con la informacion completa de la entidad (Si tiene otras entidades asociadas, estas tambien se construyen)
	 * 
	 * @return Dto Completo
	 */
	T toDto();

	/**
	 * Crea un dto con la informacion basica necesaria de la entidad (Si tiene otras entidades asociadas, estas solo se instancia con id)
	 * 
	 * @return Dto con la informacion basica
	 */
	T toSimpleDto();
}
	