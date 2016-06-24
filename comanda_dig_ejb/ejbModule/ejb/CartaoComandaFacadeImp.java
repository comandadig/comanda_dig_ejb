package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.CartaoComanda;
import model.Endereco;
import model.SalarioUser;
import model.User;
import dao.CartaoComandaDAO;
import dao.EnderecoDAO;
import dao.SalarioUserDAO;
import dao.UserDAO;



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
