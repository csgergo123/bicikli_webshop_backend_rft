package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    @Size(min = 0, max = 255)
    private String email;

    @Column(nullable = false)
    @Size(min = 0, max = 255)
    private String jelszo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Role {
        USER, ADMIN, MODERATOR
    }

    @Column(nullable = false)
    @Size(min = 0, max = 255)
    private String keresztnev;

    @Column(nullable = false)
    @Size(min = 0, max = 255)
    private String vezeteknev;

    @Column(nullable = false)
    @Size(min = 0, max = 255)
    private String telefonszam;

    @Column(nullable = false)
    @Size(min = 0, max = 255)
    private String orszag;

    @Column(nullable = false)
    @Size(min = 0, max = 255)
    private String varos;

    @Column(nullable = false)
    @Size(min = 0, max = 20)
    private String iranyitoszam;

    @Column(nullable = false)
    @Size(min = 0, max = 255)
    private String utca;

    @Column(nullable = false)
    @Size(min = 0, max = 20)
    private String hazszam;

    @Column(nullable = false)
    @Size(min = 0, max = 20)
    private String emelet;

    @Column(nullable = false)
    @Size(min = 0, max = 20)
    private String ajto;

    @OneToMany(mappedBy = "user")
    private List<Rendeles> rendelesek;
    
}
