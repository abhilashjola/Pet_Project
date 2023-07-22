package PetServicePjct.dto;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {

	@NotBlank(message = "provide FirstName")
	private String firstName;
	@NotEmpty(message = "provide LastName")
	private String lastName;
	@NotBlank
	@Email(message = "Invalid Email")
	private String email;
	@NotNull(message = "provide mobile number")
	//////////////////////////////////////////////@Pattern(regexp = "^\\d{10}$")
	private Long mobile;
	@NotBlank
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "provide atleast one capital ,one char,one numeric,one special character,greater than 8)")
	private String password;
	@NotBlank(message = "Password and ConformPassword must be same")
	@Transient
	private String confirmPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "UserRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobile="
				+ mobile + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

	public UserRequest(@NotNull(message = "provide FirstName") String firstName,
			@NotNull(message = "provide LastName") String lastName,
			@NotBlank @Email(message = "Invalid Email") String email,
			@NotBlank(message = "provide MobileNumber") @Min(10) @Max(10) Long mobile,
			@NotBlank(message = "provide atleast one capital ,one char,one numeric,one special character)") @Min(8) @Max(15) String password,
			@NotBlank(message = "Password and ConformPassword must be same") @Min(8) @Max(15) String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
