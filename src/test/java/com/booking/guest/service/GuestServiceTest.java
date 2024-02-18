package com.booking.guest.service;

import com.booking.guest.dto.GuestDTO;
import com.booking.guest.model.Guest;
import com.booking.guest.repo.GuestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GuestServiceTest {

    @Mock
    private GuestRepository guestRepository;

    @InjectMocks
    private GuestService guestService;

    @Test
    public void getAllGuestsTest() {


        Guest guest1 = new Guest("guest1", "gh", "guest1@gmail.com", "SA", true);
        Guest guest2 = new Guest("guest2", "sa", "guest2@gmail.com", "Kenya", false);

        List<Guest> mockGuests = Arrays.asList(guest1, guest2);

        when(guestRepository.findAll()).thenReturn(mockGuests);

        List<Guest> result = guestService.getAllGuests();

        assertEquals(mockGuests, result);
    }

    @Test
    public void updateGuestNotFoundTest() {
        when(guestRepository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Guest> result = guestService.updateGuest(1L, new GuestDTO());

        assertFalse(result.isPresent());
    }

    @Test
    public void updateGuestFoundTest() {
        Guest existingGuest = new Guest("guest1", "gh", "guest1@gmail.com", "SA", true);

        when(guestRepository.findById(anyLong())).thenReturn(Optional.of(existingGuest));

        Optional<Guest> result = guestService.updateGuest(1L, new GuestDTO("guest1", "Hurt", "guest1@gmail.com", "USA", true));

        assertTrue(result.isPresent());
    }


    @Test
    public void createGuestTest() {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setName("Lulu");
        guestDTO.setSurname("Xala");
        guestDTO.setEmailAddress("lulu.xalae@gmail.com");
        guestDTO.setCountry("Mzansi");
        guestDTO.setBooked(false);

        when(guestRepository.save(any(Guest.class))).thenAnswer(invocation -> {
            Guest savedGuest = invocation.getArgument(0);
            savedGuest.setId(1L);
            return savedGuest;
        });

        Guest result = guestService.createGuest(guestDTO);

        assertNotNull(result);
        assertEquals("Lulu", result.getName());
        assertEquals("Xala", result.getSurname());
        assertEquals("lulu.xalae@gmail.com", result.getEmailAddress());
        assertEquals("Mzansi", result.getCountry());
        assertFalse(result.isBooked());
        assertNotNull(result.getId());

        verify(guestRepository, times(1)).save(any(Guest.class));
    }


}