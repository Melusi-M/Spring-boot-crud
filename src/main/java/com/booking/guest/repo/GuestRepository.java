package com.booking.guest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booking.guest.model.Guest;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long>{

    void deleteById(long id);
    List<Guest> findByBooked(boolean booked);

    List<Guest> findByCountry(String country);
}

