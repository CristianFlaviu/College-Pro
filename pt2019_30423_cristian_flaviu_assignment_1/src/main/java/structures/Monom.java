package structures;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Monom implements Comparable<Monom>{

	private float coefficient;
	private int degree;
	
	public Monom()
	{
		coefficient=0;
		degree=0;
	}
	
	public Monom(float coefficient,int degree)
	{
		this.coefficient=coefficient;
		this.degree=degree;
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("0.0");
		df.setRoundingMode(RoundingMode.CEILING);
		
		String string="";
		string=string+df.format(coefficient)+"X^"+degree + " ";
		
		return string;
	}
	
	
	public float getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
@Override
	public int compareTo(Monom o) {
		
		if(this.getDegree()<o.getDegree())
			return 1;
		
		return -1;
	}
	
}
