package br.edu.ufabc.Ticketeria.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class UserVO {

	private Long id;
	private String username;
	private String password;
	
	
	private boolean authenticated;
	
//	@OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "users")
//    private Set<TicketVO> tickets = new HashSet<TicketVO>();
	//private boolean enabled;
	
	@Transient
	public boolean isAuthenticated() {
		return authenticated;
	}

	
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public UserVO() {
	}

	public UserVO(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		//this.enabled = enabled;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Column(name = "username", unique = true, 
		nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", 
		nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


//	public Set<TicketVO> getTickets() {
//		return tickets;
//	}
//
//	public void setTickets(Set<TicketVO> tickets) {
//		this.tickets = tickets;
//	}
	
	

	/*@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}*/





	
}
