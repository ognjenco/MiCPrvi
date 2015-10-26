import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("radi");
		Configuration conf=new Configuration();
		conf.addAnnotatedClass(Klasa.class);
		conf.setProperty("hibernate.connection.url", "jdbc:h2:"+Test.class.getResource(".").getPath()+"nova");
		conf.configure();
		SessionFactory sf=conf.buildSessionFactory();
		Calendar cal=Calendar.getInstance();
		cal.set(1990, 8, 1);
		Date datum=cal.getTime();
		Klasa test=new Klasa("Neki tip", datum);
		Session ses=sf.openSession();
		ses.getTransaction().begin();
		ses.save(test);
		Klasa test2=(Klasa) ses.createSQLQuery("select * from KLASE").addEntity(Klasa.class).list().get(0);
		System.out.println(test2);
		ses.getTransaction().commit();
		ses.close();
		sf.close();
		
	}

}
