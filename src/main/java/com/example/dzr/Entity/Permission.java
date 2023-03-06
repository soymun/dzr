package com.example.dzr.Entity;

public enum Permission {
    Commuter("Commuter"),  Guide("Guide"), ADMIN("ADMIN");
    final String permission;

    Permission(String commuter) {
        permission = commuter;
    }

    public String getPermission() {
        return permission;
    }
}
