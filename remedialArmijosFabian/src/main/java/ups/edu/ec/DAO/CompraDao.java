package ups.edu.ec.DAO;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.ec.Modelo.Compra;

public class CompraDao {

	@Inject
	private EntityManager em;
	
	public void nuevaCompra(Compra compra) {
		em.persist(compra);
	}
	
}
