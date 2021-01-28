package com.platform.exchange.repository;

import com.platform.exchange.model.Meeting;
import com.platform.exchange.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, UUID> {

    List<Meeting> findAllBySellerOrBuyerAndDateAfter(User seller, User buyer, Date date);

    List<Meeting> findAllBySellerOrBuyerAndDateBefore(User seller, User buyer, Date date);
}
