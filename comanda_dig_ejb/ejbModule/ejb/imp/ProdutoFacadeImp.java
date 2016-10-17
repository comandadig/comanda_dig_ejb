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
import model.CategoriaMaster;
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
