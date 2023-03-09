package EmolyeeManager.utility;

import EmolyeeManager.exceptions.MobileNumberException;

public interface IRegexEmployeeRegistration {
	
	boolean validMobileNumber(String number) throws MobileNumberException;
	
}