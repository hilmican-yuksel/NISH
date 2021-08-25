package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import javax.persistence.GenerationType;

@Entity
@Table(name = "musteri",schema = "javadb",catalog = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Musteri {

    @Id
    @SequenceGenerator(name = "seq_musteri", allocationSize = 1)
    @GeneratedValue(generator = "seq_musteri", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100 ,name = "adi", nullable = false)
    private String adi;

    @Column(length = 100 ,name = "soyadi")
    private String soyadi;

    @OneToMany
    @JoinColumn(name = "musteri_dosya_id")
    private List<Dosya> dosyalari;
}
