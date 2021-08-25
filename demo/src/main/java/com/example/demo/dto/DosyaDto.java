package com.example.demo.dto;

import com.example.demo.entity.Musteri;
import lombok.Data;

import java.io.File;

@Data
public class DosyaDto {
    private Long id;

    private File dosya;

    private boolean aktif;

    private Musteri musteri;
}
