package com.platform.exchange.service;

import com.platform.exchange.model.Meeting;

import java.util.List;

public interface MeetingService {

    Meeting saveMeeting(Meeting meeting);

    void deleteMeeting(String uuid);

    List<Meeting> getUpcomingMeetingsByUser(String uuid);

    List<Meeting> getPreviousMeetingsByUser(String uuid);

    void respondToMeeting(String uuid, boolean response);

    Meeting updateMeeting(Meeting meeting);
}
