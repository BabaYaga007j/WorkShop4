package EmolyeeManager.utility;

public enum EEmployeeRegistrationPattern {
	
	MOBILE_NUMBER_PATTERN("^91[6-9][0-9]{9}$");
	String constant;
	EEmployeeRegistrationPattern(String constant) {
		this.constant = constant;
	}
	
	public String getConstant() {
		return constant;
	}
}