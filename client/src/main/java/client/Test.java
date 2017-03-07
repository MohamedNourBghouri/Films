package client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.Emdb;
import services.EmdbRemote;

public class Test {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			String jndiName = "film2-ear/film2-ejb/Emdb!services.EmdbRemote";
			EmdbRemote proxy = (EmdbRemote) context.lookup(jndiName);

			System.out.println(proxy.SearchFilm("Fight club"));
			proxy.AddWish("Forrest Gump", "user2@gmail.com");
			proxy.AddWish("Fight club", "user2@gmail.com");
			String[] whish=proxy.SearchWhish("user2@gmail.com");
			System.out.println("The whishList of the user:user2@gmail.com is :");
			for (String item : whish) {
				System.out.println(item);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
