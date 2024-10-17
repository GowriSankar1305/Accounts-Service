package com.mybank.accounts.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdTime;
	@LastModifiedDate
	@Column(insertable = false)
	private LocalDateTime updatedTime;
	@CreatedBy
	@Column(name = "created_by_whom",updatable = false)
	private String createdBy;
	@LastModifiedBy
	@Column(insertable = false)
	private String updatedByWhom;
}
