package operation;


import java.util.ArrayList;
import exceptions.*;
import java.util.List;



import structures.*;

public class Operatii {

	private Operatii() {

	}

	public static Polinom add(Polinom a, Polinom b) {
		Polinom cPolinom = new Polinom();
		cPolinom.copyPolinom(a);

		for (Monom i : b.getTerm()) {
			if (!cPolinom.checkDegree(i.getDegree()) ) {
				cPolinom.addTerm(i);

			} else {
				for (Monom j : cPolinom.getTerm()) {
					if (j.getDegree() == i.getDegree()) {
						j.setCoefficient(j.getCoefficient() + i.getCoefficient());
					}
				}

			}

		}
		cPolinom.sortPolinom();
		cPolinom.deleteZerous();
		return cPolinom;
	}

	public static Polinom substract(Polinom a, Polinom b) {
		Polinom polinom = new Polinom();
		for (Monom i : b.getTerm()) {
			polinom.addTerm(new Monom(i.getCoefficient() * (-1), i.getDegree()));
		}

		return Operatii.add(a, polinom);
	}

	public static Polinom derivate(Polinom Polinom) {
		
		Polinom aPolinom=new Polinom();
		aPolinom.copyPolinom(Polinom);
		List<Monom> deleteList=new ArrayList<>();
		for (Monom a : aPolinom.getTerm()) {
			if(a.getDegree()!=0) {
			a.setCoefficient(a.getCoefficient() * a.getDegree());
			a.setDegree(a.getDegree() - 1);
			}
			else
			{
				deleteList.add(a);
			}
		}
		aPolinom.getTerm().removeAll(deleteList);
		return aPolinom;

	}

	public static Polinom integrate(Polinom Polinom) {
		Polinom aPolinom=new Polinom();
		aPolinom.copyPolinom(Polinom);
		for (Monom a : aPolinom.getTerm()) {
			a.setCoefficient(a.getCoefficient() * 1 / (a.getDegree() + 1));
			a.setDegree(a.getDegree() + 1);
		}
		return aPolinom;
	}

	public static Polinom multiply(Polinom aPolinom, Polinom bPolinom) {
		Polinom cPolinom = new Polinom();

		for (Monom bMonom : bPolinom.getTerm()) {
			for (Monom aMonom : aPolinom.getTerm()) {
				Monom aux = new Monom();

				aux.setCoefficient(aMonom.getCoefficient() * bMonom.getCoefficient());
				aux.setDegree(aMonom.getDegree() + bMonom.getDegree());
				cPolinom.addTerm(aux);
			}
		}
		cPolinom.sortPolinom();
	

		return cPolinom;
	}

	public static void divide(Polinom firstPol, Polinom bPolinom, Polinom cat, Polinom rest) throws DivideByZeroException{
		Monom multiplyMonom = new Monom();
		Polinom aux = new Polinom();
		Polinom aux1 = new Polinom();
		Polinom aPolinom = new Polinom();
		aPolinom.copyPolinom(firstPol);
		ArrayList<Monom> deleteList = new ArrayList<>();
		if (bPolinom.getMaxmonom().getDegree() == 0 && bPolinom.getMaxmonom().getCoefficient()==0.0f)
			{
			throw new DivideByZeroException("error");
			}
		else {
			while (aPolinom.getMaxmonom().getDegree() >=bPolinom.getMaxmonom().getDegree() ) {
				aux.copyPolinom(bPolinom);
				multiplyMonom.setDegree(aPolinom.getMaxmonom().getDegree() - bPolinom.getMaxmonom().getDegree());
				multiplyMonom.setCoefficient(aPolinom.getMaxmonom().getCoefficient() / bPolinom.getMaxmonom().getCoefficient());
				cat.addTerm(multiplyMonom);
				aux.multiplyMonom(multiplyMonom);
				aux1.copyPolinom(Operatii.substract(aPolinom, aux));
				
				aPolinom.copyPolinom(aux1);

				for (Monom iMonom : aPolinom.getTerm())
					if (iMonom.getCoefficient() == 0.0f)
						deleteList.add(iMonom);
				aux.getTerm().clear();
				aPolinom.getTerm().removeAll(deleteList);
			}
			rest.copyPolinom(aPolinom);
		}
	}
}