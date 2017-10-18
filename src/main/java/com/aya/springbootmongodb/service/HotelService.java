package com.aya.springbootmongodb.service;

import com.aya.springbootmongodb.domain.Address;
import com.aya.springbootmongodb.domain.Hotel;
import com.aya.springbootmongodb.domain.Review;
import com.aya.springbootmongodb.persistance.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HotelService implements CommandLineRunner {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
            "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Marry", 7, true)
                )
        );

        Hotel ibis = new Hotel(
            "Ibis",
                90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotel sofitel = new Hotel(
            "Sofitel",
                200,
                new Address("Rome", "Italy"),
                new ArrayList<>()
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        // add our hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.save(hotels);
    }
}
