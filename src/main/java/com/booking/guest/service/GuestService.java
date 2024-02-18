package com.booking.guest.service;

import com.booking.guest.dto.GuestDTO;
import com.booking.guest.model.Guest;
import com.booking.guest.repo.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public List<Guest> getAllGuestsByCountry(String country) {
        return guestRepository.findByCountry(country);
    }

    public Optional<Guest> getGuestsById(long Id) {
        return guestRepository.findById(Id);
    }

    public Guest createGuest(GuestDTO guest) {
        Guest _guest = guestRepository
                .save(new Guest(guest.getName(), guest.getSurname(),
                        guest.getEmailAddress(), guest.getCountry(), false));
        return _guest;
    }

    public Optional<Guest> updateGuest(long id, GuestDTO guest) {
        Optional<Guest> guestExist = getGuestsById(id);

        if (guestExist.isPresent()) {
            Guest _guest = guestExist.get();
            _guest.setName(guest.getName());
            _guest.setSurname(guest.getSurname());
            _guest.setEmailAddress(guest.getEmailAddress());
            _guest.setCountry(guest.getCountry());
            _guest.setBooked(guest.isBooked());
            return Optional.of(_guest);
        }

        return Optional.empty();
    }

    public void deleteGuest(long id){
        guestRepository.deleteById(id);
    }
   public List<Guest> findByBooked(){
       return guestRepository.findByBooked(true);
   }

}
