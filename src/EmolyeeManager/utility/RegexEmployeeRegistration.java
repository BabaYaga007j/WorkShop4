package EmolyeeManager.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import EmolyeeManager.exceptions.MobileNumberException;

public class RegexEmployeeRegistration implements IRegexEmployeeRegistration{

	

	public boolean validMobileNumber(String number) throws MobileNumberException {
		boolean result = getMatcher(EEmployeeRegistrationPattern.MOBILE_NUMBER_PATTERN.getConstant(), number).find();
		if(!result) {
			throw new MobileNumberException("Invalid MObile Number...");
		}
		return result;
	}
	private static Matcher getMatcher(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher;	
	}
}