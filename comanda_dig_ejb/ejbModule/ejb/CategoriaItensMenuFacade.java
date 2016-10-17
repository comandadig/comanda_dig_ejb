package ejb;

import java.util.List;

import javax.ejb.Local;

import model.CategoriaMaster;
import model.CategoriaMenu;
import model.Produto;



@Local
public interface CategoriaItensMenuFacade {

	public abstract void saveCategoria(CategoriaMenu categoriaMenu);

	public abstract CategoriaMenu updateCategoria(CategoriaMenu categoriaMenu);
	
	public abstract void deleteCategoria(CategoriaMenu categoriaMenu);

	public abstract CategoriaMenu findCategoria(Long id);
	
	public abstract List<CategoriaMenu> findAllCategoria();
	
	public abstract void saveItem(Produto produto);

	public abstract Produto updateItem(Produto produto);
	
	public abstract void deleteItem(Produto produto);

	public abstract Produto findItem(Long id);
	
	public abstract List<Produto> findAllItem();
	
	public abstract void saveCategoriaMaster(CategoriaMaster categoriaMaster);

	public abstract CategoriaMaster updateCategoriaMaster(CategoriaMaster categoriaMaster);
	
	public abstract void deleteCategoriaMaster(CategoriaMaster categoriaMaster);

	public abstract CategoriaMaster findCategoriaMaster(Long id);
	
	public abstract List<CategoriaMaster> findAllCategoriaMaster();
	
	
	
}
