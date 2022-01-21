package test;

import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.PositionRemote;
import dao.SmartphoneRemote;
import dao.UserRemote;
import entities.Position;
import entities.Smartphone;
import entities.User;

public class Test {

	public static UserRemote UserLookup() throws NamingException {
		Hashtable<Object, Object> conf = new Hashtable<Object, Object>();
		conf.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		conf.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(conf);
		return (UserRemote) context.lookup("ejb:/GpsServer/UserService!dao.UserRemote");
	}

	public static SmartphoneRemote SmartphoneLookup() throws NamingException {
		Hashtable<Object, Object> conf = new Hashtable<Object, Object>();
		conf.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		conf.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(conf);
		return (SmartphoneRemote) context.lookup("ejb:/GpsServer/SmartphoneService!dao.SmartphoneRemote");
	}

	public static PositionRemote PositionLookup() throws NamingException {
		Hashtable<Object, Object> conf = new Hashtable<Object, Object>();
		conf.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		conf.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(conf);
		return (PositionRemote) context.lookup("ejb:/GpsServer/PositionService!dao.PositionRemote");
	}
	
	public static void main(String[] args) {
		try {
			PositionRemote pr = PositionLookup();
			SmartphoneRemote sr = SmartphoneLookup();
			UserRemote ur = UserLookup();
//			User u = new User("nom","prenom","email",new Date(),"00000");
//			ur.create(u);
//			Smartphone s = new Smartphone(123,"une marque",ur.findById(2));
//			sr.create(s);
			pr.create(new Position("long","lati",new Date(),sr.findById(9)));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
