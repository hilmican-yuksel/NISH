package com.example.demo.repo;

import com.example.demo.entity.Dosya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DosyaRepository extends JpaRepository<Dosya, Long> {
}
