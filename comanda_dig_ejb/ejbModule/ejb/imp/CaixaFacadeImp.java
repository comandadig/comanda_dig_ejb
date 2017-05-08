package ejb.imp;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.CaixaDAO;
import dao.CartaoComandaDAO;
import dao.ComandaDAO;
import dao.FilaBarDAO;
import dao.FilaCozinhaDAO;
import ejb.CaixaFacade;
import model.Caixa;
import model.Comanda;
import model.FilaBar;
import model.FilaCozinha;
import util.SituacaoCaixa;
import util.SituacaoComanda;
import util.SituacaoFilas;



/**
 * Session Bean implementation class UserFacadeImp
 */
@Stateless
public class CaixaFacadeImp implements CaixaFacade {

    @EJB
    private CaixaDAO caixaDAO;
    @EJB
    private CartaoComandaDAO cartaoComandaDAO;
    @EJB
    private ComandaDAO comandaDAO;
    @EJB 
    private FilaBarDAO filaBarDAO;
    @EJB
    private FilaCozinhaDAO filaCozinhaDAO;
    
    public CaixaFacadeImp() {
    	
    }


	@Override
	public void save(Caixa entity) {
		caixaDAO.save(entity);
	}



	@Override
	public Caixa update(Caixa entity) {
		return caixaDAO.update(entity);
	}



	@Override
	public void delete(Caixa entity) {
		caixaDAO.delete(entity);
		
	}



	@Override
	public Caixa find(Long entityID) {
		return caixaDAO.find(entityID);
	}



	@Override
	public List<Caixa> findAll() {
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Caixa abrirCaixa(Caixa caixaDummy){
		
		Caixa caixa = new Caixa();
		caixa.setCadastroCliente(caixaDummy.getCadastroCliente());
		caixa.setEntrada(caixaDummy.getEntrada());
		caixa.setValorEntrada(caixaDummy.getValorEntrada());
		caixa.setConver(caixaDummy.getConver());
		caixa.setValorConver(caixaDummy.getValorConver());
		caixa.setEntradaMasFem(caixaDummy.getEntradaMasFem());
		caixa.setValorEntradaFem(caixaDummy.getValorEntradaFem());
		caixa.setValorEntradaMas(caixaDummy.getValorEntradaMas());
		caixa.setDtAbertura(new Date());
		caixa.setSituacao(SituacaoCaixa.ABERTO.getValue());
		caixaDAO.save(caixa);
		
		
		FilaBar filaBar = new FilaBar();
		filaBar.setSituacao(SituacaoFilas.ABERTO.getValue());
		filaBar.setCaixa(caixa);
		filaBarDAO.save(filaBar);
		
		FilaCozinha filaCozinha = new FilaCozinha();
		filaCozinha.setSituacao(SituacaoFilas.ABERTO.getValue());
		filaCozinha.setCaixa(caixa);
		filaCozinhaDAO.save(filaCozinha);
		caixa.setComandas(this.findComandasByCaixa(caixa, SituacaoComanda.ABERTA));
		
		return caixa;
	}
	
	
	public List<Comanda> findComandasByCaixa(Caixa caixa, SituacaoComanda situacaoComanda){
		List<String> inList = new ArrayList<String>();
		inList.add(situacaoComanda.getValue());
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("inList", inList);
		parameters.put("idCaixa", caixa.getIdCaixa());
		List<Comanda> list = comandaDAO.executeNamedQuery("Caixa.FindComandasBySituacao", parameters);
		
		return list;
		
	}
	
	public List<Caixa> findCaixaBySituacao(SituacaoCaixa situacaoCaixa){
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("situacao", situacaoCaixa.getValue());
		List<Caixa> list = caixaDAO.executeNamedQuery("Caixa.FindCaixaBySituacao", parameters);
		return list;
		
	}
	
	
	public Caixa buscarCaixaDisponivel(){
		List<Caixa> list = caixaDAO.executeNamedQuery(Caixa.CAIXA_DISPONIVEL, null);
		 return list != null && !list.isEmpty() ? list.get(0) : null; 
	}
	
	
}
