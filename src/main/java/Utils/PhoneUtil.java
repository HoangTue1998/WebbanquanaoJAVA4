package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtil {
public static boolean isPhoneValid(String phone) {
	String regex = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(phone);
	   return matcher.matches();
}
}
