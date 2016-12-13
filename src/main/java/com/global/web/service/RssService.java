package com.global.web.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.global.web.model.RssFeedItem;

@Component
public interface RssService {

	List<RssFeedItem> getAllResources(String rssUrl);

	List<RssFeedItem> getAlternateResources(String rssUrl);

	RssFeedItem getResource(String rssUrl, String id);
	
	RssFeedItem getLatestResource(String rssUrl);

}
