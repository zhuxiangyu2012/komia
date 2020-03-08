package com.komia.test.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.komia.test.base.TestBase;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEhcache extends TestBase{
	@Autowired
	private EhCacheCacheManager springEhcacheManager;
	
	@Test
	public void testAddEhcache() {
		Cache cache = springEhcacheManager.getCacheManager().getCache("helloworld");
		
		String key = "greeting";
		Element greeting = new Element(key,"Hello, world !!");
		cache.put(greeting);
	}
	
	@Test
	public void testGetEhcache() {
		Cache cache = springEhcacheManager.getCacheManager().getCache("helloworld");
		
		String key = "greeting";
		Element getGreeting = cache.get(key);
		System.out.println(getGreeting.getObjectValue());
	}
}
