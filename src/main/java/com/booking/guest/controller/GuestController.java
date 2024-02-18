package com.booking.guest.controller;

import com.booking.guest.dto.GuestDTO;
import com.booking.guest.model.Guest;
import com.booking.guest.repo.GuestRepository;
import com.booking.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    GuestService guestService;


    @GetMapping("/guests/getAll")
    public ResponseEntity<List<Guest>> getAllGuests() {
        try {
           List<Guest> guests= guestService.getAllGuests();
            return new ResponseEntity<>(guests, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/guests")
    public ResponseEntity<List<Guest>> getGuestsByCountry(@RequestParam(required = true) String country) {
        try {
            List<Guest> tutorials = new ArrayList<>();
            tutorials.addAll(guestService.getAllGuestsByCountry(country));

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/guests/{id}")
    public ResponseEntity<Guest> getGuestsById(@PathVariable("id") long id) {
        Optional<Guest> _guest = guestService.getGuestsById(id);

        return _guest.map(guest -> new ResponseEntity<>(guest, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/guests")
    public ResponseEntity<Guest> createGuest(@RequestBody GuestDTO guest) {
        try {
            Guest _guest = guestService
                    .createGuest(guest);
            return new ResponseEntity<>(_guest, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/guests/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable("id") long id, @RequestBody GuestDTO guest) {

        if (guestService.updateGuest(id,guest).isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/guests/{id}")
    public ResponseEntity<HttpStatus> deleteGuest(@PathVariable("id") long id) {
        try {
                 guestService.deleteGuest(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/guests/booked")
    public ResponseEntity<List<Guest>> findByBooked() {
        try {
            List<Guest> guestList=guestService.findByBooked();
            if (guestList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(guestList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
