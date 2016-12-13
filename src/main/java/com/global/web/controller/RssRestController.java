package com.global.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.global.web.model.RssFeedItem;
import com.global.web.service.RssService;
import com.global.web.utils.Constants;

@RestController
public class RssRestController {
	@Autowired
	RssService rssService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<RssFeedItem> getAllResources() {
		return rssService.getAllResources(Constants.Url.RSS_FEED);
	}

	@RequestMapping(value = "/alternate", method = RequestMethod.GET)
	public List<RssFeedItem> getAlternateResources() {

		return rssService.getAlternateResources(Constants.Url.RSS_FEED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RssFeedItem getFeedById(@PathVariable("id") String id) {
		return rssService.getResource(Constants.Url.RSS_FEED, id);
	}

	@RequestMapping(value = "/latest", method = RequestMethod.GET)
	public RssFeedItem getLatestResource() {
		return rssService.getLatestResource(Constants.Url.RSS_FEED);
	}
	
}
