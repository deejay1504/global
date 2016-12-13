package com.global.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.web.model.RssFeedItem;
import com.global.web.utils.RssHelper;

@Service("rssService")
public class RssServiceImpl implements RssService {

	@Autowired
	RssHelper rssHelper;
	
	@Override
	public List<RssFeedItem> getAllResources(String rssUrl) {
		return rssHelper.readRss(rssUrl);
	}

	@Override
	public List<RssFeedItem> getAlternateResources(String rssUrl) {
		return rssHelper.readAlternateRss(rssUrl);
	}

	@Override
	public RssFeedItem getResource(String rssUrl, String id) {
		return rssHelper.getResource(rssUrl, id);
	}

	@Override
	public RssFeedItem getLatestResource(String rssUrl) {
		return rssHelper.getLatestResource(rssUrl);
	}
}
