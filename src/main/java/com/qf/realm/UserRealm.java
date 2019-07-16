package com.qf.realm;

import com.qf.service.LeaveService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        String uname = (String) principalCollection.getPrimaryPrincipal();
        List<String> roleList = leaveService.getRoleList(uname);
        Set<String> permissions = new HashSet<>();
        Set<String> roles = new HashSet<>();
        for (String s : roleList) {
            roles.add(s);
            List<String> permissionList = leaveService.getPermissionList(s);

            for (String s1 : permissionList) {
                permissions.add(s1);
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String uname = (String) authenticationToken.getPrincipal();

        String password = leaveService.getPasswordByUname(uname);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(uname, password, "UserRealm");

        return authenticationInfo;
    }
}
