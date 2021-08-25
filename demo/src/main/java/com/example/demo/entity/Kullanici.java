package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "kullanici",schema = "javadb",catalog = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Kullanici
{
    @Id
    @SequenceGenerator(name = "seq_kullanici", allocationSize = 1)
    @GeneratedValue(generator = "kullanici", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 100 ,name = "adi", nullable = false)
    private String adi;

    @Column(length = 100 ,name = "soyadi")
    private String soyadi;
}
