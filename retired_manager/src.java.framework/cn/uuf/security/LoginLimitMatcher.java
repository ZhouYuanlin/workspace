package cn.uuf.security;

import java.util.concurrent.atomic.AtomicInteger;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 登录次数限制
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date Apr 4, 2014
 */
public class LoginLimitMatcher extends SimpleCredentialsMatcher {

	private Ehcache passwordRetryCache;

	public LoginLimitMatcher() {
		CacheManager cacheManager = CacheManager.create(CacheManager.class
				.getClassLoader().getResource("spring/ehcache.xml"));
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		Element element = passwordRetryCache.get(username);
		if (element == null) {
			element = new Element(username, new AtomicInteger(0));
			passwordRetryCache.put(element);
		}
		AtomicInteger retryCount = (AtomicInteger) element.getObjectValue();
		if (retryCount.incrementAndGet() > 4) {
			throw new ExcessiveAttemptsException();
		}
		boolean matches = false;
		try{
			matches = super.doCredentialsMatch(token, info);
			if (matches) {
				passwordRetryCache.remove(username);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return matches;
	}
}
