package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Menu;
import model.Categoria;
import model.Produto;



@Local
public interface ProdutoFacade {

	public abstract void saveCategoria(Categoria categoria);

	public abstract Categoria updateCategoria(Categoria categoria);
	
	public abstract void deleteCategoria(Categoria categoria);

	public abstract Categoria findCategoria(Long id);
	
	public abstract List<Categoria> findAllCategoria();
	
	//----------------------
	
	public abstract void saveProduto(Produto produto);

	public abstract Produto updateProduto(Produto produto);
	
	public abstract void deleteProduto(Produto produto);

	public abstract Produto findProduto(Long id);
	
	public abstract List<Produto> findAllProduto();
	
	
	//-----------------
	
	public abstract void saveMenu (Menu menu);

	public abstract Menu updateMenu(Menu menu);
	
	public abstract void deleteMenu(Menu menu);

	public abstract Menu findMenu(Long id);
	
	public abstract List<Menu> findAllMenu();
	
	
	
}
