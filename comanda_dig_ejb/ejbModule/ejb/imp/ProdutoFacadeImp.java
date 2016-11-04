package ejb.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import dao.CategoriaDAO;
import dao.MenuDAO;
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
    private MenuDAO menuDAO;
   
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
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveMenu(Menu menu) {
		menuDAO.save(menu);
		
		if (menu.getCategorias() != null){
			
			for (Categoria categoria : menu.getCategorias()) {
				categoria.setCategoriaMaster(menu);
				this.categoriaDAO.update(categoria);
			}
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Menu updateMenu(Menu menu) {
		Menu master = this.menuDAO.find(menu.getIdMenu());
		master.setDescricao(menu.getDescricao());
		master.setDirfoto(menu.getDirfoto());
		master.setFoto(menu.getFoto());
		master.setNome(menu.getNome());
		master.setCategorias(menu.getCategorias());
		
		
		if (master.getCategorias() != null){
			
			for (Categoria categoria : menu.getCategorias()) {
				categoria.setCategoriaMaster(menu);
				this.categoriaDAO.update(categoria);
			}
		}
		
		return menuDAO.update(master);
	}

	@Override
	public void deleteMenu(Menu menu) {
		menuDAO.delete(menu);
	}

	@Override
	public Menu findMenu(Long id) {
		return menuDAO.find(id);
	}

	@Override
	public List<Menu> findAllMenu() {
		return menuDAO.findAll();
	}

	
}
