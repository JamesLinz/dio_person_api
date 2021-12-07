package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
	
	NOME("Nome"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");
	
	PhoneType(String string) {
		this.description = "";
	}

	private final String description;
}
