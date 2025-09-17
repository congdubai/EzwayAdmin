package com.infoplus.ezway.EzwayAdmin.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    SYSTEM_READ("system:read"),
    SYSTEM_UPDATE("system:update"),
    SYSTEM_CREATE("system:create"),
    SYSTEM_DELETE("system:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete"),
    STAFF_READ("staff:read"),
    STAFF_UPDATE("staff:update"),
    STAFF_CREATE("staff:create"),
    STAFF_DELETE("staff:delete");

    private final String permission;
}
