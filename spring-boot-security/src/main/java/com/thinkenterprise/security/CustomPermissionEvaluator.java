package com.thinkenterprise.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    private static final Map<String, List<String>> testPermissionMap;

    static {
        Map<String, List<String>> map = new HashMap<>();
        ArrayList<String> things = new ArrayList<>();
        things.add("com.thinkenterprise.domain.route.Route");
        things.add("com.thinkenterprise.domain.route.Flight");
        map.put("212389921", things);
        testPermissionMap = Collections.unmodifiableMap(map);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return authorize((User) authentication.getPrincipal(), (String) targetDomainObject);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }

    private boolean authorize(User user, String targetDomainObject) {
        boolean allowed = false;
        if (testPermissionMap.get(user.getUsername()) != null && testPermissionMap.get(user.getUsername()).contains(targetDomainObject)) {
            allowed = true;
        }
        return allowed;
    }
}
