package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    private String email;

    @Column(nullable = false)
    private String jelszo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Role {
        USER, ADMIN, MODERATOR
    }

    @Column(nullable = false)
    private String keresztnev;

    @Column(nullable = false)
    private String vezeteknev;

    @Column(nullable = false)
    private String telefonszam;

    @Column(nullable = false)
    private String orszag;

    @Column(nullable = false)
    private String varos;

    @Column(nullable = false)
    private String iranyitoszam;

    @Column(nullable = false)
    private String utca;

    @Column(nullable = false)
    private String hazszam;

    @Column(nullable = false)
    private String emelet;

    @Column(nullable = false)
    private String ajto;
    
}
