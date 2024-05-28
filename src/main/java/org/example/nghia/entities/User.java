package org.example.nghia.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "username",  nullable = false)
    private String username;
    @Column(name = "password",  nullable = false)
    private String password;
    @Column(name = "email",  nullable = false)
    private String email;
    @Column(name = "firsname",  nullable = false)
    private String firstname;
    @Column(name = "lastname",  nullable = false)
    private String lastname;
    @Column(name = "isdeleted",  nullable = false)
    private boolean isdeleted;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
}

