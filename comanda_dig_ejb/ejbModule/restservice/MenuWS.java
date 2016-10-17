package restservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.ProdutoFacade;
import model.Categoria;

@Path("/rest/menu")
@Stateless(name = "MenuWS")
@LocalBean
public class MenuWS {

	@EJB
	private ProdutoFacade facade;


	@GET
	@Path("/allCategorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> getAllCategorias() {
		List<Categoria> cat =  facade.findAllCategoria();
		
		return cat;
	}


	public ProdutoFacade getFacade() {
		return facade;
	}


	public void setFacade(ProdutoFacade facade) {
		this.facade = facade;
	}
	
	
	

}
