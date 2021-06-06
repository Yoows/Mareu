package com.lamzone.Mareu.meeting.participant;

import com.lamzone.Mareu.meeting.Meeting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PARTICIPANT_ID")
    private Long participantId;

    @Column(name = "EMAIl")
    private String email;

    @ManyToOne
    @JoinColumn(name = "MEETING_ID", nullable = false)
    private Meeting meeting;
}
