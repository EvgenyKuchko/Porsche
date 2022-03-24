package com.project.porsche.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails, EntityObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 2, max = 15, message = "first name must be 2 or more characters")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 20, message = "last name must be 2 or more characters")
    private String lastName;
    @NotNull
    @Min(value = 18, message = "age cannot be less than 18")
    private int age;
    @NotNull
    @Size(min = 5, message = "login name must be 5 or more characters")
    private String login;
    @NotNull
    @Size(min = 5, message = "password name must be 5 or more characters")
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Deal> deals;

    @ElementCollection(targetClass = RoleUser.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleUser> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}