package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica=Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em=fabrica.createEntityManager();
		
		//Validar un usuario segun su usuario y clave
		String sql="select u from Usuario u where u.usuario = :xusr and u.clave = :xclave";
		
		TypedQuery<Usuario> query= em.createQuery(sql,Usuario.class);
		query.setParameter("xusr", "U002@gmail.com");
		query.setParameter("xclave", "10003");
		
		Usuario u = null;
		try {
			u = query.getSingleResult();
		} catch (Exception e) {
		}
		
		if(u==null) {
			System.out.println("Código no existe");
		} else {
			System.out.println("Bienvenido: " + u.getNombre());
			System.out.println(u);
		}
		System.out.println("Eliminación Ok");
		em.close();
	}
}
