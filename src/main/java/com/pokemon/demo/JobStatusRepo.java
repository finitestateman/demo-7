package com.pokemon.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobStatusRepo extends JpaRepository<JobStatus, Long> {
}
