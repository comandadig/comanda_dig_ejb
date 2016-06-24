package restservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestApplication extends Application {

    private Set<Class<?>> resources = new HashSet<Class<?>>();

    public RestApplication () {
        resources.add(UserWS.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return resources;
    }


	
	
}
