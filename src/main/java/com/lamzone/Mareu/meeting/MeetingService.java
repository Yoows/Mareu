package com.lamzone.Mareu.meeting;

import java.util.List;
import java.util.Set;

public interface MeetingService {
    Meeting newMeeting(Meeting meeting);
    void deleteMeeting(Long id);
    List<Meeting> allMeetings();
    Meeting one(Long id);
}
