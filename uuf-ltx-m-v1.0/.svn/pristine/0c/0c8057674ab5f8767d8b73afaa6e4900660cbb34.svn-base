package cn.uuf.stu.framework.shiro;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.uuf.stu.entity.framework.WAccount;
import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.framework.common.SystemParamter;
import cn.uuf.stu.framework.common.SystemParamter.AccountLockType;
import cn.uuf.stu.framework.service.IAccountService;
import cn.uuf.stu.framework.service.ICaptchaService;
import cn.uuf.stu.framework.util.SystemParamterUtils;





/**
* 权限认证
* @ClassName: AuthenticationRealm 
* @author tangpeng
* @date 2015年8月4日 下午2:18:01 
*/
public class AuthenticationRealm extends AuthorizingRealm {
	
	@Resource(name="captchaService")
	private ICaptchaService captchaService;
	
	@Resource(name="accountService")
	private IAccountService accountService;
	
	/**
	 * 获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		SystemCustomToken systemCustomToken = (SystemCustomToken) token;
		String username = systemCustomToken.getUsername();
		String password = new String(systemCustomToken.getPassword());
		String captchaId = systemCustomToken.getCaptchaId();
		String captcha = systemCustomToken.getCaptcha();
		String ip = systemCustomToken.getHost();
//		if(!captchaService.isValid(CaptchaType.adminLogin, captchaId, captcha)){
//			throw new UnsupportedTokenException();
//		}
		if(StringUtils.isNotEmpty(username)&&StringUtils.isNotEmpty(password)){
			WAccount account = accountService.getUniqueEntity("username", username);
			if(account==null){
				throw new UnknownAccountException();
			}
			if(!account.getIsEnabled()){
				throw new DisabledAccountException();
			}
			SystemParamter systemParamter = SystemParamterUtils.get();
			if(account.getIsLocked()){
				if(ArrayUtils.contains(systemParamter.getAccountLockTypes(), AccountLockType.admin)){
					int accountLockTime = systemParamter.getAccountLockTime();
					if(accountLockTime == 0){
						throw new LockedAccountException();
					}
					Date lockedDate = account.getLockedDate();
					Date unlockDate = DateUtils.addMinutes(lockedDate, accountLockTime);
					if(new Date().after(unlockDate)){
						account.setLoginFailureCount(0);
						account.setIsLocked(false);
						account.setLockedDate(null);
						accountService.update(account);
					}else{
						throw new LockedAccountException();
					}
				} else {
					account.setLoginFailureCount(0);
					account.setIsLocked(false);
					account.setLockedDate(null);
					accountService.update(account);
				}
			}
			if(!DigestUtils.md5Hex(password).equals(account.getPassword())){
				int loginFailureCount = account.getLoginFailureCount()+1;
				if(loginFailureCount>=systemParamter.getAccountLockCount()){
					account.setIsLocked(true);
					account.setLockedDate(new Date());
				}
				account.setLoginFailureCount(loginFailureCount);
				accountService.update(account);
				throw new IncorrectCredentialsException();
			}
			account.setLoginIp(ip);
			account.setLoginDate(new Date());
			account.setLoginFailureCount(0);
			accountService.update(account);
			return new SimpleAuthenticationInfo(new Principal(account.getId(), username,account.getXm()),password,getName());
		}
		throw new UnknownAccountException();
	}
	
	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = (Principal) principals.fromRealm(getName()).iterator().next();
		if(principal != null){
			WAccount account = accountService.load(principal.getId());
			SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
			List<WRole> roles = account.getRoles();
			Iterator<WRole> iterator = roles.iterator();
			while(iterator.hasNext()){
				WRole role = iterator.next();
				authorizationInfo.addRole(role.getRoleName());
				List<cn.uuf.stu.entity.framework.WResource> resoures = role.getResoures();
				if(resoures != null){
					for (cn.uuf.stu.entity.framework.WResource resource : resoures) {
						if(StringUtils.isNotEmpty(resource.getPermissionString())){
							authorizationInfo.addStringPermission(resource.getPermissionString());
						}
					}
				}
			}
			return authorizationInfo;
		}
		return null;
	}
	
}
