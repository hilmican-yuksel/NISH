package com.example.demo.service.impl;

import com.example.demo.dto.MusteriDto;
import com.example.demo.entity.Dosya;
import com.example.demo.entity.Musteri;
import com.example.demo.repo.DosyaRepository;
import com.example.demo.repo.MusteriRepository;
import com.example.demo.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusteriServiceImpl implements MusteriService
{
    private final MusteriRepository musteriRepository;
    private final DosyaRepository dosyaRepository;

    @Override
    @Transactional
    public MusteriDto save(MusteriDto musteriDto)
    {
        //Assert.isNull(musteriDto.getAdi(),"Ad Alanı Zorunludur!");
        Musteri musteri = new Musteri();
        musteri.setAdi(musteriDto.getAdi());
        musteri.setSoyadi(musteriDto.getSoyadi());
        final Musteri musteriDb = musteriRepository.save(musteri);
/*        List<Dosya> liste = new ArrayList<>();
        musteriDto.getDosyalar().forEach(item->{
            Dosya dosya = new Dosya();
            dosya.setDosya(item);
            dosya.setAktif(true);
            dosya.setMusteri(musteriDb);
            liste.add(dosya);
        });
        dosyaRepository.saveAll(liste);*/
        musteriDto.setId(musteriDb.getId());
        return musteriDto;
    }

    @Override
    public void delete(@PathVariable Long id) {
        Musteri musteri = musteriRepository.getById(id);
        musteriRepository.delete(musteri);
    }

    @Override
    public void deleteDosya(Long id) {
        Dosya dosya = dosyaRepository.getById(id);
        dosyaRepository.delete(dosya);
    }

    @Override
    public List<MusteriDto> getAll() {
        List<Musteri> musteriler = musteriRepository.findAll();
        List<MusteriDto> musteriDtos = new ArrayList<>();

        musteriler.forEach(it ->{
            MusteriDto musteriDto = new MusteriDto();
            musteriDto.setId(it.getId());
            musteriDto.setAdi(it.getAdi());
            musteriDto.setSoyadi(it.getSoyadi());
/*            musteriDto.setDosyalar(it.getDosyalari().stream().map(Dosya::getDosya)
                    .collect(Collectors.toList()));*/
            musteriDtos.add(musteriDto);
        });
        return musteriDtos;
    }

    @Override
    public void uploadDosya(MultipartFile file,Long musteri_id) throws IllegalStateException, IOException {
        file.transferTo(new File("/Users/hilmicanyuksel/Desktop/ASD/upload/"+file.getOriginalFilename()));
    }
}
