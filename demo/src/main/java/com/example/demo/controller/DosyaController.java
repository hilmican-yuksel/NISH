package com.example.demo.controller;

import com.example.demo.entity.Musteri;
import com.example.demo.entity.Dosya;
import com.example.demo.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/dosya")
@RestController
@RequiredArgsConstructor
public class DosyaController {
@Autowired

    public final MusteriService musteriService;

    @DeleteMapping("/musteri/{id}")
    public void dosyasil(@RequestBody Dosya dosya)
    {
       musteriService.deleteDosya(dosya.getId());
    }

    @PostMapping
    public void yukle(@RequestParam("file") MultipartFile file, Long musteri_id) throws IllegalStateException, IOException {
        musteriService.uploadDosya(file, musteri_id);
    }
}
