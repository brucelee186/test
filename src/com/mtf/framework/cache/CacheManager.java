package com.mtf.framework.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CacheManager {

	public static final String KEY_BOARDCAST = "cache_boardcast";
	public static final String KEY_RESOURCE = "cache_resource";
	public static final String KEY_CURRENCY = "cache_currency";
	public static final String KEY_CUSTOMER = "cache_customer";
	public static final String KEY_SUPPLIER = "cache_supplier";
	public static final String KEY_DIVISION = "cache_division";
	public static final String KEY_FABRIC = "cache_fabric";
	public static final String KEY_TRIM = "cache_trim";
	public static final String KEY_FABRICARTICLENO = "cache_fabricarticleno";
	public static final String KEY_TRIMARTICLENO = "cache_trimarticleno";
	public static final String KEY_SEASON = "cache_season";
	public static final String KEY_COLOR = "cache_color";
	public static final String KEY_PRODUCTTYPE = "cache_producttype";
	public static final String KEY_PRODUCTGENDER = "cache_productgender";
	public static final String KEY_PRODUCTKIND = "cache_productkind";
	public static final String KEY_SAMPLETYPE = "cache_sampletype";
	public static final String KEY_EQUIPMENT = "cache_equipment";
	public static final String KEY_UNIT = "cache_unit";
	public static final String KEY_SIZERANGE = "cache_sizerange";
	public static final String KEY_SIZE = "cache_size";
	public static final String KEY_HTS = "cache_hts";
	public static final String KEY_PLAIDSTRIP = "cache_plaidstrip";
	public static final String KEY_PAYMENTTERMS = "cache_paymentterms";
	public static final String KEY_WASHINGTYPE = "cache_washingtype";
	public static final String KEY_DESTINATION = "cache_destination";
	public static final String KEY_TRADINGENTITY = "cache_tradingentity";
	public static final String KEY_AUDITSTANDARD = "cache_auditstandard";
	public static final String KEY_USER = "cache_user";
	
	
	private static HashMap<String, Cache>	cacheMap	= new HashMap<>();

	private CacheManager() {
		super();
	}

	/**
	 * 获取缓存
	 * @param key
	 * @return Cache or NULL
	 */
	public synchronized static Cache get(String key) {
		Cache cache = cacheMap.get(key);
		if (cache == null) {
			return null;
		}
		if (expired(cache)) { // 调用判断是否终止方法
			cacheMap.remove(key);
			return null;
		}
		return cache;
	}

	/**
	 * 清除所有缓存
	 */
	public synchronized static void clearAll() {
		cacheMap.clear();
	}

	/**
	 * 清除指定的缓存
	 * @param key
	 */
	public synchronized static void clear(String key) {
		cacheMap.remove(key);
	}

	/**
	 * 清除过期的缓存
	 */
	public synchronized static void clean() {
		ArrayList<String> keys = getAllkey();
		for (String key : keys) {
			Cache cache = cacheMap.get(key);
			if (expired(cache)) {
				cacheMap.remove(key);
			}
		}
	}

	/**
	 * 添加缓存，如果存在则覆盖
	 * @param key
	 * @param obj
	 */
	public synchronized static void add(String key, Cache obj) {
		cacheMap.put(key, obj);
	}

	/**
	 * 添加缓存，如果存在则覆盖
	 * @param key
	 * @param obj
	 * @param dt
	 */
	public synchronized static void add(String key, Cache obj, long dt) {
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setTimeOut(dt + System.currentTimeMillis()); // 设置多久后更新缓存
		cache.setValue(obj);
		cacheMap.put(key, cache);
	}

	/**
	 * 判断缓存是否过期
	 * @param cache
	 * @return
	 */
	private synchronized static boolean expired(Cache cache) {
		if (null == cache) { // 传入的缓存不存在
			return true;
		}
		
		long cacheDt = cache.getTimeOut(); // 缓存内的过期毫秒数
		if (0 == cacheDt) {
			return false;
		}
		long nowDt = System.currentTimeMillis(); // 系统当前的毫秒数
		if (cacheDt > nowDt) { // 过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE
			return false;
		} else { // 大于过期时间 即过期
			return true;
		}
	}

	/**
	 * 获取缓存中的大小
	 * @return
	 */
	public synchronized static int getSize() {
		return cacheMap.size();
	}

	/**
	 * 获取缓存对象中的所有键值名称
	 * @return
	 */
	public synchronized static ArrayList<String> getAllkey() {
		ArrayList<String> a = new ArrayList<>();
		Iterator<Entry<String, Cache>> i = cacheMap.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, Cache> entry = i.next();
			a.add(entry.getKey());
		}
		return a;
	}
}
