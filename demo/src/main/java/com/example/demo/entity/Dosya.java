package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import javax.persistence.GenerationType;

@Entity
@Table(name = "musteri_dosya",schema = "javadb",catalog = "")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Dosya implements Serializable
{
    //public JFileChooser chooser = new JFileChooser();

    @Id
    @SequenceGenerator(name = "seq_musteri_dosya", allocationSize = 1)
    @GeneratedValue(generator = "seq_musteri_dosya", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "dosya")
    private File dosya;

    @Column(name = "aktif")
    private boolean aktif;

    @ManyToOne
    @JoinColumn(name = "musteri_dosya_id")
    private Musteri musteri;

}
