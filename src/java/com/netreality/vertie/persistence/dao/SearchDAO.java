/**
 * @date Jan 4, 2015
 */
package com.netreality.vertie.persistence.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netreality.vertie.exception.InfrastructureException;
import com.netreality.vertie.persistence.util.HibernatePersistenceUtil;
import com.netreality.vertie.reveng.Tblrecentsearches;

/**
 * @author ldurh516
 *
 * @date Jan 4, 2015
 *	
 */
public class SearchDAO {

	private static Logger _log = Logger.getLogger(SearchDAO.class);
	
	
	
	
	
	
	public List<Tblrecentsearches> getRecentSearches()
	{
		List<Tblrecentsearches> recentSearches = null;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		String orderByProperty = "createdDate";
		
		
		try{
			
			
			tx.begin();
			recentSearches = (List<Tblrecentsearches>) _localSession.createCriteria(com.netreality.vertie.reveng.Tblrecentsearches.class).addOrder(Order.asc(orderByProperty)).list();
			_log.debug("Search of recent searches returned " + recentSearches.size() + " results");
			tx.commit();
		}catch(HibernateException hbe)
		{
			_log.error("Recent search query failed", hbe);
			if(tx != null)tx.rollback();
			
		}
		finally{
			if(_localSession.isOpen())
			{
				
			try {
				HibernatePersistenceUtil.closeSession();
			} catch (InfrastructureException ife) {
				_log.error(ife);
			}
				
			}
		}
		
		return recentSearches;
		
	}
	
	
	public void addSearch(Tblrecentsearches searchInfo)
	{
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();

		
		try{
			 tx = _localSession.beginTransaction();
			 _localSession.persist(searchInfo);
			tx.commit();
			
			
		}catch(Exception pse)
		{
			_log.error(pse);
			if(tx != null)tx.rollback();
		}
		finally
		{
			if(_localSession.isOpen())
			{
				
			try {
				HibernatePersistenceUtil.closeSession();
			} catch (InfrastructureException ife) {
				_log.error(ife);
			}
				
			}
		}
		
	}
	
	
	public List<Tblrecentsearches> findSearch(String searchPhrase)
	{
		List<Tblrecentsearches> savedSearches = null;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
			Criteria ct = null;
			Criterion crit = null;
			Criterion orCrit = null;
			
			String searchByProperty = "searchWords";
			String orderByProperty = "createdDate";
			
			try{
				
				tx = _localSession.getTransaction();
				tx.begin();
				crit = Restrictions.and(Restrictions.eq(searchByProperty, searchPhrase));
				ct = _localSession.createCriteria(Tblrecentsearches.class);
				orCrit = Restrictions.ilike(searchByProperty, searchPhrase,MatchMode.ANYWHERE);
				ct.add(Restrictions.or(crit, orCrit));
				ct.addOrder(Order.asc(orderByProperty));
				savedSearches = ct.list();
				_log.debug("Search query returned " + savedSearches.size() + " search results");
				tx.commit();
				
			}catch(HibernateException hbe)
			{
				if(tx != null) tx.rollback();
				_log.error("Transaction failed", hbe);
			}
			finally
			{
				if(_localSession.isOpen())
				{
					
				try {
					HibernatePersistenceUtil.closeSession();
				} catch (InfrastructureException ife) {
					_log.error(ife);
				}
					
				}
			}
		
		return savedSearches;
		
	}
	
}
