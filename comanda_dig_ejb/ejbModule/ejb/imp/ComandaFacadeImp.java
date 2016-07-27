package ejb.imp;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ComandaDAO;
import ejb.ComandaFacade;
import model.Comanda;
import util.SituacaoComanda;



/**
 * Session Bean implementation class UserFacadeImp
 */
@Stateless
public class ComandaFacadeImp implements ComandaFacade {

	@EJB
	private ComandaDAO comandaDAO;
	
	@Override
	public void save(Comanda entity) {
		comandaDAO.save(entity);
		
	}

	@Override
	public Comanda update(Comanda entity) {
		return comandaDAO.update(entity);
	}

	@Override
	public void delete(Comanda entity) {
		comandaDAO.delete(entity);
		
	}

	@Override
	public Comanda find(Long entityID) {
		return comandaDAO.find(entityID);
	}

	@Override
	public List<Comanda> findAll() {
		return comandaDAO.findAll();
	}

	@Override
	public Comanda buscarComanda(String codComanda) {
		return comandaDAO.buscarComanda(codComanda);
	}

	@Override
	public Comanda abrirComanda(Comanda comanda) {
		Comanda comandaPersist = comandaDAO.find(comanda.getIdComanda());
		comandaPersist.setDocumento(comanda.getDocumento());
		comandaPersist.setNome(comanda.getNome());
		comandaPersist.setSexo(comanda.getSexo());
		comandaPersist.setTelefone(comanda.getTelefone());
		comandaPersist.setSituacao(SituacaoComanda.ABERTO.getValue());
		return comandaDAO.update(comandaPersist);
	}

	
	
	
}
