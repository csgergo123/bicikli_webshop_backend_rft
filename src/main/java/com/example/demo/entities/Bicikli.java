package com.example.demo.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Bicikli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String nev;

    @Column
    private String leiras;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipus tipus;

    public enum Tipus {
        VAROSI, TREKKING, ORSZAGUTI, MTB
    }

    @Column
    @NotNull
    private Float meret;

    @Column
    @NotNull
    private int sebesseg_elol;

    @Column
    @NotNull
    private int sebesseg_hatul;

    @Column
    @NotNull
    private String szin;

    @Column
    @NotNull
    private String fek;

    @Column
    @NotNull
    private String teleszkop;

    @Column
    @NotNull
    private String vaz;

    @Column
    @NotNull
    private int keszlet;

    @Column
    @NotNull
    private int netto_ar;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column
    @UpdateTimestamp
    private LocalDateTime updated_at;

}
