package restservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.UserFacade;
import model.User;

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
		System.out.println("entrou....");
		return userFacade.findAll();
	}
	
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public User login(User user) {
		return userFacade.login(user);
	}
	
	
	@POST
	@Path("/cadastra")
	@Produces(MediaType.APPLICATION_JSON)
	public void cadastra(User user) {
		System.out.println("foiii...");
		this.userFacade.save(user);
	}
	
	
	
	
	@POST
	@Path("/autentica")
	@Produces(MediaType.APPLICATION_JSON)
	public User autentica( AuthenticateUserRequest request) {
		System.out.println("entrou..."); 
		User user = new User();
		user.setLogin("cu de cadela..");
		return user;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	

}
