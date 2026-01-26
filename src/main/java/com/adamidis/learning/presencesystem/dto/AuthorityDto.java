package com.adamidis.learning.presencesystem.dto;

import com.adamidis.learning.presencesystem.model.Role;

public class AuthorityDto {

    private Integer id;
    private Role authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role authority) {
        this.authority = authority;
    }
}
