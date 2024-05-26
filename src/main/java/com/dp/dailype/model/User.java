package com.dp.dailype.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userID;

	@Column(name = "user_uuid")
	private UUID userUUIDID = UUID.randomUUID();

	@Column(name = "user_full_name", nullable = false)
	private String userFullName;

	@Column(name = "mobile_num", length = 13, nullable = false)
	@Pattern(regexp = "^(\\+91|0)?[6-9][0-9]{9}$")
	private String mobNum;

	@Column(name = "pan_num", nullable = false)
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]")
	private String panNum;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@Column(name = "created_date", updatable = false, nullable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	@UpdateTimestamp
	private LocalDateTime lastModifiedDate;

}
