package com.lamzone.Mareu.meeting;

import com.lamzone.Mareu.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MeetingServiceImpl implements MeetingService {
    private final MeetingRepository meetingRepository;

    @Override
    public Meeting newMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public void deleteMeeting(Long id) {
        Meeting meeting = meetingRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Meeting.class, "meetingId", id.toString()));
        meetingRepository.delete(meeting);
    }

    @Override
    public List<Meeting> allMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting one(Long id) {
        Meeting meeting = meetingRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Meeting.class, "meetingId", id.toString()));
        return meeting;
    }
}
