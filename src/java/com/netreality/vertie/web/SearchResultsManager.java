/**
 * @date Sep 13, 2014
 */
package com.netreality.vertie.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestClientException;

import com.live4carnival.web.integration.rest.util.Live4CarnivalRestUtil;
import com.netreality.livecarnival.search.GoogleCSESearchHelper;
import com.netreality.vertie.alpha.to.PagedResultTO;
import com.netreality.vertie.alpha.to.RecentSearchTO;
import com.netreality.vertie.alpha.to.SearchResultTO;
import com.netreality.vertie.alpha.to.SearchTO;
import com.netreality.vertie.exception.SearchResultsException;
import com.netreality.vertie.persistence.dao.SearchResultsDAO;
import com.netreality.vertie.reveng.Carnivaltermsindextbl;
import com.netreality.vertie.reveng.Tblrecentsearches;
import com.netreality.vertie.search.GoogleCSESearchResponse;
import com.netreality.vertie.search.SearchResults;
import com.netreality.vertie.search.util.SearchResultUtils;

/**
 * @author ldurh516
 *
 * @date Sep 13, 2014
 *	
 */
public class SearchResultsManager implements SearchResults {
	
	private SearchResultsDAO dao;
	private Logger _log = Logger.getLogger(SearchResultsManager.class);
	
	public SearchResultsManager()
	{
		dao = new SearchResultsDAO();
	}

	/* (non-Javadoc)
	 * @see com.netreality.vertie.search.SearchResults#searchByKeywords(java.lang.String)
	 */
	@Override
	public List<SearchResultTO> searchByKeywords(String keywords) {

		List<SearchResultTO> searchResultList = null;
		
		if(keywords != null && keywords.length() > 1)
		{
			List<Carnivaltermsindextbl> results = dao.getResultsByKeyword(keywords);
			if(results != null && !results.isEmpty())
			{
				_log.info("Resultset returned-" + results.size() + "- results for keyword search-" + keywords);
				searchResultList = new ArrayList<SearchResultTO>(results.size());
				SearchResultTO resultTO = null;
				for(Carnivaltermsindextbl idxTerms: results)
				{
					if(idxTerms != null)
					{
						resultTO = new SearchResultTO();
						resultTO.setResultUrl(idxTerms.getTermUrl());
						resultTO.setResultScore(idxTerms.getTermRank());
						resultTO.setSearchPhrase(keywords);
						resultTO.setDomainTerm(idxTerms.getDomainTerm());
						searchResultList.add(resultTO);
					}
				}
				
			}
			else
			{
				searchResultList = new ArrayList<SearchResultTO>();
			}
		}
		
		return searchResultList;
	}
	
	public SearchTO verifySearch(String phraseOrKeyWords)
	{
		SearchTO sObj = null;
		if(phraseOrKeyWords != null)
		{
			sObj = this.dao.processSearch(phraseOrKeyWords);
		}
		else
		{
			sObj = new SearchTO();
		}
		
		return sObj;
	}
	
	public PagedResultTO pagedSearch(SearchTO currentSearch) throws SearchResultsException
	{
		PagedResultTO pgResults = null;
		
		if(currentSearch != null)
		{
			
			List<Carnivaltermsindextbl> pagedList = null;
			pagedList = this.dao.pagedSearchByNatLang(currentSearch);
			if(pagedList != null && !pagedList.isEmpty())
			{
				_log.debug("Hibernate objects returned for paged search request for search id" + currentSearch.getSearchId());
				List<SearchResultTO> pgResultList = new ArrayList<SearchResultTO>(pagedList.size());
				SearchResultTO resultTO = null;
				pgResults = new PagedResultTO();
				for(Carnivaltermsindextbl tResult : pagedList)
				{
					if(tResult != null)
					{
						resultTO = new SearchResultTO();
						resultTO.setResultScore(tResult.getTermRank());
						resultTO.setDomainTerm(tResult.getDomainTerm());
						resultTO.setResultUrl(tResult.getTermUrl());
						pgResultList.add(resultTO);
					}
					
				}
				pgResults.setPagedResultSet(pgResultList);
				_log.debug("Paged Search method returned " + pgResultList.size() + " results");
				
			}
			else
			{
				_log.info("Paged Search returned no results");
				throw new SearchResultsException("Paged search should have returned results");
			}
			pagedList.clear();
			
		}
		
		return pgResults;
	}

	/* (non-Javadoc)
	 * @see com.netreality.vertie.search.SearchResults#searchByReserveKeyWords(java.lang.String)
	 */
	@Override
	public List<SearchResultTO> searchByReserveKeyWords(String reserveWords) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netreality.vertie.search.SearchResults#searchByDate(java.util.Date, java.util.Date)
	 */
	@Override
	public List<SearchResultTO> searchByDate(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netreality.vertie.search.SearchResults#searchByRegion(java.lang.Object)
	 */
	@Override
	public List<SearchResultTO> searchByRegion(Object region) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netreality.vertie.search.SearchResults#addSearch(com.netreality.vertie.alpha.to.RecentSearchTO)
	 */
	@Override
	public void addSearch(RecentSearchTO search) {
		
		if(search != null)
		{
			Tblrecentsearches recentSearch = null;
			recentSearch = new Tblrecentsearches();
			recentSearch.setSearchWords(search.getSearchWords());
			recentSearch.setCreatedDate(GregorianCalendar.getInstance().getTime());
			dao.addSearch(recentSearch);
		}
		
	}

	@Override
	public List<SearchResultTO> searchByRest(String searchStr) {
		
		List<SearchResultTO> srchResultList = null;
		GoogleCSESearchResponse srchResp = null;
		if(searchStr != null)
		{
			searchStr = GoogleCSESearchHelper.buildCSERestSearchQry(searchStr);
			_log.info(searchStr);
			srchResp = executeCSESearch(searchStr);
			srchResultList = SearchResultUtils.convertCSERestResp(srchResp, searchStr);
		}
		else
		{
			srchResultList = new ArrayList<SearchResultTO>();
		}
		
		return srchResultList;
	}
	
	
	public PagedResultTO pagedSearchByRest()
	{
		PagedResultTO pagedRestResults = null;
		
		return pagedRestResults;
	}
	
	
	
	
	private GoogleCSESearchResponse executeCSESearch(String srcQry)
	{
		GoogleCSESearchResponse jsonResp = null;
		if(srcQry != null)
		{
			_log.debug("Executing search request to google CSE Search engine" + srcQry);
			try {
				jsonResp = Live4CarnivalRestUtil.executeCSERequest(srcQry);
			} catch (RestClientException | UnsupportedEncodingException mte) {
				_log.error(mte);
				mte.printStackTrace();
			}
		}
		
		return jsonResp;
	}

}
