package fractionFrenzy;

public class Fraction {

	int numerator;
	int denominator;
	double value;
	
	public Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
		this.value = numerator/denominator;
	}
}
