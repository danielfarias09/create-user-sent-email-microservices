package com.danielfarias.email.dtos;

import java.util.UUID;

public record EmailRecordDto(UUID id, String emailTo, String subject, String text) {

	@Override
	public String toString() {
		return "EmailRecordDto [id=" + id + ", emailTo=" + emailTo + ", subject=" + subject + ", text=" + text + "]";
	}
}
