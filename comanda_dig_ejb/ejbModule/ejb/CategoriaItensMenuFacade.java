package ejb;

import java.util.List;

import javax.ejb.Local;

import model.CategoriaMaster;
import model.CategoriaMenu;
import model.ItemMenu;



@Local
public interface CategoriaItensMenuFacade {

	public abstract void saveCategoria(CategoriaMenu categoriaMenu);

	public abstract CategoriaMenu updateCategoria(CategoriaMenu categoriaMenu);
	
	public abstract void deleteCategoria(CategoriaMenu categoriaMenu);

	public abstract CategoriaMenu findCategoria(Long id);
	
	public abstract List<CategoriaMenu> findAllCategoria();
	
	public abstract void saveItem(ItemMenu itemMenu);

	public abstract ItemMenu updateItem(ItemMenu itemMenu);
	
	public abstract void deleteItem(ItemMenu itemMenu);

	public abstract ItemMenu findItem(Long id);
	
	public abstract List<ItemMenu> findAllItem();
	
	public abstract void saveCategoriaMaster(CategoriaMaster categoriaMaster);

	public abstract CategoriaMaster updateCategoriaMaster(CategoriaMaster categoriaMaster);
	
	public abstract void deleteCategoriaMaster(CategoriaMaster categoriaMaster);

	public abstract CategoriaMaster findCategoriaMaster(Long id);
	
	public abstract List<CategoriaMaster> findAllCategoriaMaster();
	
	
	
}
