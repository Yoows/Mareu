package com.lamzone.Mareu.meeting.participant;

import java.util.List;

public interface ParticipantService {
    Participant newParticipant(Participant participant);
    void deleteParticipant(Long id);
    List<Participant> allParticipants();
    Participant one(Long id);
}
