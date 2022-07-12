package Utils;


import org.apache.commons.validator.routines.EmailValidator;

public class EmailUtil {
	public static boolean isValidEmail(String email) {
		EmailValidator valiEmail = EmailValidator.getInstance();
		return valiEmail.isValid(email);
	}
}
