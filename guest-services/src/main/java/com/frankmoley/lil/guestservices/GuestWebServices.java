package com.frankmoley.lil.guestservices;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestWebServices {
    private final GuestRepository guestRepository;

    public GuestWebServices(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public Iterable<Guest> getAllGuests() {
        return this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable Long id) throws NotFoundException {
        Optional<Guest> guest = this.guestRepository.findById(id);
        if (guest.isPresent()) {
            return guest.get();
        }
        throw new NotFoundException("Guest not found with id: " + id);
    }
}
