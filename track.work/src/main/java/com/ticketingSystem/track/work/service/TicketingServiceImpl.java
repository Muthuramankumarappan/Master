package com.ticketingSystem.track.work.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.ticketingSystem.track.work.dao.TicketDAO;
import com.ticketingSystem.track.work.entity.Ticket;
import com.ticketingSystem.track.work.exception.ExceptionMessage;

import constants.Constants;

@Service
public class TicketingServiceImpl implements TicketingService {


	@Autowired
	TicketDAO dao;


	public Ticket save(Ticket t) {
		return dao.save(t);
	}

	public Ticket update(Ticket t) {
		Optional<Ticket> saveOrpdate = dao.findById(t.getTicketId());
		if(saveOrpdate.isPresent()) {
			return save(t);
		}else{
			throw new ExceptionMessage(HttpStatus.BAD_REQUEST,"Ticket id is not present so can't be updated");
		}
	}

	public void delete(int t) {
		dao.deleteById(t);
	}

	public List<Ticket> getAllTicket() {
		return  dao.findAll();
	}

	public Ticket getTicket(int id) {
		Optional<Ticket> t =  dao.findById(id);
		if(t.isPresent()) {
			return t.get();
		}else{
			throw new ExceptionMessage(HttpStatus.BAD_REQUEST,"Ticket id is not present so can't be fetch");
		}
	}

	public List<Ticket> getTicketBasedOnCondition(Predicate<Ticket> pre) {
		List<Ticket> allTickets = getAllTicket();
		return allTickets.stream()
				.filter(pre)
				.collect(Collectors.toList());
	}

	public Ticket setStatus(int id, String status) {
		Ticket t = getTicket(id);
		t.setStatus(status);
		Ticket updatedTicket = update(t);
		try {
			send(sendUpdatedStatus(status));
		}catch(IOException e) {
			e.printStackTrace();
			throw new ExceptionMessage(HttpStatus.SERVICE_UNAVAILABLE,"Mail sending Error");
		}
		return updatedTicket;

	}

	public Ticket setAgent(int id, String status) {
		Ticket t = getTicket(id);
		t.setAssignedAgent(status);
		return update(t);
	}


	public static Mail sendUpdatedStatus(String status) {
		Email from = new Email(Constants.FROM_MAIL_ID);
		String subject = Constants.MAIL_SUBJECT+ status ;
		Email to = new Email(Constants.TO_MAIL_ID);
		Content content = new Content("text/plain", Constants.MAIL_CONTENT );
		Mail mail = new Mail(from, subject, to, content);
		return mail;
	}

	private static void send(final Mail mail) throws IOException {
		final SendGrid sg = new SendGrid(Constants.SEND_GRID_TOKEN);
		final Request request = new Request();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());
		final Response response = sg.api(request);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
	}


	@Scheduled(cron = "0 0 0 * * ?")
	public void cronJobSch() {
		Predicate<Ticket> val = (Ticket t) -> 
		t.getStatus().equalsIgnoreCase(Constants.CHECK_STATUS) && 
		t.getTicketUpdatedDate().compareTo(new Date()) < 0;
		getTicketBasedOnCondition(val).stream()
		.map(ticket -> { ticket.setStatus(Constants.UPDATE_STATUS); return ticket;})
		.forEach(ticket -> save(ticket));
	}

}
