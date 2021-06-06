package com.lamzone.Mareu.meeting;

import com.lamzone.Mareu.meeting.participant.Participant;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEETING_ID")
    private Long meetingId;

    @Column(name = "TIME")
    private LocalDateTime time;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "DURATION")
    private int duration;

    @OneToMany(mappedBy = "meeting")
    private List<Participant> participants;
}
