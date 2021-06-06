package com.lamzone.Mareu.room;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    private Long roomId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_FREE")
    private boolean isFree;
}
