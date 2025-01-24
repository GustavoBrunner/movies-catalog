package com.biblioteca.movies.domain;

public enum UserType {
    DEVELOPER("developer",  true),
    CLIENT("client", true);

    private final String id;
    private final boolean hasAdminRights;
    
    
    private UserType(String id, boolean hasAdminRights) {
        this.id = id;
        this.hasAdminRights = hasAdminRights;
    }
    public String getId() {
        return id;
    }
    public boolean isHasAdminRights() {
        return hasAdminRights;
    }
}
