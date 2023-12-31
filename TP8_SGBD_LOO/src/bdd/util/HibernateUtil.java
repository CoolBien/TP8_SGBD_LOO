package bdd.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import bdd.data.Bourse;
import bdd.data.Enseignant;
import bdd.data.Enseignement;
import bdd.data.Etudiant;
import bdd.data.Evaluation;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			final Configuration conf = new Configuration().configure();
			conf.addAnnotatedClass(Etudiant.class);
			conf.addAnnotatedClass(Bourse.class);
			conf.addAnnotatedClass(Enseignement.class);
			conf.addAnnotatedClass(Enseignant.class);
			conf.addAnnotatedClass(Evaluation.class);
			conf.configure();
			final ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			sessionFactory = conf.buildSessionFactory(sr);
		} catch (final Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
