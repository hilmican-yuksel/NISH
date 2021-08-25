package com.example.demo.dto;

import com.example.demo.entity.Dosya;
import lombok.Data;

import java.util.List;

@Data
public class MusteriDto
{
    private Long id;

    private String adi;

    private String soyadi;

    private List<String> dosyalar;
}
