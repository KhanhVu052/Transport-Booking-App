package com.khanhvu.booking_system.repository;

import com.khanhvu.booking_system.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken,String> {
}
