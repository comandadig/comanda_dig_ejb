package ejb;

import java.util.List;

import javax.ejb.Local;

import model.CategoriaMaster;
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
	
	public abstract void saveCategoriaMaster(CategoriaMaster categoriaMaster);

	public abstract CategoriaMaster updateCategoriaMaster(CategoriaMaster categoriaMaster);
	
	public abstract void deleteCategoriaMaster(CategoriaMaster categoriaMaster);

	public abstract CategoriaMaster findCategoriaMaster(Long id);
	
	public abstract List<CategoriaMaster> findAllCategoriaMaster();
	
	
	
}
