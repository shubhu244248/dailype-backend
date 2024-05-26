package com.dp.dailype.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "managers_table")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private Long managerId;

	@Column(name = "manager_uuid")
	private UUID managerUUID = UUID.randomUUID();

	@Column(name = "manager_name", nullable = false)
	private String managerName;

	@Column(name = "manager_active")
	private Boolean isActive = true;
	
}
