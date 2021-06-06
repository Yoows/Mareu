package com.lamzone.Mareu.room;

import com.lamzone.Mareu.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService  {
    private final RoomRepository roomRepository;
}
