package com.fastdash.subscribers.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Users.getAllUsers",
                query = "SELECT us FROM Users us where us.is_deleted = false "
        )
})

@NamedNativeQueries({
        @NamedNativeQuery(
                name = Users.GET_USER_BY_USER_NAME,
                query = "select * from user where user_name = :userName",
                resultClass = Users.class
        )
})


@Entity
@Data
@Table(name = "user")
public class Users extends AbstractBaseEntity {

    public static final String GET_USER_BY_USER_NAME = "Users.getUserByUserName";
    public static final String GET_ALL_USERS = "Users.getAllUsers";

    public Users() {
    }

    public Users(Users user) {
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }

    @Column(name = "business_id")
    private String businessId;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "is_deleted")
    private Boolean is_deleted;

    @Column(name = "picture_id")
    private Long pictureId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})

    private List<Roles> roles;

}
