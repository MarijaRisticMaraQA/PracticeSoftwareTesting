package model;

import com.github.javafaker.Faker;
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

	Faker faker;
	private String firstName;
	private String lastName;
	private String address;
	private String postcode;
	private String city;
	private String state;
	private String phone;
	private String username;
	private String password;

	public RegisterUserModel() {

		faker = new Faker();
		this.firstName = faker.name().firstName();
		this.lastName = faker.name().lastName();
		this.address = faker.address().streetAddress();
		this.postcode = faker.address().zipCode();
		this.city = faker.address().city();
		this.state = faker.address().country();
		this.phone = faker.number().digits(8);
		this.username = faker.internet().emailAddress();
		this.password = faker.internet().password();
	}
}
