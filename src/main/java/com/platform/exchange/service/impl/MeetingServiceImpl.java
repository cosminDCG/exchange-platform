package com.platform.exchange.service.impl;

import com.platform.exchange.exception.ErrorMessage;
import com.platform.exchange.exception.meeting.MeetingNotFoundException;
import com.platform.exchange.exception.user.UserNotFoundException;
import com.platform.exchange.model.Meeting;
import com.platform.exchange.model.User;
import com.platform.exchange.repository.MeetingRepository;
import com.platform.exchange.repository.UserRepository;
import com.platform.exchange.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Meeting saveMeeting(Meeting meeting) {
        meeting.setId(UUID.randomUUID());
        return meetingRepository.save(meeting);
    }

    @Override
    @Transactional
    public void deleteMeeting(String uuid) {
        Meeting meeting = meetingRepository.findById(UUID.fromString(uuid))
                                           .orElseThrow(() -> new MeetingNotFoundException(ErrorMessage.MEETING_NOT_FOUND));
        meetingRepository.delete(meeting);
    }

    @Override
    @Transactional
    public List<Meeting> getUpcomingMeetingsByUser(String uuid) {
        User user = userRepository.findById(UUID.fromString(uuid))
                                  .orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));
        return meetingRepository.findAllBySellerOrBuyerAndDateAfter(user, user, Date.from(Instant.now()));
    }

    @Override
    @Transactional
    public List<Meeting> getPreviousMeetingsByUser(String uuid) {
        User user = userRepository.findById(UUID.fromString(uuid))
                .orElseThrow(() -> new UserNotFoundException(ErrorMessage.USER_NOT_FOUND));
        return meetingRepository.findAllBySellerOrBuyerAndDateBefore(user, user, Date.from(Instant.now()));
    }

    @Override
    @Transactional
    public void respondToMeeting(String uuid, boolean response) {
        Meeting meeting = meetingRepository.findById(UUID.fromString(uuid))
                                           .orElseThrow(() -> new MeetingNotFoundException(ErrorMessage.MEETING_NOT_FOUND));
        meeting.setApproved(response);
        meetingRepository.save(meeting);
    }

    @Override
    @Transactional
    public Meeting updateMeeting(Meeting meeting) {
        meetingRepository.findById(meeting.getId())
                         .orElseThrow(() -> new MeetingNotFoundException(ErrorMessage.MEETING_NOT_FOUND));
        return meetingRepository.save(meeting);
    }
}
