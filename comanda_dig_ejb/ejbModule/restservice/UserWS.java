package restservice;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.User;
import dao.UserDAO;

@Path("/rest/user")
@Stateless(name = "UserWS")
@LocalBean
public class UserWS {
	
	
	@EJB
	private UserDAO dao ;

	
	 @GET
	 @Path("/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public User getUser(@PathParam("id") long id) {
		 	System.out.println("entrou..." + id);
	        return dao.find(id);
	 }


	public UserDAO getDao() {
		return dao;
	}


	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	

}
