package com.qf.realm;

import com.qf.service.LeaveService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: liu
 * date: 2019/7/16 16:12
 * info :
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LeaveService leaveService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String uname = (String) authenticationToken.getPrincipal();

        String password = leaveService.getPasswordByUname(uname);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(uname, password, "UserRealm");

        return authenticationInfo;
    }
}
