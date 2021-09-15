package Web.Init;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Init {
    public Init(){
        InitFactory();
    }

    private static SessionFactory factory;

    private static SessionFactory InitFactory(){
        if(factory == null){
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return factory;
    }

    public static Session getSession(){
        return factory.openSession();
    }
}
