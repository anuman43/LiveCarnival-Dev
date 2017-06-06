package com.netreality.vertie.persistence.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.netreality.vertie.exception.InfrastructureException;

public class HibernatePersistenceUtil {
	
	private static Logger _log = null;
	private static Configuration hibConfig = null;
	private static SessionFactory sessionFactory;
	private static final ThreadLocal threadSession = new ThreadLocal();
	private static final ThreadLocal threadInterceptor = new ThreadLocal();
	private static StandardServiceRegistryBuilder srb;
	private static StandardServiceRegistry svcReg;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernatePersistenceUtil.sessionFactory = sessionFactory;
	}


	static
	{
		_log = Logger.getLogger(HibernatePersistenceUtil.class);
		hibConfig = new Configuration().configure();
		 srb = null;
		srb = new StandardServiceRegistryBuilder();
		 srb.applySettings(hibConfig.getProperties());
		 
		 try
		 {
			 svcReg = srb.build();
			 sessionFactory = hibConfig.buildSessionFactory(svcReg);
		 }catch(HibernateException he)
		 {
			 _log.error(he);
		 }
		 
		 
		 if(sessionFactory != null)
		 {
			 _log.debug("Hibernate Session Factory Initialized");
		 }
		 else
		 {
			 _log.debug("Hibernate Session Factory Not Initialized");
		 }
	}
	
	public static Session getSession()
			throws HibernateException {
			Session s = (Session) threadSession.get();
			try {
				if (s == null) {
					_log.debug("Opening new Session for this thread.");
					
						s = getSessionFactory().openSession();
					
					threadSession.set(s);
				}
				else {
					s = getSessionFactory().getCurrentSession();
					_log.debug("Returnning exisiting session from thread");
				}
			} catch (HibernateException ex) {
				
			}
			return s;
		}
	
	
	public static void closeSession()
			throws InfrastructureException {
			try {
				Session s = (Session) threadSession.get();
				threadSession.set(null);
				if (s != null && s.isOpen()) {
					_log.debug("Closing Session of this thread.");
					s.close();
				}
			} catch (HibernateException ex) {
				throw new InfrastructureException(ex);
			}
		}
	
	
	private static Interceptor getInterceptor() {
		Interceptor interceptor =
			(Interceptor) threadInterceptor.get();
		return interceptor;
	}

public static void shutdown() {
		
		//close existing sessions, caches and connection pools
		try {
			closeSession();
			if(srb != null);
			{
				StandardServiceRegistryBuilder.destroy(svcReg);
			}
		} catch (InfrastructureException ife) {
			_log.error(ife);
		}
		
	}


}
