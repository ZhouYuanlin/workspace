package cn.uuf.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Resource;
import cn.uuf.domain.Role;
import cn.uuf.ltxxt.system.permission.service.AccountService;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
public class LtxRealm extends AuthorizingRealm{

	private final Log logger = LogFactory.getLog(LtxRealm.class);
	
	@Autowired
	private AccountService accountService;

	/**
	 * <p>授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.</p>
	 * <p>该方法主要执行以下操作:</p>
	 * <ol>
	 *	<li>检查提交的进行认证的令牌信息</li>
	 *	<li>根据令牌信息从数据源(通常为数据库)中获取用户信息</li>
	 *	<li>对用户信息进行匹配验证。</li>
	 *	<li>验证通过将返回一个封装了用户信息的AuthenticationInfo实例。</li>
	 *	<li>验证失败则抛出AuthenticationException异常信息。 </li>
	 * </ol>
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		@SuppressWarnings("unused")
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Account account = null;
		try{
			account = accountService.queryByLoginName(token.getUsername());
		}catch(Exception e){
			e.printStackTrace();
		}
		if(account != null)
			return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
		else
			return null;
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Account account = (Account) principals.fromRealm(getName()).iterator().next();
		if(logger.isDebugEnabled())
			logger.debug("用户名 - " + account.getUsername());
		SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
		try{
//			account = accountService.queryByLoginName(account.getUsername());
			// 角色&角色权限
			for(Role role : account.getRoles()) {
				authInfo.addRole(role.getScope());
				for(Resource r : role.getResources()){
					if(r.getAction() != null){
						if(Constants.ENABLE.equals(r.getStatus()))
							authInfo.addStringPermission(r.getAction());
					}
				}
			}
			authInfo.addStringPermission("/modifypass");
			authInfo.addStringPermission("/information");
			authInfo.addStringPermission("/avator");
		}catch(Exception e){
			e.printStackTrace();
		}
		return authInfo;
	}
}

