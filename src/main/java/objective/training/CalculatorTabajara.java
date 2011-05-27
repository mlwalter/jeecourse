package objective.training;

public class CalculatorTabajara implements Calculator {

	@Override
	public String add(String left, String right) {
		return doOperation(left, right, +1);
	}

	@Override
	public String subract(String left, String right) {
		return doOperation(left, right, -1);
	}

	private String doOperation(String left, String right, int sign) {
		String result = new String();
		int max = Math.max(left.length(), right.length());
		int resultNumber = 0;
		
		for (int i = 0; i < max; i++) {
			resultNumber += digitAt(left, i) + sign * digitAt(right, i);
			result = (resultNumber + 10) % 10 + result;
			resultNumber = (resultNumber < 0 || resultNumber > 9) ? sign : 0;
		}
		
		result = trimLeftZeros(result);
		
		return (resultNumber == 1 ? "1" : "") + result;
	}

	private String trimLeftZeros(String result) {
		int i = 0;
		while(i < result.length() - 1 && result.charAt(i) == '0') {
			i++;
		}
		return result.substring(i);
	}

	private int digitAt(String number, int pos) {
		if (pos < number.length())
			return number.charAt(number.length() - pos - 1) - '0';
		return 0;
	}

	@Override
	public int compare(String left, String right) {
		if(left.length() == right.length())
			return compareSameDigits(left, right);
		
		return left.length() < right.length() ? +1 : -1;
	}

	private int compareSameDigits(String left, String right) {
		int i = 0;
		
		while(i < left.length() && left.charAt(i) == right.charAt(i)) {
			i++;
		}
		
		if(i >= left.length()) {
			return 0;
		}
		
		return left.charAt(i) < right.charAt(i) ? +1 : -1;
	}
}
