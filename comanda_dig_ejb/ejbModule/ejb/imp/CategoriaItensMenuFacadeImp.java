package ejb.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import model.CategoriaMaster;
import model.CategoriaMenu;
import model.Produto;
import dao.CategoriaMasterDAO;
import dao.CategoriaMenuDAO;
import dao.ItemMenuDAO;
import ejb.CategoriaItensMenuFacade;



/**
 * Session Bean implementation class CategoriaItensMenuFacadeImp
 */
@Stateless
  public class CategoriaItensMenuFacadeImp implements CategoriaItensMenuFacade {

    @EJB
    private CategoriaMenuDAO categoriaMenuDAO;
    @EJB
    private ItemMenuDAO itemMenuDAO;
    @EJB
    private CategoriaMasterDAO categoriaMasterDAO;
   
	@Override
	public void saveCategoria(CategoriaMenu categoriaMenu) {
		categoriaMenuDAO.save(categoriaMenu);		
		
	}

	@Override
	public CategoriaMenu updateCategoria(CategoriaMenu categoriaMenu) {		
		return categoriaMenuDAO.update(categoriaMenu);
	}

	@Override
	public void deleteCategoria(CategoriaMenu categoriaMenu) {
		categoriaMenuDAO.delete(categoriaMenu);
	}

	@Override
	public CategoriaMenu findCategoria(Long entityID) {
		
		return categoriaMenuDAO.find(entityID);
	}

	@Override
	public List<CategoriaMenu> findAllCategoria() {
		return categoriaMenuDAO.findAll();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveItem(Produto itemMenu) {
		CategoriaMenu categoriaMenu = categoriaMenuDAO.find(itemMenu.getCategoriaMenu().getIdCategoriaMenu());
		itemMenu.setCategoriaMenu(categoriaMenu);
		this.itemMenuDAO.save(itemMenu);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Produto updateItem(Produto itemMenu) {
		itemMenuDAO.update(itemMenu);
		if (itemMenu.getCategoriaMenu() != null){
			CategoriaMenu categoriaMenu = categoriaMenuDAO.find(itemMenu.getCategoriaMenu().getIdCategoriaMenu());
			categoriaMenuDAO.update(categoriaMenu);
		}
		return itemMenu;
	}

	@Override
	public void deleteItem(Produto itemMenu) {
		this.itemMenuDAO.delete(itemMenu);
	}

	@Override
	public Produto findItem(Long id) {
		return this.itemMenuDAO.find(id);
	}

	@Override
	public List<Produto> findAllItem() {
		return this.itemMenuDAO.findAll();
	}

	@Override
	public void saveCategoriaMaster(CategoriaMaster categoriaMaster) {
		categoriaMasterDAO.save(categoriaMaster);
	}

	@Override
	public CategoriaMaster updateCategoriaMaster(CategoriaMaster categoriaMaster) {
		CategoriaMaster master = this.categoriaMasterDAO.find(categoriaMaster.getIdCategoriaMaster());
		master.setDescricao(categoriaMaster.getDescricao());
		master.setDirfoto(categoriaMaster.getDirfoto());
		master.setFoto(categoriaMaster.getFoto());
		master.setNome(categoriaMaster.getNome());
		master.setCategoriaMenus(categoriaMaster.getCategoriaMenus());
		return categoriaMasterDAO.update(master);
	}

	@Override
	public void deleteCategoriaMaster(CategoriaMaster categoriaMaster) {
		categoriaMasterDAO.delete(categoriaMaster);
	}

	@Override
	public CategoriaMaster findCategoriaMaster(Long id) {
		return categoriaMasterDAO.find(id);
	}

	@Override
	public List<CategoriaMaster> findAllCategoriaMaster() {
		return categoriaMasterDAO.findAll();
	}

	
}
