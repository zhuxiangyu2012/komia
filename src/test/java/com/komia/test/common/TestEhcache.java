package com.komia.test.common;

import org.junit.Test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEhcache {
	@Test
	public void testEhcache() {
		//创建缓存管理器
		CacheManager cacheManager = CacheManager.create();
		//获取缓存
		Cache cache = cacheManager.getCache("helloworld");
		
		String key = "greeting";
		Element greeting = new Element(key,"Hello, world !");
		cache.put(greeting);
		
		Element getGreeting = cache.get(key);
		System.out.println(getGreeting.getObjectValue());
		
	}
}
