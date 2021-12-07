package com.project.dio_personalapi.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {
	
	private String message;

	public static Object builder() {
		return null;
	}
}
