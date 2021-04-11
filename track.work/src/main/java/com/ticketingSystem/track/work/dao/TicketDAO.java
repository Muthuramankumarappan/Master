package com.ticketingSystem.track.work.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketingSystem.track.work.entity.Ticket;

public interface TicketDAO extends JpaRepository<Ticket, Integer> {

}
