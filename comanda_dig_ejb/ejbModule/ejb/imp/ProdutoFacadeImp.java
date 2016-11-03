package ejb.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.CategoriaDAO;
import dao.CategoriaMasterDAO;
import dao.ProdutoDAO;
import ejb.ProdutoFacade;
import model.Categoria;
import model.Menu;
import model.Produto;



/**
 * Session Bean implementation class ProdutoFacadeImp
 */
@Stateless
  public class ProdutoFacadeImp implements ProdutoFacade {

    @EJB
    private CategoriaDAO categoriaDAO;
    @EJB
    private ProdutoDAO produtoDAO;
    @EJB
    private CategoriaMasterDAO categoriaMasterDAO;
   
	@Override
	public void saveCategoria(Categoria categoriaMenu) {
		categoriaDAO.save(categoriaMenu);		
		
	}

	@Override
	public Categoria updateCategoria(Categoria categoriaMenu) {		
		return categoriaDAO.update(categoriaMenu);
	}

	@Override
	public void deleteCategoria(Categoria categoriaMenu) {
		categoriaDAO.delete(categoriaMenu);
	}

	@Override
	public Categoria findCategoria(Long entityID) {
		
		return categoriaDAO.find(entityID);
	}

	@Override
	public List<Categoria> findAllCategoria() {
		return categoriaDAO.findAll();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveProduto(Produto produto) {
		Categoria categoriaMenu = categoriaDAO.find(produto.getCategoria().getIdCategoria());
		produto.setCategoria(categoriaMenu);
		this.produtoDAO.save(produto);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Produto updateProduto(Produto produto) {
		produtoDAO.update(produto);
		if (produto.getCategoria() != null){
			Categoria categoriaMenu = categoriaDAO.find(produto.getCategoria().getIdCategoria());
			categoriaDAO.update(categoriaMenu);
		}
		return produto;
	}

	@Override
	public void deleteProduto(Produto produto) {
		this.produtoDAO.delete(produto);
	}

	@Override
	public Produto findProduto(Long id) {
		return this.produtoDAO.find(id);
	}

	@Override
	public List<Produto> findAllProduto() {
		return this.produtoDAO.findAll();
	}

	@Override
	public void saveCategoriaMaster(Menu menu) {
		categoriaMasterDAO.save(menu);
	}

	@Override
	public Menu updateCategoriaMaster(Menu menu) {
		Menu master = this.categoriaMasterDAO.find(menu.getIdMenu());
		master.setDescricao(menu.getDescricao());
		master.setDirfoto(menu.getDirfoto());
		master.setFoto(menu.getFoto());
		master.setNome(menu.getNome());
		master.setCategoriaMenus(menu.getCategoriaMenus());
		return categoriaMasterDAO.update(master);
	}

	@Override
	public void deleteCategoriaMaster(Menu menu) {
		categoriaMasterDAO.delete(menu);
	}

	@Override
	public Menu findCategoriaMaster(Long id) {
		return categoriaMasterDAO.find(id);
	}

	@Override
	public List<Menu> findAllCategoriaMaster() {
		return categoriaMasterDAO.findAll();
	}

	
}
