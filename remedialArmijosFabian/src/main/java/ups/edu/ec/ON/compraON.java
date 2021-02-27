package ups.edu.ec.ON;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ups.edu.ec.DAO.CompraDao;
import ups.edu.ec.Modelo.Compra;


@Stateless
public class compraON {
	
	@Inject
	private CompraDao dao;
	
	public void nuevaCompra(Compra compra) {
		dao.nuevaCompra(compra);
	}
	
		
}
