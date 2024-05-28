package org.example.nghia.requesEntities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.nghia.entities.Role;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequesUser {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private Role role;
}
