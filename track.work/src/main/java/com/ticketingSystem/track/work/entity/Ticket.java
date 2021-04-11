package com.ticketingSystem.track.work.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name="ticket")
public class Ticket {
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Id
	@Column(name="ticket_id")
	private int ticketId;
	
	@Column(name="status")
	@NotBlank(message="status can not be blank")
	@NotEmpty(message="status can not be null")
	private String status;
	
	@Column(name="assigned_agent")
	private String assignedAgent;

	
	@Column(name="type")
	private String type;
	
	@Column(name="title")
	@NotBlank(message="status can not be blank")
	@NotEmpty(message="status can not be null")
	private String title;
	

	@Column(name="description")
	private String description;

	
	@Column(name="customer")
	private String customer;
	

	@Column(name="priority")
	@NotNull
	private String priority;

	public Ticket() {
	}

	@Column(name="ticket_created_date")
	@NotNull
	private Date ticketCreatedDate;
	
	@Column(name="ticket_updated_date")
	@NotNull
	private Date ticketUpdatedDate;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedAgent() {
		return assignedAgent;
	}

	public void setAssignedAgent(String assignedAgent) {
		this.assignedAgent = assignedAgent;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Date getTicketCreatedDate() {
		return ticketCreatedDate;
	}

	public void setTicketCreatedDate(Date ticketCreatedDate) {
		this.ticketCreatedDate = ticketCreatedDate;
	}

	public Date getTicketUpdatedDate() {
		return ticketUpdatedDate;
	}

	public void setTicketUpdatedDate(Date ticketUpdatedDate) {
		this.ticketUpdatedDate = ticketUpdatedDate;
	}
	
	
	public Ticket(int ticketId,
			@NotBlank(message = "status can not be blank") @NotEmpty(message = "status can not be null") String status,
			String assignedAgent, String type,
			@NotBlank(message = "status can not be blank") @NotEmpty(message = "status can not be null") String title,
			String description, String customer, String priority, Date ticketCreatedDate, Date ticketUpdatedDate) {
		this.ticketId = ticketId;
		this.status = status;
		this.assignedAgent = assignedAgent;
		this.type = type;
		this.title = title;
		this.description = description;
		this.customer = customer;
		this.priority = priority;
		this.ticketCreatedDate = ticketCreatedDate;
		this.ticketUpdatedDate = ticketUpdatedDate;
	}

	
	
	
}
