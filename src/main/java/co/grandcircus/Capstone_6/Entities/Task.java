package co.grandcircus.Capstone_6.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	private String description;
	private LocalDate dueDate;
	private Boolean complete;

	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		String date = dueDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return date;
	}

	public void setDueDate(String dueDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate setDueDate = LocalDate.parse(dueDate, format);
		this.dueDate = setDueDate;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(String completeString) {
		boolean completeBool = false;
		if (completeString.equals("True")) {
			completeBool = true;

		}
		complete = completeBool;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", dueDate=" + dueDate
				+ ", complete=" + complete + ", user=" + user + "]";
	}

}
