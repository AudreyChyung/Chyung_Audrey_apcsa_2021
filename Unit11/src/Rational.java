//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int num;
	private int den;
	
	//write two constructors
	public Rational() {
		setRational(1,1);
	}
	
	public Rational(int nm, int dn) {
		setRational(nm,dn);
	}


	//write a setRational method
	public void setRational(int nm, int dn) {
		num = nm;
		den = dn;
	}

	//write  a set method for numerator and denominator
	public void setNumerator(int nm) {
		num = nm;
	}
	
	public void setDenominator(int dn) {
		den = dn;
	}
	
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		
		num = this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator();
		den = this.getDenominator() * other.getDenominator();

		reduce();
	}

	private void reduce()
	{
		int div = gcd(num, den);
		setNumerator(num/div);
		setDenominator(den/div);
	}

	private int gcd(int numOne, int numTwo)
	{
		int max = 1;
		for (int i = 1; i <= numOne; i++){
		   if (numOne%i == 0 && numTwo%i == 0)
			   max = i;
		}
		return max;
	}

	public Object clone ()
	{
		return new Rational(num, den);
	}


	//ACCESSORS

	//write get methods for numerator and denominator
	public int getNumerator() {
		return num;
	}
	
	public int getDenominator() {
		return den;
	}
	
	
	public boolean equals( Object obj)
	{
		return (this.compareTo((Rational)obj) == 0);
	}

	public int compareTo(Rational other)
	{
		double result1 = (double)this.getNumerator()/this.getDenominator();
		double result2 = (double)other.getNumerator()/other.getDenominator();
		if (result1 > result2)
			return 1;
		else if (result1 < result2)
			return -1;
		else
			return 0;
	}


	//write  toString() method
	public String toString() {
		return "" + num + "/" + den;
	}
	
}