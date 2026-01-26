package com.adamidis.learning.presencesystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private Role authority;

    public Authority() {
    }

    public Authority(Role authority) {
        this.authority = authority;
    }

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
