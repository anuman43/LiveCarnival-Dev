package com.netreality.vertie.reveng;

// Generated Sep 7, 2014 6:03:50 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Carnivaltermsindextbl.
 * @see com.netreality.vertie.reveng.Carnivaltermsindextbl
 * @author Hibernate Tools
 */
public class CarnivaltermsindextblHome {

	private static final Log log = LogFactory
			.getLog(CarnivaltermsindextblHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Carnivaltermsindextbl transientInstance) {
		log.debug("persisting Carnivaltermsindextbl instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Carnivaltermsindextbl instance) {
		log.debug("attaching dirty Carnivaltermsindextbl instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Carnivaltermsindextbl instance) {
		log.debug("attaching clean Carnivaltermsindextbl instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Carnivaltermsindextbl persistentInstance) {
		log.debug("deleting Carnivaltermsindextbl instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Carnivaltermsindextbl merge(Carnivaltermsindextbl detachedInstance) {
		log.debug("merging Carnivaltermsindextbl instance");
		try {
			Carnivaltermsindextbl result = (Carnivaltermsindextbl) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Carnivaltermsindextbl findById(java.lang.Integer id) {
		log.debug("getting Carnivaltermsindextbl instance with id: " + id);
		try {
			Carnivaltermsindextbl instance = (Carnivaltermsindextbl) sessionFactory
					.getCurrentSession()
					.get("com.netreality.vertie.reveng.Carnivaltermsindextbl",
							id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Carnivaltermsindextbl> findByExample(
			Carnivaltermsindextbl instance) {
		log.debug("finding Carnivaltermsindextbl instance by example");
		try {
			List<Carnivaltermsindextbl> results = (List<Carnivaltermsindextbl>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.netreality.vertie.reveng.Carnivaltermsindextbl")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
