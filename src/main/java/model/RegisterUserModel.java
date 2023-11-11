package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
public class RegisterUserModel {

	private String firstName;
	private String lastName;
	private String address;
	private String postcode;
	private String city;
	private String state;
	private String phone;
}
