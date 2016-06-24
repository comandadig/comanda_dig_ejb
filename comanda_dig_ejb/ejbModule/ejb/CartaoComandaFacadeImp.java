package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.CartaoComanda;
import dao.CartaoComandaDAO;



/**
 * Session Bean implementation class UserFacadeImp
 */
@Stateless
public class CartaoComandaFacadeImp implements CartaoComandaFacade {
	
	@EJB
	CartaoComandaDAO cartaoDao;
	@Override
	public void save(CartaoComanda Cartao) {
		cartaoDao.save(Cartao);
	}

	@Override
	public CartaoComanda update(CartaoComanda Cartao) {
		return cartaoDao.update(Cartao);
	}

	@Override
	public void delete(CartaoComanda Cartao) {
		cartaoDao.delete(Cartao);
	}

	@Override
	public CartaoComanda find(Long entityID) {
		return cartaoDao.find(entityID);
	}

	@Override
	public List<CartaoComanda> findAll() {
		return cartaoDao.findAll();
	}

   
	

	
	
}
