package com.ticketingSystem.track.work.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketingSystem.track.work.entity.Ticket;
import com.ticketingSystem.track.work.service.TicketingService;
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired 
	TicketingService ticketService;
	
	@PostMapping("/ticketsystem")
	public Ticket createTicket(@Valid @RequestBody Ticket t) {
		return ticketService.save(t);
	}

	
	@GetMapping("/ticketsystem")
	public List<Ticket> getTicket(@Valid @RequestParam("ticketId") Optional<Integer> ticketId,
			@RequestParam("status") Optional<String> status,
			@RequestParam("customer") Optional<String> customer,
			@RequestParam("agent") Optional<String> agent) {
		Predicate<Ticket> val = null;
		if(ticketId.isPresent()) {
			return Arrays.asList(ticketService.getTicket(ticketId.get()));	
		}else if(status.isPresent()) {
			val = (Ticket t) -> 
				 t.getStatus().equals(status.get());
		}else if(customer.isPresent()) {
			val = (Ticket t) -> t.getCustomer() != null && t.getCustomer().equals(customer.get());	
		}else if(agent.isPresent()) {
			val = (Ticket t) -> t.getAssignedAgent() != null && t.getAssignedAgent().equals(agent.get());
		}else {
			return ticketService.getAllTicket();	
		}
		return ticketService.getTicketBasedOnCondition(val);
	}

	@PutMapping(value = "/ticketsystem", params = {"!ticketId", "!status" , "!agent"})
	public Ticket editTicket(@Valid @RequestBody Ticket t) {
		return ticketService.update(t);
	}
	
	@PutMapping(value = "/ticketsystem" , params = {"ticketId"})
	public Ticket setStatus(@Valid 
			@RequestParam("ticketId")  int ticketId,
			@RequestParam("status") Optional<String> status , 
			@RequestParam("agent") Optional<String> agent
			) {
		if(status.isPresent()) {
			return ticketService.setStatus(ticketId, status.get());
		}else if(agent.isPresent()) {
			return ticketService.setAgent(ticketId, agent.get());
		}else {
			return null;	
		}
	}

	@DeleteMapping("/ticketsystem/{ticketId}")
	public void deleteTicket(@Valid @PathVariable int ticketId) {
		 ticketService.delete(ticketId);
	}


}
