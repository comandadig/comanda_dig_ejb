package restservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.CategoriaItensMenuFacade;
import model.CategoriaMenu;

@Path("/rest/menu")
@Stateless(name = "MenuWS")
@LocalBean
public class MenuWS {

	@EJB
	private CategoriaItensMenuFacade facade;


	@GET
	@Path("/allCategorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaMenu> getAllCategorias() {
		List<CategoriaMenu> cat =  facade.findAllCategoria();
		
		return cat;
	}


	public CategoriaItensMenuFacade getFacade() {
		return facade;
	}


	public void setFacade(CategoriaItensMenuFacade facade) {
		this.facade = facade;
	}
	
	
	

}
