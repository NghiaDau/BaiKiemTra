package org.example.nghia.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "roll_name",  nullable = false)
    private String rollname;
    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();
}
