package com.example.demo.service;

import com.example.demo.dto.MusteriDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MusteriService
{
    MusteriDto save(MusteriDto musteriDto);

    void delete(Long id);

    void deleteDosya(Long id);

    List<MusteriDto> getAll();

    void uploadDosya(MultipartFile file,Long musteri_id)throws IllegalStateException, IOException;

}
