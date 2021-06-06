package com.lamzone.Mareu.meeting.participant;

import com.lamzone.Mareu.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantServiceImpl implements ParticipantService{

    private final ParticipantRepository participantRepository;

    @Override
    public Participant newParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public void deleteParticipant(Long id) {
        Participant participant = participantRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Participant.class, "participantId", id.toString()));
    }

    @Override
    public List<Participant> allParticipants() {
        return participantRepository.findAll();
    }

    @Override
    public Participant one(Long id) {
        Participant participant = participantRepository
                .findById(id)
                .orElseThrow(() ->  new EntityNotFoundException(Participant.class, "participantId", id.toString()));
        return participant;
    }
}
