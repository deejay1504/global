package com.global.web.utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.global.web.model.RssFeedItem;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Component
public class RssHelper {

	public List<RssFeedItem> readRss(String rssFeed) {

		List<RssFeedItem> feedItems = new ArrayList<RssFeedItem>();
		try {
			URL url  = new URL(Constants.Url.RSS_FEED);
			XmlReader reader = null;
		 
	    	reader = new XmlReader(url);
	    	SyndFeed feed = new SyndFeedInput().build(reader);
	
	    	feedItems = feed.getEntries()
	    			    .stream()
	    			    .map(f -> new RssFeedItem(f.getTitle(), f.getDescription().getValue(), 
	    			    	 f.getEnclosures().get(0).getUrl(), f.getPublishedDate()))
	    			    .sorted()
	    			    .collect(Collectors.toList());
	    	reader.close();
	    } catch (IllegalArgumentException | IOException | FeedException e) {
	    	throw new RuntimeException("Error getting feed from " + Constants.Url.RSS_FEED, e);
	    }
		return feedItems;
	}
	
	public List<RssFeedItem> readAlternateRss(String rssFeed) {

		List<RssFeedItem> feedItems = new ArrayList<RssFeedItem>();
		try {
			URL url  = new URL(Constants.Url.RSS_FEED);
			XmlReader reader = null;
		 
	    	reader = new XmlReader(url);
	    	SyndFeed feed = new SyndFeedInput().build(reader);
	
	    	boolean readEntry = true;
	    	for (SyndEntry syndEntry : feed.getEntries()) {
	    		if (readEntry) {
	    			RssFeedItem rssFeedItem = 
	    				new RssFeedItem(syndEntry.getTitle(), syndEntry.getDescription().getValue(), 
	    					syndEntry.getEnclosures().get(0).getUrl(), syndEntry.getPublishedDate());
	    			feedItems.add(rssFeedItem);
	    			readEntry = false;
	    		} else {
	    			readEntry = true;
	    		}
			}
	    	Collections.sort(feedItems);
	    	reader.close();
	    } catch (IllegalArgumentException | IOException | FeedException e) {
	    	throw new RuntimeException("Error getting feed from " + Constants.Url.RSS_FEED, e);
	    }
		return feedItems;
	}

	public RssFeedItem getResource(String rssFeed, String id) {
		RssFeedItem feedItem = null;
		try {
			URL url  = new URL(Constants.Url.RSS_FEED);
			XmlReader reader = null;
			
			reader = new XmlReader(url);
			SyndFeed feed = new SyndFeedInput().build(reader);
			
			SyndEntry syndEntry = feed.getEntries()
					.stream()
					.filter(f -> id.equals(f.getUri()))	
					.findAny()
					.orElse(null);
			if (syndEntry != null) {
				feedItem = new RssFeedItem(syndEntry.getTitle(), syndEntry.getDescription().getValue(), 
						syndEntry.getEnclosures().get(0).getUrl(), syndEntry.getPublishedDate());
			}
			reader.close();
		} catch (IllegalArgumentException | IOException | FeedException e) {
			throw new RuntimeException("Error getting feed from " + Constants.Url.RSS_FEED, e);
		}
		return feedItem;
	}

	public RssFeedItem getLatestResource(String rssFeed) {
		List<RssFeedItem> readRss = readRss(rssFeed);
		return readRss.get(0);
	}

}

