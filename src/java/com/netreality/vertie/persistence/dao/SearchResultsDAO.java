/**
 * @date Sep 9, 2014
 */
package com.netreality.vertie.persistence.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.netreality.live4carnival.enums.NaturalLangSearchEnums;
import com.netreality.vertie.alpha.to.SearchTO;
import com.netreality.vertie.exception.InfrastructureException;
import com.netreality.vertie.persistence.util.HibernatePersistenceUtil;
import com.netreality.vertie.reveng.Carnivaltermsindextbl;
import com.netreality.vertie.reveng.Tblrecentsearches;
import com.netreality.vertie.search.util.SearchUtil;

/**
 * @author ldurh516
 *
 * @date Sep 9, 2014
 *	
 */
public class SearchResultsDAO {

	private static Logger _log = Logger.getLogger(SearchResultsDAO.class);
	private static String NATURAL_LANGUAGE_SEARCH_QUERY = "select * from carnivaltermsindextbl where Match(domainTerm) Against (? IN NATURAL LANGUAGE MODE) order by termRank desc";
	private static String NATURAL_LANGUAGE_BOOLEAN_SEARCH_QUERY = "select * from carnivaltermsindextbl where Match(domainTerm) Against (? IN BOOLEAN MODE) order by termRank desc";
	private static String NATURAL_LANGUAGE_SEARCH_QUERY_COUNT = "select COUNT(domainTerm) from test.carnivaltermsindextbl where Match(domainTerm) Against (? IN NATURAL LANGUAGE MODE) order by termRank desc";
	private static String NATURAL_LANGUAGE_BOOLEAN_SEARCH_QUERY_COUNT = "select COUNT(domainTerm) from test.carnivaltermsindextbl where Match(domainTerm) Against (? IN BOOLEAN MODE) order by termRank desc";
	private static Integer MAX_NATURAL_LANGUAGE_SEARCH_RESULT_SIZE = 100;
	
	
	public SearchTO processSearch(String searchPhrase)
	{
		SearchTO sTo = null;
		sTo = new SearchTO();
		if(searchPhrase != null)
		{

			sTo.setSearchPhrase(searchPhrase);
			BigInteger resultCount = BigInteger.valueOf(0L);
			//resultCount = getSearchResultSize(searchPhrase);
			resultCount = getSearchRelevanceNtl(searchPhrase,NaturalLangSearchEnums.IN_NATURAL_LANAGUAGE_MODE);
			sTo.setResultSetSize(resultCount.intValue());
			sTo.setResultPages(StrictMath.abs(sTo.getResultSetSize() / sTo.getPagingSize()));
			_log.debug("There are " + sTo.getResultPages() + " result pages");

		}

		return sTo;
	}
	
	
	


	public List<Carnivaltermsindextbl> getResultsByKeyword(String term)
	{
		 List<Carnivaltermsindextbl> results = null;
		 Session _localSession = HibernatePersistenceUtil.getSession();
		 Transaction tx = _localSession.getTransaction();

			Criteria ct = null;
			Criterion crit = null;
			Criterion orCrit = null;
			String searchPropertyName = "domainTerm";
			String orderByProp = "termRank";
			
			try{
				
				tx = _localSession.getTransaction();
				tx.begin();
				crit = Restrictions.and(Restrictions.eq(searchPropertyName, term));
				ct = _localSession.createCriteria(Carnivaltermsindextbl.class);
				//ct.add(Restrictions.eq(searchPropertyName, term));
				//ct.add(Restrictions.or(Restrictions.ilike(searchPropertyName, term)));
				orCrit = Restrictions.ilike(searchPropertyName, term,MatchMode.ANYWHERE);
				ct.add(Restrictions.or(crit, orCrit));
				//ct.add(crit);
				ct.addOrder(Order.asc(orderByProp));
				results = ct.list();
				_log.debug("Search query returned " + results.size() + " search results");
				tx.commit();
			}catch(HibernateException hbe)
			{
				_log.error(hbe);
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
		
		return results;
	}
	
	
	public List<Carnivaltermsindextbl> searchUsingExample(String wordPhrases)
	{
		List<Carnivaltermsindextbl> resultList = null;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		Carnivaltermsindextbl carnivalTerm = null;
		carnivalTerm = new Carnivaltermsindextbl();
		carnivalTerm.setDomainTerm(wordPhrases);
		
		try
		{
			tx.begin();
			resultList = _localSession.createCriteria(Carnivaltermsindextbl.class).add(Example.create(carnivalTerm)).list();
			tx.commit();
			_log.info("Search result size is-" + resultList.size());
		}
		catch(HibernateException hbe)
		{
			_log.error(hbe);
			if(tx != null) tx.rollback();
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
			
			return resultList;
		
	}
	
	public List<Carnivaltermsindextbl> getAllResults()
	{
		List<Carnivaltermsindextbl> allResultsList = null;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		Criteria ct = null;
		
		String orderByProp = "termRank";
		
		try
		{
			
			tx = _localSession.getTransaction();
			tx.begin();
			ct = _localSession.createCriteria(Carnivaltermsindextbl.class);
			ct.addOrder(Order.desc(orderByProp));
			
			allResultsList = ct.list();
			tx.commit();
			
		}catch(HibernateException hbe)
		{
			_log.error(hbe);
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
	
		
		
		return allResultsList;
	}
	
	
	public List<Carnivaltermsindextbl> searchForWordsInTerm(String searchedTerm)
	{
		List<Carnivaltermsindextbl> inTermListResults = null;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		Criteria ct = null;
		Criterion inCrit = null;
		String searchPropertyName = "domainTerm";
		String orderByProp = "termRank";
		
		try{
			inTermListResults = new ArrayList<Carnivaltermsindextbl>();
			tx = _localSession.getTransaction();
			tx.begin();
			inCrit = Restrictions.in(searchPropertyName, searchedTerm.split(" "));
			ct = _localSession.createCriteria(Carnivaltermsindextbl.class);
			ct.addOrder(Order.desc(orderByProp));
			inTermListResults = ct.list();
			_log.debug("Search by term" + searchedTerm+"in words is" + inTermListResults.size());
			tx.commit();
			
		}catch(HibernateException hbe)
		{
			_log.error(hbe);
			if(tx != null) tx.rollback();
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
		
		return inTermListResults;
	}
	
	public List<Carnivaltermsindextbl> pagedSearch(SearchTO pSearch)
	{
		List<Carnivaltermsindextbl> results = null;
		
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		Criteria ct = null;
		Criterion crit = null;
		Criterion orCrit = null;
		String searchPropertyName = "domainTerm";
		String orderByProp = "termRank";
		
		try{
			_log.debug("Attempting to execute paged search");
			tx = _localSession.getTransaction();
			tx.begin();
			crit = Restrictions.and(Restrictions.eq(searchPropertyName, pSearch.getSearchPhrase()));
			ct = _localSession.createCriteria(Carnivaltermsindextbl.class);
			//ct.add(Restrictions.eq(searchPropertyName, term));
			//ct.add(Restrictions.or(Restrictions.ilike(searchPropertyName, term)));
			orCrit = Restrictions.ilike(searchPropertyName, pSearch.getSearchPhrase(),MatchMode.ANYWHERE);
			ct.add(Restrictions.or(crit, orCrit));
			//ct.add(crit);
			ct.addOrder(Order.asc(orderByProp));
			ct.setFirstResult(SearchUtil.getFirstResult(pSearch.getSelectedPage()));
			//ct.setFetchSize(pSearch.getPagingSize());
			ct.setMaxResults(pSearch.getPagingSize());
			results = ct.list();
			_log.debug("Paged Search query returned " + results.size() + " search results");
			tx.commit();
		}catch(HibernateException hbe)
		{
			_log.error(hbe);
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
		
		return results;
		
	}
	
	
	public List<Carnivaltermsindextbl> pagedSearchByNatLang(SearchTO pSearch)
	{
		List<Carnivaltermsindextbl> srchresultsList = null;
		
		
		Session _localSession = HibernatePersistenceUtil.getSessionFactory().openSession();
		Transaction tx = _localSession.getTransaction();
		Query srchQ = null;
		
		try{
			tx.begin();
			srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_SEARCH_QUERY).addEntity(Carnivaltermsindextbl.class);
			srchQ.setString(0, pSearch.getSearchPhrase());
			srchQ.setMaxResults(pSearch.getPagingSize());
			srchQ.setFirstResult(SearchUtil.getFirstResult(pSearch.getSelectedPage()));
			
			srchresultsList = srchQ.list();
			_log.info("Natural Language search returned-" + srchresultsList.size() + " results");
			tx.commit();
			
		}catch(HibernateException hbe)
		{
			_log.error(hbe);
			if(tx != null) tx.rollback();
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
		
		return srchresultsList;
	}
	
	
	public int getSearchResultSize(String phrase)
	{
		Integer results = 0;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		Criteria ct = null;
		Criterion crit = null;
		Criterion orCrit = null;
		String searchPropertyName = "domainTerm";
		String orderByProp = "termRank";
		
		try{
			
			tx = _localSession.getTransaction();
			tx.begin();
			crit = Restrictions.and(Restrictions.eq(searchPropertyName, phrase));
			ct = _localSession.createCriteria(Carnivaltermsindextbl.class);
			//ct.add(Restrictions.eq(searchPropertyName, term));
			//ct.add(Restrictions.or(Restrictions.ilike(searchPropertyName, term)));
			orCrit = Restrictions.ilike(searchPropertyName, phrase,MatchMode.ANYWHERE);
			ct.add(Restrictions.or(crit, orCrit));
			//ct.add(crit);
			ct.addOrder(Order.asc(orderByProp));
			results = ct.list().size();
			_log.debug("Search query returned " + results + " search results");
			tx.commit();
		}catch(HibernateException hbe)
		{
			_log.error(hbe);
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
		
		return results;
	
	}
	
	public List<Tblrecentsearches> getRecentSearches()
	{
		List<Tblrecentsearches> recentSearches = null;
		
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		String orderByProperty = "createdDate";
		
		
		try{
			
			tx = _localSession.beginTransaction();
			recentSearches = (List<Tblrecentsearches>) _localSession.createCriteria(com.netreality.vertie.reveng.Tblrecentsearches.class).addOrder(Order.asc(orderByProperty)).list();
			_log.debug("Search of recent searches returned " + recentSearches.size() + " results");
			
		}catch(HibernateException hbe)
		{
			_log.error("Recent search query failed", hbe);
			if(tx != null) tx.rollback();
			
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
				
				tx = _localSession.beginTransaction();
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
				
				_log.error("Transaction failed", hbe);
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
		
		return savedSearches;
		
	}
	
	
	
	public void addSearch(Tblrecentsearches userSearch)
	{
		
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		
		try{
			 tx = _localSession.beginTransaction();
			 _localSession.persist(userSearch);
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
	
	public List<Carnivaltermsindextbl> searchByNaturalLang(String searchWords)
	{
		List<Carnivaltermsindextbl> sResultList = null;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		Query srchQ = null;
		
		try{
			srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_SEARCH_QUERY).addEntity(Carnivaltermsindextbl.class);
			srchQ.setString(0, searchWords);
			srchQ.setMaxResults(MAX_NATURAL_LANGUAGE_SEARCH_RESULT_SIZE);
			tx.begin();
			sResultList = srchQ.list();
			_log.info("Natural Language search returned-" + sResultList.size() + " results");
			tx.commit();
			
		}catch(HibernateException hbe)
		{
			_log.error(hbe);
			if(tx != null) tx.rollback();
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
		
		
		return sResultList;
	}
	
	
	public List<Carnivaltermsindextbl> searchByNaturalLangBoolean(String searchWords)
	{
		List<Carnivaltermsindextbl> sResultList = null;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		Query srchQ = null;
		
		try{
			srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_BOOLEAN_SEARCH_QUERY).addEntity(Carnivaltermsindextbl.class);
			srchQ.setString(0, searchWords);
			srchQ.setMaxResults(MAX_NATURAL_LANGUAGE_SEARCH_RESULT_SIZE);
			tx.begin();
			sResultList = srchQ.list();
			_log.info("Natural Language search returned-" + sResultList.size() + " results");
			tx.commit();
			
		}catch(HibernateException hbe)
		{
			_log.error(hbe);
			if(tx != null) tx.rollback();
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
		
		return sResultList;
	}
	
	
	public BigInteger getSearchRelevanceNtl(String searchStr,NaturalLangSearchEnums searchType)
	{
		
		BigInteger result = null;
		Session _localSession = HibernatePersistenceUtil.getSession();
		Transaction tx = _localSession.getTransaction();
		Query srchQ = null;
		
		try{
			switch(searchType.getSrchTypeVal())
			{
			case 0:
			{
				//srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_SEARCH_QUERY_COUNT).addEntity(Carnivaltermsindextbl.class);
				srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_SEARCH_QUERY_COUNT);
			}
			case 1:
			{
				//srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_BOOLEAN_SEARCH_QUERY_COUNT).addEntity(Carnivaltermsindextbl.class);
				srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_BOOLEAN_SEARCH_QUERY_COUNT);
			}
			case 2:
			{
				
			}
			default:
				//srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_SEARCH_QUERY_COUNT).addEntity(Carnivaltermsindextbl.class);
				srchQ = _localSession.createSQLQuery(NATURAL_LANGUAGE_SEARCH_QUERY_COUNT);
			}
			tx.begin();
			srchQ.setString(0, searchStr);
			srchQ.setMaxResults(MAX_NATURAL_LANGUAGE_SEARCH_RESULT_SIZE);
			
			
			result = (BigInteger)srchQ.uniqueResult();
			_log.info("Natural Language search count returned-" + result);
			//tx.commit();
			
		}catch(HibernateException hbe)
		{
			_log.error(hbe);
			if(tx != null) tx.rollback();
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
		
		
		return result;
	}
	
	public void finalize()
	{
		_log.debug("Getting ready to shutdown hibernate");
		HibernatePersistenceUtil.shutdown();
	}
	
}
