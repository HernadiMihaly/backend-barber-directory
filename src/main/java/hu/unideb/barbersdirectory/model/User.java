package hu.unideb.barbersdirectory.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, length = 45)
    private String email;
    @Column(length = 15)
    private String firstName;
    @Column(length = 15)
    private String lastName;
    @Column(length = 100)
    private String password;

    @OneToMany(mappedBy="user")
    private Set<Barber> barbersSet;
}