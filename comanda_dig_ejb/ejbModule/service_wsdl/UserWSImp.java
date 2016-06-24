package service_wsdl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import model.User;
import ejb.UserFacade;

@Stateless
@WebService(portName= "UserPort",
			serviceName ="UserService",
			endpointInterface = "service.UserWS", 
			targetNamespace= "http://comandaDig/wsdl" 
			)
public class UserWSImp implements UserWS {

	@EJB
	private UserFacade usuarioFacade;

	@Override
	public void save(User user) {
		this.usuarioFacade.save(user);
	}

	@Override
	public User update(User user) {
		return this.usuarioFacade.update(user);
	}

	@Override
	public void delete(User user) {
		this.usuarioFacade.delete(user);
		
	}

	@Override
	public User find(Long entityID) {
		return usuarioFacade.find(entityID);
	}

	@Override
	public List<User> findAll() {
		return this.usuarioFacade.findAll();
	}

	@Override
	public Boolean autenticarUser(String email, String senha) {
		// TODO Auto-generated method stub
		return this.autenticarUser(email, senha);
	}
	
	

	
	
	
}
