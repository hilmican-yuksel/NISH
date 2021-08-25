package com.example.demo.controller;

import com.example.demo.dto.MusteriDto;
import com.example.demo.entity.Musteri;
import com.example.demo.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musteri")
@RequiredArgsConstructor
public class MusteriController
{
    private final MusteriService musteriService;

    @PostMapping
    public ResponseEntity<MusteriDto> kaydet(@RequestBody MusteriDto musteriDto)
    {
        return ResponseEntity.ok(musteriService.save(musteriDto));
    }

    @GetMapping
    public ResponseEntity<List<MusteriDto>> tumunuListele()
    {
        return ResponseEntity.ok(musteriService.getAll());
    }

    @DeleteMapping("/musteri/{id}")
    public void sil(@RequestBody Musteri musteri)
    {
        musteriService.delete(musteri.getId());
    }
}
