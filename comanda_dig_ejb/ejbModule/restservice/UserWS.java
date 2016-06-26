package restservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.User;
import ejb.UserFacade;

@Path("/rest/user")
@Stateless(name = "UserWS")
@LocalBean
public class UserWS {

	@EJB
	private UserFacade userFacade;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("id") long id) {
		System.out.println("entrou..." + id);
		return userFacade.find(id);
	}

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		return userFacade.findAll();
	}
	
	
	@GET
	@Path("/autentica")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean autentica(@QueryParam("login") String login, @QueryParam("senha") String senha) {
		 return userFacade.autenticarUser(login, senha);
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	

}
