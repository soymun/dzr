package com.example.dzr.Entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.Commuter)),Conductor(Set.of(Permission.Guide,Permission.Commuter)), ADMIN(Set.of(Permission.Commuter, Permission.Guide, Permission.ADMIN));

    private final Set<Permission> permissions;
    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthority(){
        return permissions.stream().map(n -> new SimpleGrantedAuthority(n.getPermission())).collect(Collectors.toSet());
    }
}
