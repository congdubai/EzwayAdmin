package com.infoplus.ezway.EzwayAdmin.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.infoplus.ezway.EzwayAdmin.entity.Permission.*;


@Getter
@RequiredArgsConstructor
public enum Role {
    ADMIN(1,
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,

                    MANAGER_READ,
                    MANAGER_UPDATE,
                    MANAGER_DELETE,
                    MANAGER_CREATE,

                    STAFF_CREATE,
                    STAFF_READ,
                    STAFF_UPDATE,
                    STAFF_DELETE
            )
    ),
    SYSTEM(2,
            Set.of(
                    SYSTEM_READ,
                    SYSTEM_UPDATE,
                    SYSTEM_DELETE,
                    SYSTEM_CREATE,

                    STAFF_CREATE,
                    STAFF_READ,
                    STAFF_UPDATE,
                    STAFF_DELETE
            )
    ),

    MANAGER(2,
            Set.of(
                    MANAGER_READ,
                    MANAGER_UPDATE,
                    MANAGER_DELETE,
                    MANAGER_CREATE,

                    STAFF_CREATE,
                    STAFF_READ,
                    STAFF_UPDATE,
                    STAFF_DELETE
            )
    ),
    STAFF(3,
            Set.of(
                    STAFF_READ,
                    STAFF_UPDATE,
                    STAFF_DELETE,
                    STAFF_CREATE
            ));

    private final int level;

    public int getLevel() {
        return level;
    }

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
