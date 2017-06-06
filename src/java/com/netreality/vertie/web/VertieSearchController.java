package com.netreality.vertie.web;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.live4carnival.web.integration.rest.util.Live4CarnivalRestUtil;
import com.live4carnival.web.integration.rest.util.TicketAPIUtil;
import com.live4carnival.xml.util.XMLHelper;
import com.livecarnival.tickets.to.EventDisplayObj;
import com.livecarnival.tickets.to.GenericTicketRespTo;
import com.netreality.live4carnival.airfare.helper.QPXAirfareHelper;
import com.netreality.live4carnival.integration.to.AirTravelForm;
import com.netreality.live4carnival.integration.to.QPXAirfareRequest;
import com.netreality.live4carnival.integration.to.QPXAirfareRequestTO;
import com.netreality.live4carnival.integration.to.QPXAirfareResponseTO;
import com.netreality.livecarnival.search.CSESearchResultsUtil;
import com.netreality.vertie.alpha.airfare.to.AirfareResultsViewTO;
import com.netreality.vertie.alpha.to.PagedResultTO;
import com.netreality.vertie.alpha.to.PagedResultsViewTO;
import com.netreality.vertie.alpha.to.RecentSearchTO;
import com.netreality.vertie.alpha.to.SearchResultTO;
import com.netreality.vertie.alpha.to.SearchTO;
import com.netreality.vertie.exception.SearchResultsException;
import com.netreality.vertie.exception.SearchSubmissionException;
import com.netreality.vertie.search.util.SearchResultUtils;
import com.netreality.vertie.search.util.SearchUtil;

import static com.live4carnival.web.integration.rest.util.Live4CarnivalRestUtil.QPX_AIRFARE_URL;




@Controller
@RequestMapping("/")
@Scope("session")

public class VertieSearchController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7732970627536958491L;
	private ModelAndView searchMVW = null;
	private Map<String,Object> searchModel = null;
	private Map<String,Object> eventDataModel = null;
	private Map<String,Object> viewModel = null;
	private Integer SEARCH_MODEL_INIT_CAPACITY = 100;
	private Boolean MODEL_IS_INITIALIZED = false;
	private View searchView = null;
	private String VERTIE_SEARCH_MODEL_NAME = "searchModel";
	private StringBuffer VERTIE_RECENT_SEARCH_PHRASES = new StringBuffer();
	private String VERTIE_TRENDING_SEARCHES_STRING_KEY = "trending";
	
	
	//Views
	private String VERTIE_SEARCH_LANDING_VIEW = "carnivate/searchLanding";
	private Logger _log = Logger.getLogger(VertieSearchController.class);
	private String VERTIE_RESULTS_MAIN_VIEW = "carnivate/resultsView";
	private String VERTIE_NO_RESULTS_MAIN_VIEW = "carnivate/noResultsView";
	private String VERTIE_HOTEL_SEARCH_VIEW = "carnivate/hotelSearchView";
	private String VERTIE_HOTEL_SEARCH_RESULTS_VIEW = "carnivate/hotelResultsView";
	private String VERTIE_TRAVEL_SEARCH_VIEW = "carnivate/travelSearchView";
	private String VERTIE_TRAVEL_SEARCH_RESULTS_VIEW = "carnivate/travelResults"; 
	private String VERTIE_EVENT_MGMNT_VIEW = "carnivate/eventsManagement";
	private String VERTIE_EVENT_MGMNT_VIEW_BY_CARNIVAL = "carnivate/eventsManagementByCarnival";
	private SearchResultsManager searchResultMgr = new SearchResultsManager();
	private SearchManager srcMgr = new SearchManager();
	
	private String VERTIE_TEST_AJAX_VIEW = "carnivate/testView";
	
	//Social Media events tag Test View
	private String SOCIAL_MEDIA_TEST_VIEW = "carnivate/socailMediaView";
	
	//Search Data Key
	private String VERTIE_MAIN_SEARCH_RESULTS_KEY = "mainSearch";
	private String VERTIE_TRENDING_SEARCHES_KEY = "recentSearches";
	//Travel Search Results Keys
	private String LIVE_CARNIVAL_TRAVEL_ITTINERARY_SEARCH = "travelItinerary";
	private String LIVE_CARNIVAL_TRAVEL_RESULTS = "travelSearchResults";
	private String LIVE_CARNIVAL_TRAVEL_RESULTS_SOLUTIONS_SIZE = "travelSolutions";
	//Event Data Keys
	private String LIVE_CARNIVAL_ALL_EVENT_DATA = "allEvents";
	//Current Search TO
	private String VERTIE_CURRENT_SEARCH_KEY = "currentSearch";
	private String VERTIE_PAGED_RESULTS_VIEW_KEY = "currentView";
	//URLs
	//Paged results urls
	private String VERTIE_PAGED_SEARCH_RESULTS_URL = "/Carnivate/pageResults";
	private String VERTIE_PAGED_SEARCH_RESULTS_URL_KEY = "pagedSearchResults";
	//Search URL
	private String VERTIE_KEYWORDS_SEARCH_URL_KEY = "keywordSearch";
	private String VERTIE_KEYWORDS_SEARCH_URL = "/Carnivate/results";
	
	//fields for navigation links
	private String LIVE_CARNIVAL_NAVIGATION_ACCOMODATION_HREF_VALUE="Carnivate/hotelSearch";
	private String LIVE_CARNIVAL_NAVIGATION_ACCOMODATION_HREF_KEY = "hotelLink";
	
	private String LIVE_CARNIVAL_NAVIGATION_TRAVEL_HREF_VALUE = "Carnivate/travelSearch";
	private String LIVE_CARNIVAL_NAVIGATION_TRAVEL_HREF_KEY = "travelLink";
	
	//Travel Search Submit url
	private String LIVE_CARNIVAL_NAVIGATION_TRAVEL_SEARCH_ACTION_KEY ="travelSearchAction";
	private String LIVE_CARNIVAL_NAVIGATION_TRAVEL_SEARCH_ACTION_VALUE = "Carnivate/submitTravelSearch";
	
	//XML file containing Carnival List
	private String LIVE_CARNIVAL_EVENTS_XML_PACKAGE = "com/livecarnival/events/xml/";
	private String LIVE_CARNIVAL_EVENTS_XML_FILE_NAME = "carnivals.xml";
	private String LIVE_CARNIVAL_EVENTS_ELEMENT_NAME = "carnival";
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHomeUrl()
	{
		return "redirect:/searchLanding";
	}
	
	
	
	@RequestMapping(value="Carnivate", method=RequestMethod.GET)
	public String getSiteRoot()
	{
		return "redirect:/Carnivate/searchLanding";
	}
	
	/*@RequestMapping(value="Carnivate/search", method=RequestMethod.GET)
	public ModelAndView getSearchPage()
	{
		ModelAndView seachIndexView = null;
		initSearchController();
		
		
		seachIndexView = this.searchMVW;
		searchMVW.setViewName(VERTIE_SEARCH_LANDING_VIEW);
		
		return seachIndexView;
	}
	*/
	
	@RequestMapping(value="Carnivate/searchLanding", method=RequestMethod.GET)
	public ModelAndView getSearchLanding()
	{
		ModelAndView landingView = null;
		landingView = getInitModelAndView(VERTIE_SEARCH_LANDING_VIEW);
		
		//landingView = this.searchMVW;
		
		return landingView;
	}
	
	@RequestMapping(value="Carnivate/hotelSearch",method=RequestMethod.GET)
	public ModelAndView getHotelSearchView()
	{
		
		
		return getInitModelAndView(VERTIE_HOTEL_SEARCH_VIEW);
	}
	
	@RequestMapping(value="Carnivate/hotelSearchResults",method=RequestMethod.GET)
	public ModelAndView getHotelSearchResultsView()
	{
		
		return getInitModelAndView(VERTIE_HOTEL_SEARCH_RESULTS_VIEW);
	}
	
	
	@RequestMapping(value="Carnivate/travelSearch",method=RequestMethod.GET)
	public ModelAndView getTravelFormView()
	{
		
		return getInitModelAndView(VERTIE_TRAVEL_SEARCH_VIEW);
	}
	
	
	@RequestMapping(value="Carnivate/events",method=RequestMethod.GET)
	public ModelAndView getEventMgmtView(HttpServletRequest req)
	{
		//injectEventData();
		injectTestEventData();
		setupFileResources(req);
		return getInitModelAndView(VERTIE_EVENT_MGMNT_VIEW);
	}
	
	
	private void setupFileResources(HttpServletRequest aReq)
	{
		WebApplicationContext webCtx = null;
		Resource xmlFileRes = null;
		List<String> carnivalNamesList = null;
		
		if(aReq != null)
		{
			webCtx = RequestContextUtils.getWebApplicationContext(aReq);
			xmlFileRes = webCtx.getResource("classpath:" + LIVE_CARNIVAL_EVENTS_XML_PACKAGE + LIVE_CARNIVAL_EVENTS_XML_FILE_NAME);
			try {
				File fileRes = xmlFileRes.getFile();
				 carnivalNamesList = XMLHelper.getElementsAsCollection(LIVE_CARNIVAL_EVENTS_ELEMENT_NAME, fileRes);
				_log.debug(carnivalNamesList.size() + " Carnivals");
				 searchModel.put("carnivalList", carnivalNamesList);
			} catch (IOException ioe) {
				_log.error(ioe);
			}
		}
		
	}
	
	@RequestMapping(value="Carnivate/eventsSortByDate",method=RequestMethod.GET)
	public ModelAndView getEventMgmtViewByDate()
	{
		injectEventDataSortByDate();
		_log.debug("Return events sorted by date");
		return getInitModelAndView(VERTIE_EVENT_MGMNT_VIEW);
	}
	
	
	@RequestMapping(value="Carnivate/eventsSortByCarnival",method=RequestMethod.GET)
	public ModelAndView getEventsByCarnival()
	{
		_log.debug("View events");
		return getInitModelAndView(VERTIE_EVENT_MGMNT_VIEW_BY_CARNIVAL);
	}
	
	
	private void injectEventData()
	{
		List<EventDisplayObj> allEventData = null;
		allEventData = TicketAPIUtil.getAllEvents();
		searchModel.put(LIVE_CARNIVAL_ALL_EVENT_DATA, allEventData);
	}
	
	private void injectTestEventData()
	{
		List<EventDisplayObj> allEventData = null;
		allEventData = TicketAPIUtil.getTestEvents();
		searchModel.put(LIVE_CARNIVAL_ALL_EVENT_DATA, allEventData);
	}
	
	private void injectEventDataSortByDate()
	{
		_log.info("Injecting event data");
		List<EventDisplayObj> allEventData = null;
		//allEventData = (List<EventDisplayObj>)searchModel.get(LIVE_CARNIVAL_ALL_EVENT_DATA);
		allEventData = TicketAPIUtil.getTestEvents();
		allEventData = TicketAPIUtil.sortAllEventsByStartDate(allEventData);
		for(EventDisplayObj ev: allEventData)
		{
			_log.info(ev.getEventStartDate());
		}
		searchModel.put(LIVE_CARNIVAL_ALL_EVENT_DATA, allEventData);
	}
	
	
	
	@RequestMapping(value="Carnivate/submitTravelSearch",method=RequestMethod.POST)
	public ModelAndView submitTravelSearch(@ModelAttribute("travelData") AirTravelForm travelData)
	{
		ModelAndView mvw = null;
		//mvw = getInitModelAndView(VERTIE_TRAVEL_SEARCH_RESULTS_VIEW);
		
		QPXAirfareResponseTO fareResultSolution = null;
		AirTravelForm formData =(AirTravelForm) searchModel.get("travelData");
		AirfareResultsViewTO travelResultView = null;
		if(formData != null || travelData != null)
		{
			_log.info("Form Data is in the model");
			_log.debug("Searching for airfare from- "+ travelData.getFromAirport() + " Airport");
			_log.debug("To- "+ travelData.getToAirport() + " Airport");
			fareResultSolution = createAifareRequest(travelData);
			if(fareResultSolution != null)
			{
				travelResultView = QPXAirfareHelper.createAirfareResultsView(fareResultSolution);	
			}
			searchModel.put(LIVE_CARNIVAL_TRAVEL_RESULTS, travelResultView);
			searchModel.put(LIVE_CARNIVAL_TRAVEL_ITTINERARY_SEARCH, travelData.getFromAirport() + "to "+ travelData.getToAirport());
			//searchModel.put(LIVE_CARNIVAL_TRAVEL_ITTINERARY_SEARCH, "Testing");
			searchModel.put(LIVE_CARNIVAL_TRAVEL_RESULTS_SOLUTIONS_SIZE, fareResultSolution.getTrips().getTripOption().size());
		
		}
		else
		{
			_log.info("Form Data not found in the model");
		}
		mvw = getInitModelAndView(VERTIE_TRAVEL_SEARCH_RESULTS_VIEW);
		_log.debug("Fare returned is" + fareResultSolution);
		return mvw;
		
	}
	
	private QPXAirfareResponseTO createAifareRequest(AirTravelForm airfareReq)
	{
		QPXAirfareRequestTO aRequest = null;
		QPXAirfareRequest airFareFormReq = null;
		
		QPXAirfareResponseTO airfareSearchSolution = null;
		
		airFareFormReq = QPXAirfareHelper.createAirfareRequestFromSearch(airfareReq);
		
		aRequest = new QPXAirfareRequestTO();
		aRequest.setRequest(airFareFormReq);
		
		airfareSearchSolution = Live4CarnivalRestUtil.executeQPXAPIRequest(QPX_AIRFARE_URL, aRequest);
		_log.info(airfareSearchSolution);
		
		return airfareSearchSolution;
	}
	
	
	
	
	private ModelAndView getInitModelAndView(String viewName)
	{
		ModelAndView mvw = null;
		mvw = new ModelAndView(viewName,VERTIE_SEARCH_MODEL_NAME,searchModel);
		if(!modelIsInitialized())
			initSearchController(viewName);
		
		return mvw;
	}
	
	
	@RequestMapping(value="Carnivate/search", method=RequestMethod.POST)
	public String getSearchPageByPost()
	{
		_log.debug("Navigating to Search Landing page via Post");
		
		return "redirect:/Carnivate/search";
	}
	
	@RequestMapping(value="Carnivate/results", method=RequestMethod.POST)
	public String getSearchResults(HttpServletRequest request,@RequestParam("searchWords") String searchKeyWords) throws SearchSubmissionException
	{
		
		_log.debug("Search phrase is " + searchKeyWords);
		//ModelAndView resultsView = null;
		//resultsView = getInitModelAndView(String);
		
		PagedResultsViewTO pgView = null;
		 List<SearchResultTO> searchResultsList = null;
		 SearchTO runSearch = null;
		 RecentSearchTO recent = null;
		 
			if(searchKeyWords != null && searchKeyWords.length() > 1)
			{					
				recent = new RecentSearchTO();
				recent.setSearchWords(searchKeyWords);
				runSearch = this.searchResultMgr.verifySearch(searchKeyWords);
				this.searchResultMgr.addSearch(recent);
				if(runSearch.getResultSetSize() > 0)
				{
					
					//sReq.setResultSetSize(runSearch.getResultSetSize())
					pgView = new PagedResultsViewTO();
					pgView = SearchUtil.initView(runSearch);
					runSearch.setSearchId(SearchUtil.generateSearchId());
					pgView.setSearchId(runSearch.getSearchId());
					searchResultsList = new ArrayList<SearchResultTO>();
					
					try {
						searchResultsList = this.searchResultMgr.pagedSearch(runSearch).getPagedResultSet();
						
					} catch (SearchResultsException sre) {
						_log.error(sre);
					}
					searchResultsList = addPageTitleToURL(searchResultsList);
					_log.debug("Getting the title for " + searchResultsList.size() + " results");
					
					
					
				}
				else
				{
					_log.debug("No results found");
				}
				
				/*if(searchResultsList.isEmpty())
				{
					_log.debug("No results found");
				}
				else
				{
					_log.debug("Adding results to the model");
					
				}*/
				searchModel.put(VERTIE_MAIN_SEARCH_RESULTS_KEY, searchResultsList);
				searchModel.put(VERTIE_CURRENT_SEARCH_KEY, runSearch);
				searchModel.put(VERTIE_PAGED_RESULTS_VIEW_KEY, pgView);
			}
		
			else
			{
				throw new SearchSubmissionException("No search keywords or phrase");
			}
		return "redirect:/Carnivate/results"  ;
	}
	
	@RequestMapping(value="Carnivate/cseResults", method=RequestMethod.POST)
	public String getSearchResultsfromCSE(HttpServletRequest request,@RequestParam("searchWords") String searchKeyWords) throws SearchSubmissionException
	{
		
		_log.debug("Search phrase is " + searchKeyWords);
		
		
		PagedResultsViewTO pgView = null;
		 List<SearchResultTO> searchResultsList = null;
		 SearchTO runSearch = null;
		 RecentSearchTO recent = null;
		 
			if(searchKeyWords != null && searchKeyWords.length() > 1)
			{					
				recent = new RecentSearchTO();
				recent.setSearchWords(searchKeyWords);
				this.searchResultMgr.addSearch(recent);
				searchResultsList = new ArrayList<SearchResultTO>();
				searchResultsList = this.searchResultMgr.searchByRest(searchKeyWords);
					
					
					if(searchResultsList.isEmpty())
					{
						_log.debug("No results found");
					}
					
					else
					{
						runSearch = CSESearchResultsUtil.generateSearchTOForCseResults(searchKeyWords, searchResultsList);
						pgView = new PagedResultsViewTO();
						pgView.setSearchId(SearchUtil.generateSearchId());
						pgView = SearchUtil.initView(runSearch);
					}
					
				
					
				
				
				
				searchModel.put(VERTIE_MAIN_SEARCH_RESULTS_KEY, searchResultsList);
				searchModel.put(VERTIE_CURRENT_SEARCH_KEY, runSearch);
				searchModel.put(VERTIE_PAGED_RESULTS_VIEW_KEY, pgView);
			}
		
			else
			{
				throw new SearchSubmissionException("No search keywords or phrase");
			}
		return "redirect:/Carnivate/results"  ;
	}
	
	
	
	
	@RequestMapping(value="Carnivate/results", method=RequestMethod.GET)
	public ModelAndView displaySearchResults()
	{
		ModelAndView resultsView = null;
		resultsView = getInitModelAndView(VERTIE_RESULTS_MAIN_VIEW);
		
		
		
		return resultsView;
	}
	
	@RequestMapping(value="Carnivate/pageResults",method=RequestMethod.POST)
	public String displayPagedResultsForPost(@RequestParam("resultsId")String searchId,@RequestParam("page") String resultPage)
	{
		List<SearchResultTO> pagedResultsList = null;
		if(searchId != null && resultPage != null)
		{
			_log.debug("Attempting to retrieve result for search with id-" + searchId);
			SearchTO currentSearch = (SearchTO) this.searchModel.get(VERTIE_CURRENT_SEARCH_KEY);
			PagedResultsViewTO currentView = null;
			if(currentSearch.getSearchId().toString().equals(searchId))
			{
				_log.info("Found matching search");
				Integer selectedPage = Integer.valueOf(resultPage);
				currentSearch.setSelectedPage(selectedPage);
				currentSearch = SearchUtil.paginateResults(currentSearch);
				try {
					pagedResultsList = this.searchResultMgr.pagedSearch(currentSearch).getPagedResultSet();
					currentView = (PagedResultsViewTO) this.searchModel.get(VERTIE_PAGED_SEARCH_RESULTS_URL_KEY);
					currentView = SearchUtil.paginateView(currentSearch, currentView);
				} catch (SearchResultsException sre) {
					_log.error(sre);
				}
				_log.debug("The pageview current index is-" + currentView.getCurrentPageIndex());
				_log.debug("The currently selected search index" + currentSearch.getSelectedPage());
				pagedResultsList = addPageTitleToURL(pagedResultsList);
				searchModel.put(VERTIE_CURRENT_SEARCH_KEY, currentSearch);
				searchModel.put(VERTIE_MAIN_SEARCH_RESULTS_KEY, pagedResultsList);
				searchModel.put(VERTIE_PAGED_RESULTS_VIEW_KEY, currentView);
			}
			
		}
		return "redirect:/Carnivate/results";
	}
		
		@RequestMapping(value="Carnivate/pageCseResults",method=RequestMethod.POST)
		public String displayPagedCseResultsForPost(@RequestParam("resultsId")String searchId,@RequestParam("page") String resultPage)
		{
			List<SearchResultTO> pagedResultsList = null;
			if(searchId != null && resultPage != null)
			{
				_log.debug("Attempting to retrieve result for search with id-" + searchId);
				SearchTO currentSearch = (SearchTO) this.searchModel.get(VERTIE_CURRENT_SEARCH_KEY);
				PagedResultsViewTO currentView = null;
				if(currentSearch.getSearchId().toString().equals(searchId))
				{
					_log.info("Found matching search");
					Integer selectedPage = Integer.valueOf(resultPage);
					currentSearch.setSelectedPage(selectedPage);
					currentSearch = SearchUtil.paginateResults(currentSearch);
					//pagedResultsList = this.searchResultMgr.pagedSearch(currentSearch).getPagedResultSet();
					currentView = (PagedResultsViewTO) this.searchModel.get(VERTIE_PAGED_SEARCH_RESULTS_URL_KEY);
					currentView = SearchUtil.paginateView(currentSearch, currentView);
					_log.debug("The pageview current index is-" + currentView.getCurrentPageIndex());
					_log.debug("The currently selected search index" + currentSearch.getSelectedPage());
					//pagedResultsList = addPageTitleToURL(pagedResultsList);
					searchModel.put(VERTIE_CURRENT_SEARCH_KEY, currentSearch);
					//searchModel.put(VERTIE_MAIN_SEARCH_RESULTS_KEY, pagedResultsList);
					searchModel.put(VERTIE_PAGED_RESULTS_VIEW_KEY, currentView);
				}
				
			}
		
		
		return "redirect:/Carnivate/results";
	}
	
	@RequestMapping(value="Carnivate/scrollPagedResults",method=RequestMethod.POST)
	public String scrollPageResults(@RequestParam("resultsId")String searchId)
	{
		String redirectStr = "redirect:/Carnivate/scrollPagedResults";
		
		return redirectStr;
	}
	
	@RequestMapping(value="Carnivate/scrollPagedResults",method=RequestMethod.GET)
	public ModelAndView scrollPageResults()
	{
		ModelAndView scrolledMAV = null;
		
		return scrolledMAV;
	}
	
	
	@RequestMapping(value="Carnivate/pageResults",method=RequestMethod.GET)
	public ModelAndView displayPagedResults(@RequestParam("resultsId")String searchId,@RequestParam("page") String resultPage)
	{
		ModelAndView pagedView = null;
		pagedView = getInitModelAndView(VERTIE_RESULTS_MAIN_VIEW);
		
		List<SearchResultTO> pagedResultsList = null;
		PagedResultTO pages = null;
		PagedResultsViewTO currentView = null;
		if(searchId != null && resultPage != null)
		{
			_log.debug("Attempting to retrieve result for search with id-" + searchId);
			SearchTO currentSearch = (SearchTO) this.searchModel.get(VERTIE_CURRENT_SEARCH_KEY);
			if(currentSearch.getSearchId().toString().equals(searchId))
			{
				currentView = (PagedResultsViewTO) this.searchModel.get(VERTIE_PAGED_RESULTS_VIEW_KEY);
				_log.info("Found matching search");
				Integer selectedPage = Integer.valueOf(resultPage);
				currentSearch = SearchUtil.paginateResults(currentSearch);
				currentSearch.setSelectedPage(selectedPage);
				 currentView = SearchUtil.paginateView(currentSearch, currentView);
				_log.info("Attempting to return paged results starting at " + currentSearch.getPrevPage() + " ending at" + currentSearch.getNextPage());
				try {
					pages = this.searchResultMgr.pagedSearch(currentSearch);
					
					if(pages != null)
					{
						pagedResultsList = pages.getPagedResultSet();
						
					}
					
				} catch (SearchResultsException sre) {
					_log.error(sre);
				}
				pagedResultsList = addPageTitleToURL(pagedResultsList);
				searchModel.put(VERTIE_CURRENT_SEARCH_KEY, currentSearch);
				searchModel.put(VERTIE_MAIN_SEARCH_RESULTS_KEY, pagedResultsList);
				searchModel.put(VERTIE_PAGED_RESULTS_VIEW_KEY, currentView);
			}
			
		}
		
		
		
		//pagedView = this.searchMVW;
		//pagedView.setViewName(VERTIE_RESULTS_MAIN_VIEW);
		return pagedView;
	}
	
	
	@RequestMapping(value="Carnivate/pageCSEResults",method=RequestMethod.GET)
	public ModelAndView displayCSEPagedResults(@RequestParam("resultsId")String searchId,@RequestParam("page") String resultPage)
	{
		ModelAndView pagedView = null;
		pagedView = getInitModelAndView(VERTIE_RESULTS_MAIN_VIEW);
		
		//List<SearchResultTO> pagedResultsList = null;
		//PagedResultTO pages = null;
		PagedResultsViewTO currentView = null;
		if(searchId != null && resultPage != null)
		{
			_log.debug("Attempting to retrieve result for search with id-" + searchId);
			SearchTO currentSearch = (SearchTO) this.searchModel.get(VERTIE_CURRENT_SEARCH_KEY);
			if(currentSearch.getSearchId().toString().equals(searchId))
			{
				currentView = (PagedResultsViewTO) this.searchModel.get(VERTIE_PAGED_RESULTS_VIEW_KEY);
				_log.info("Found matching search");
				Integer selectedPage = Integer.valueOf(resultPage);
				currentSearch = SearchUtil.paginateResults(currentSearch);
				currentSearch.setSelectedPage(selectedPage);
				 currentView = SearchUtil.paginateView(currentSearch, currentView);
				_log.info("Attempting to return paged results starting at " + currentSearch.getPrevPage() + " ending at" + currentSearch.getNextPage());
				/*try {
					pages = this.searchResultMgr.pagedSearch(currentSearch);
					
					if(pages != null)
					{
						pagedResultsList = pages.getPagedResultSet();
						
					}
					
				} catch (SearchResultsException sre) {
					_log.error(sre);
				}*/
				//pagedResultsList = addPageTitleToURL(pagedResultsList);
				searchModel.put(VERTIE_CURRENT_SEARCH_KEY, currentSearch);
				//searchModel.put(VERTIE_MAIN_SEARCH_RESULTS_KEY, pagedResultsList);
				searchModel.put(VERTIE_PAGED_RESULTS_VIEW_KEY, currentView);
			}
			
		}
		
		
		
		//pagedView = this.searchMVW;
		//pagedView.setViewName(VERTIE_RESULTS_MAIN_VIEW);
		return pagedView;
	}
	
	
	
	
	
	private List<SearchResultTO> addPageTitleToURL(List<SearchResultTO> results)
	{
		List<SearchResultTO> addTitleList = null;
		if(!results.isEmpty())
		{
			addTitleList = new ArrayList<SearchResultTO>(results.size());
			String pgTitle = null;
			for(SearchResultTO rto: results)
			{
				if(rto != null && rto.getResultUrl() != null)
					try {
							pgTitle = SearchResultUtils.getResultTitle(rto.getResultUrl());
							if(pgTitle != null)
								rto.setResultPageTitle(pgTitle);
							addTitleList.add(rto);
					} catch (IOException ioe) {
						_log.error(ioe);
					}
			}
		}
		
		return addTitleList;
	}
	
	private synchronized ModelAndView initSearchController(String viewName)
	{
		//this.searchResultMgr = new SearchResultsManager();
		ModelAndView initMvw = null;
		if(initMvw == null && !MODEL_IS_INITIALIZED)
		{
			searchModel = Collections.synchronizedMap(new WeakHashMap<String,Object>(SEARCH_MODEL_INIT_CAPACITY));
			viewModel = Collections.synchronizedMap(new WeakHashMap<String,Object>(SEARCH_MODEL_INIT_CAPACITY));
			
			MODEL_IS_INITIALIZED = true;
			_log.debug("Initializing model and view");
			searchModel.put(VERTIE_PAGED_SEARCH_RESULTS_URL_KEY, VERTIE_PAGED_SEARCH_RESULTS_URL);
			searchModel.put(VERTIE_KEYWORDS_SEARCH_URL_KEY, VERTIE_KEYWORDS_SEARCH_URL);
			searchModel.put(VERTIE_TRENDING_SEARCHES_KEY, VERTIE_RECENT_SEARCH_PHRASES);
			
			//initialize view model
			searchModel.put(LIVE_CARNIVAL_NAVIGATION_ACCOMODATION_HREF_KEY, LIVE_CARNIVAL_NAVIGATION_ACCOMODATION_HREF_VALUE);
			searchModel.put(LIVE_CARNIVAL_NAVIGATION_TRAVEL_HREF_KEY, LIVE_CARNIVAL_NAVIGATION_TRAVEL_HREF_VALUE);
			_log.debug("Grabbing map value-" + searchModel.get(LIVE_CARNIVAL_NAVIGATION_ACCOMODATION_HREF_KEY));
			searchModel.put(LIVE_CARNIVAL_NAVIGATION_TRAVEL_SEARCH_ACTION_KEY,LIVE_CARNIVAL_NAVIGATION_TRAVEL_SEARCH_ACTION_VALUE);
			initMvw = new ModelAndView(VERTIE_SEARCH_LANDING_VIEW,VERTIE_SEARCH_MODEL_NAME,searchModel);
			updateRecentSearches();
		}
		else
		{
			//initMvw.addObject(VERTIE_SEARCH_MODEL_NAME, searchModel);
			_log.debug("Model and View were already initialized");
		}
		
		return initMvw;
			
	}
	
	@RequestMapping(value="Carnivate/recentSearches", method=RequestMethod.GET)
	@ResponseBody
	public String getRecentSearches()
	{
		List<RecentSearchTO> recSearchList = null;
		
		recSearchList = this.srcMgr.getRecentSearches();
		
		StringBuffer buf = new StringBuffer();
		
		for(RecentSearchTO sData: recSearchList)
		{
			if(sData != null)
			{
				if(sData.getSearchWords() != null && sData.getSearchWords().length() > 1)
				{
					buf.append(sData.getSearchWords() + "|");
				}
			}
		}
		
		return buf.toString();
	}
	
	
	private void updateRecentSearches()
	{
		List<RecentSearchTO> recSearchList = null;
		
		recSearchList = this.srcMgr.getRecentSearches();
		
		StringBuffer buf = (StringBuffer) this.searchModel.get(VERTIE_TRENDING_SEARCHES_KEY);
		
		for(RecentSearchTO sData: recSearchList)
		{
			if(sData != null)
			{
				if(sData.getSearchWords() != null && sData.getSearchWords().length() > 1)
				{
					buf.append(sData.getSearchWords() + "|");
				}
			}
		}
		_log.debug("Recent or trending searches-" + buf.toString());
		this.searchModel.put(VERTIE_TRENDING_SEARCHES_STRING_KEY, buf.toString());
		
	}
	
	@RequestMapping(value="Carnivate/testTypeAhead", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView getTypeAheadTest()
	{
				
		ModelAndView searchIndexView = null;
		searchIndexView = getInitModelAndView(VERTIE_TEST_AJAX_VIEW);
		
		
				
		return searchIndexView;
	}
	
	
	@RequestMapping(value="Carnivate/socialMedia", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView getSocialMedia()
	{
		ModelAndView socialMediaView = null;
		
		socialMediaView = getInitModelAndView(SOCIAL_MEDIA_TEST_VIEW);
		
		
		return socialMediaView;
	}
	
	
	private Boolean modelIsInitialized()
	{
		return MODEL_IS_INITIALIZED;
	}
	

}
