package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
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

    @Column(name = "sebesseg_elol")
    @NotNull
    private Integer sebessegElol;

    @Column(name = "sebesseg_hatul")
    @NotNull
    private Integer sebessegHatul;

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
    private Integer keszlet;

    @Column(name = "netto_ar")
    @NotNull
    private Integer nettoAr;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
