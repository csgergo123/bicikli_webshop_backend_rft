package com.example.demo.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Table(name="rendeles_tetelek")
public class RendelesTetel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private Integer mennyiseg;

    @Column(name = "netto_ar")
    @NotNull
    private Float nettoAr;

    @Column()
    @NotNull
    private Integer afa;

    @ManyToOne
    @JoinColumn(name="rendeles_id")
    private Rendeles rendeles;

    @ManyToOne
    @JoinColumn(name="bicikli_id")
    private Bicikli bicikli;

}
