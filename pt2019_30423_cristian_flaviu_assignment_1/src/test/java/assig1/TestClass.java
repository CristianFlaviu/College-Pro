package assig1;

import org.junit.Assert;
import org.junit.Test;

import operation.Operatii;
import structures.Monom;
import structures.Polinom;

public class TestClass {
	
	
	
	Polinom firstPolinom=new Polinom();
	Polinom secondPolinom=new Polinom();
	
	
	@Test
	
	public void adunare()
	{
		initializare();
	
		Assert.assertTrue(Operatii.add(firstPolinom,secondPolinom).toString().equals(" 3,0X^5 + 2,0X^2 + 3,0X^1 + 2,0X^0"));
	}
	@Test
	public void scadere()
	{
		initializare();
	
		
		Assert.assertTrue(Operatii.substract(firstPolinom,secondPolinom).toString().equals("-3,0X^5 -3,0X^1 + 2,0X^0 "));
		
	}
	@Test 
	public void inmultire()
	{
		initializare();
		
		Assert.assertTrue(Operatii.multiply(firstPolinom,secondPolinom).toString().equals(" 3,0X^7 + 6,0X^5 + 1,0X^4 + 3,0X^3 + 2,0X^2 + 6,0X^1"));
	}
	
	@Test
	public void impartire()
	{
		initializare();
		Polinom cat_aux=new Polinom();
		Polinom rest_aux=new Polinom();
		Polinom check= new Polinom();
		Operatii.divide(secondPolinom,firstPolinom, cat_aux, rest_aux);
		

		check=Operatii.add(Operatii.multiply(cat_aux, firstPolinom),rest_aux);
		check.deteleteReduntantTerms();
		check.deleteZerous();
		
		secondPolinom.sortPolinom();
		Assert.assertTrue(check.toString().equals(secondPolinom.toString()));
	}
	
	@Test
	public void derivare()
	{
		initializare();
	
		Assert.assertTrue(Operatii.derivate(firstPolinom).toString().equals(" 2,0X^1"));
		
	}
	
	@Test
	public void intergrare()
	{
		initializare();
	
		Assert.assertTrue(Operatii.integrate(firstPolinom).toString().equals(" 2,0X^1 + 0,4X^3"));
	}
	
	public void initializare() {
		Monom a1=new Monom(2f,0);
		Monom a2 =new Monom(1f,2);
	
		Monom b1=new Monom(3f,1);
		Monom b2=new Monom(1f,2);
		Monom b3=new Monom(3f,5);
		
		firstPolinom.addTerm(a1);
		firstPolinom.addTerm(a2);
		//2x^0+1x^2
		secondPolinom.addTerm(b1);
		secondPolinom.addTerm(b2);
		secondPolinom.addTerm(b3);
		//3x^1+1X^2+3X5
		

	}
	
}
