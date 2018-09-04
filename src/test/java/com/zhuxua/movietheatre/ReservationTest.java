package com.zhuxua.movietheatre;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    private static Reservation reservation;
    @BeforeAll
    static void setUp() {
        reservation = new Reservation("R0001", 2);
    }

    @Test
    void getId() {
        assertEquals("R0001", reservation.getId());
    }

    @Test
    void getNumSeats() {
        assertEquals(2, reservation.getNumSeats());
    }

}