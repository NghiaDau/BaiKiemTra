package org.example.nghia.requesEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.nghia.entities.Role;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequesUpdateUser {
    private String id;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
}
