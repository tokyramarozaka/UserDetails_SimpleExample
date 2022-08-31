package school.hei.helloworldapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import school.hei.helloworldapi.security.model.Role;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The user table is used to authenticate users unto the app.
 * To separate the data structure and its role in Spring,
 * we separated it from the AppUserDetails in the security.model package
 */
@Entity
@Table(name = "\"user\"")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "boolean default true")
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;
}
