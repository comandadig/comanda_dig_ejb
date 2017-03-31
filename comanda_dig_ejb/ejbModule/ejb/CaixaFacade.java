package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Caixa;
import model.Comanda;
import util.SituacaoCaixa;
import util.SituacaoComanda;



@Local
public interface CaixaFacade {

	public abstract void save(Caixa Caixa);

	public abstract Caixa update(Caixa Caixa);
	
	public abstract void delete(Caixa User);

	public abstract Caixa find(Long entityID);
	
	public abstract List<Caixa> findAll();
	
	public abstract Caixa abrirCaixa(Caixa caixa);
	
	public abstract List<Caixa> findCaixaBySituacao(SituacaoCaixa situacaoCaixa);
	
	public abstract List<Comanda> findComandasByCaixa(Caixa caixa, SituacaoComanda situacaoComanda);
	
	public Caixa buscarCaixaDisponivel();

}
