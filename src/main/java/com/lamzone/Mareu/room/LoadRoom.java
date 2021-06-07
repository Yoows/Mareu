package com.lamzone.Mareu.room;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadRoom {
    @Bean
    CommandLineRunner commandLineRunner(RoomRepository repository){
        return args -> {
            List<Room> rooms = List.of(
                    new Room("Mario", true),
                    new Room("Luigi", true),
                    new Room("Peach", true),
                    new Room("Toad", true),
                    new Room("Bowser", true),
                    new Room("Wario", true),
                    new Room("Daisy", true),
                    new Room("Donkey Kong", true),
                    new Room("Yoshi", true),
                    new Room("Koopa", true)
            );
            repository.saveAll(rooms);
        };
    }
}
