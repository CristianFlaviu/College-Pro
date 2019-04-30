package assInterface;

import java.security.spec.ECPrivateKeySpec;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.ws.AsyncHandler;

import exceptions.DivideByZeroException;
import operation.Operatii;
import structures.*;

public class Controller {

	private Interface aInterface;
	private Polinom firstPolinom ;
	private Polinom secondPolinom;
	private boolean firstPolSaved=false;
	private boolean secondPolSaved=false;

	public Controller() {
		

		
		firstPolinom= new Polinom();
		secondPolinom= new Polinom();
	}

	public void start()
	{
		aInterface = new Interface();
		initializeButtons();
		aInterface.setVisible(true);
	}
	public void initializeButtons() {
		aInterface.addGetFirstPOlinomButtonActionListener(e -> {

			int coeffient = 0;
			int degree = 0;
			firstPolinom.getTerm().clear();
			String aString = aInterface.getFirstPoli();
			String stringChecker = new String();
			
			Pattern checkRegex = Pattern.compile("[-+]?\\d+X\\^+\\d+");
			Matcher regexMatcher = checkRegex.matcher(aString);

			while (regexMatcher.find()) {
				if (regexMatcher.group().length() != 0) {
					stringChecker = stringChecker + regexMatcher.group().trim();
					Pattern checkRegex1 = Pattern.compile("(\\d+)");
					Matcher regexMatcher1 = checkRegex1.matcher(regexMatcher.group().trim());
					
					{
					
						
						
						
						while (regexMatcher1.find()) {
							coeffient = Integer.parseInt(regexMatcher1.group().trim());
							if(regexMatcher.group().trim().substring(0, 1).equals("-"))
								coeffient=coeffient*(-1);
							regexMatcher1.find();
							degree = Integer.parseInt(regexMatcher1.group().trim());

						}
					}

					firstPolinom.addTerm(new Monom((float) coeffient, degree));
				}
			}
			if (stringChecker.length() == aString.length()) {
				firstPolinom.deteleteReduntantTerms();
				firstPolinom.sortPolinom();
				aInterface.setfirstPolinomValue(firstPolinom.toString());
				firstPolSaved=true;
			} else {

				aInterface.setfirstPolinomValue("Wrong Format");
			}

		});

		aInterface.addGetSecondPOlinomButtonActionListener(e -> {

			int coeffient = 0;
			int degree = 0;
			secondPolinom.getTerm().clear();
			String aString = aInterface.getSecondPoli();
			String stringChecker = "";
			Pattern checkRegex = Pattern.compile("[-+]?\\d+X\\^+\\d+");
			Matcher regexMatcher = checkRegex.matcher(aString);

			while (regexMatcher.find()) {
				if (regexMatcher.group().length() != 0) {
					stringChecker = stringChecker + regexMatcher.group().trim();
					Pattern checkRegex1 = Pattern.compile("(\\d+)");

					Matcher regexMatcher1 = checkRegex1.matcher(regexMatcher.group().trim());
					{

						while (regexMatcher1.find()) {
							coeffient = Integer.parseInt(regexMatcher1.group().trim());
							if(regexMatcher.group().trim().substring(0, 1).equals("-"))
								coeffient=coeffient*(-1);
							regexMatcher1.find();
							degree = Integer.parseInt(regexMatcher1.group().trim());

						}
					}

					secondPolinom.addTerm(new Monom((float) coeffient, degree));
				}
			}
			if (stringChecker.length() == aString.length()) {
				secondPolinom.sortPolinom();
				secondPolinom.deteleteReduntantTerms();
				aInterface.setSecondPolValue(secondPolinom.toString());
				secondPolSaved=true;
			} else {
				aInterface.setSecondPolValue("wrong format");
			}

		});
		aInterface.setAddBtnActionListener(e -> {
			if(secondPolSaved && firstPolSaved)
			{
			aInterface.setFirstMessage(Operatii.add(firstPolinom, secondPolinom).toString());
			aInterface.setSecondMessage("");
			}
			else
			{
				aInterface.setFirstMessage("One of the polynomials is not saved");
			}

		});
		aInterface.setSubtractBtnActionListener(e -> {
			if(secondPolSaved && firstPolSaved)
			{
			aInterface.setFirstMessage(Operatii.substract(firstPolinom, secondPolinom).toString());
			aInterface.setSecondMessage("");
			}
			else
			{
				aInterface.setFirstMessage("One of the polynomials is not saved");
			}
		});
		aInterface.setMultiplyBtnActionListener(e -> {
			if(secondPolSaved && firstPolSaved)
			{
			aInterface.setFirstMessage(Operatii.multiply(firstPolinom, secondPolinom).toString());
			aInterface.setSecondMessage("");
			}
			else
			{
				aInterface.setFirstMessage("One of the polynomials is not saved");
			}
		});
		aInterface.setDivideBtnActionListener(e -> {

			if(secondPolSaved && firstPolSaved)
			{Polinom aux_cat = new Polinom();
			Polinom aux_rest = new Polinom();
			try {
				Operatii.divide(firstPolinom, secondPolinom, aux_cat, aux_rest);
				aInterface.setFirstMessage("cat:" + aux_cat.toString() );
				aInterface.setSecondMessage("rest:" + aux_rest.toString());

				
			} catch (DivideByZeroException e2) {
				
				aInterface.setFirstMessage("Divided by zero");
			}
			}
			else
			{
				aInterface.setFirstMessage("One of the polynomials is not saved");
			}
			
			
		});

		aInterface.setDerivateBtnActionListener(e -> {
			if( firstPolSaved)
			{
			aInterface.setFirstMessage(Operatii.derivate(firstPolinom).toString());
			aInterface.setSecondMessage("");
			}
			else
			{
				aInterface.setFirstMessage("One of the polynomials is not saved");
			}
		});

		aInterface.setIntegrateBtnActionListener(e -> {
			if(firstPolSaved)
			{
			aInterface.setFirstMessage(Operatii.integrate(firstPolinom).toString());
			aInterface.setSecondMessage("");
			}
			else
			{
				aInterface.setFirstMessage("One of the polynomials is not saved");
			}
			
		});
		
	}

	public static void main(String[] args) {

		Controller aController = new Controller();
		aController.start();
	}
}
