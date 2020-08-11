package com.datum.practice.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ToDo {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private boolean completed;

	private LocalDateTime modified;

	@Column(insertable = true, updatable = false)
	private LocalDateTime created;

	@NotNull
	@NotBlank
	private String description;

	public ToDo(String description) {
		this.description = description;
	}

	public ToDo(String description, boolean completed) {
		this.completed = completed;
		this.description = description;
	}

	@PrePersist
	void onCreate() {
		this.setCreated(LocalDateTime.now());
		this.setModified(LocalDateTime.now());
	}

	@PreUpdate
	void onUpdate() {
		this.setModified(LocalDateTime.now());
	}
}
