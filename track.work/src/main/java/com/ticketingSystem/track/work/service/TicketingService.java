package com.ticketingSystem.track.work.service;

import java.util.List;
import java.util.function.Predicate;

import com.ticketingSystem.track.work.entity.Ticket;

public interface TicketingService {


	public Ticket save(Ticket t);

	public Ticket update(Ticket t);

	public void delete(int t);

	public List<Ticket> getAllTicket();

	public Ticket getTicket(int id);

	public List<Ticket> getTicketBasedOnCondition(Predicate<Ticket> pre);

	public Ticket setStatus(int id, String status);
	
	public Ticket setAgent(int id, String status);

	public void cronJobSch();

}
