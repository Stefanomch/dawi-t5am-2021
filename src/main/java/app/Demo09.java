package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo09 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		//Validar un usuario segun su usuario y clave
		String sql="{call usp_validaAcceso (:xusr, :xcla)}";
		
		//TypedQuery<Usuario> query= em.createQuery(sql,Usuario.class); JPA
		Query query=em.createNativeQuery(sql,Usuario.class); //Este resultado es como un objeto
		query.setParameter("xusr", "U002@gmail.com");
		query.setParameter("xcla", "10002");
		
		/*String sql="{call usp_validaAcceso (?, ?)}";
		
		//TypedQuery<Usuario> query= em.createQuery(sql,Usuario.class); JPA
		Query query=em.createNativeQuery(sql,Usuario.class); //Este resultado es como un objeto
		query.setParameter(1, "U002@gmail.com");
		query.setParameter(2, "10002");*/
		
		Usuario u = null;
		try {
			u = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			
		}
		
		if(u==null) {
			System.out.println("Código no existe");
		} else {
			System.out.println("Bienvenido: " + u.getNombre());
			System.out.println(u);
		}
		em.close();
	}
}
