/**
 * 
 */
package com.netreality.live4carnival.integration.to;

import java.util.Map;

/**
 * @author JahLion
 *
 */
public class CSESearchResultItems {
	
	private String kind;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHtmlTitle() {
		return htmlTitle;
	}
	public void setHtmlTitle(String htmlTitle) {
		this.htmlTitle = htmlTitle;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDisplayLink() {
		return displayLink;
	}
	public void setDisplayLink(String displayLink) {
		this.displayLink = displayLink;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public String getHtmlSnippet() {
		return htmlSnippet;
	}
	public void setHtmlSnippet(String htmlSnippet) {
		this.htmlSnippet = htmlSnippet;
	}
	public String getCacheId() {
		return cacheId;
	}
	public void setCacheId(String cacheId) {
		this.cacheId = cacheId;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public String getFormattedUrl() {
		return formattedUrl;
	}
	public void setFormattedUrl(String formattedUrl) {
		this.formattedUrl = formattedUrl;
	}
	public String getHtmlFormattedUrl() {
		return htmlFormattedUrl;
	}
	public void setHtmlFormattedUrl(String htmlFormattedUrl) {
		this.htmlFormattedUrl = htmlFormattedUrl;
	}
	
	private String title;
	private String htmlTitle;
	private String link;
	private String displayLink;
	private String snippet;
	private String htmlSnippet;
	private String cacheId;
	private String mime;
	private String formattedUrl;
	private String htmlFormattedUrl;
	private Map<Object,Object> pagemap;
	public Map<Object, Object> getPagemap() {
		return pagemap;
	}
	public void setPagemap(Map<Object, Object> pagemap) {
		this.pagemap = pagemap;
	}
}
