package structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.*;
import exceptions.*;
public class Polinom {

	private ArrayList<Monom> term = new ArrayList<Monom>();

	public Polinom() {

	}

	public Polinom(ArrayList<Monom> a) {
		term.addAll(a);
	}

	public String toString() {

		String string = "";
		for (Monom a : term) {
			if (a.getCoefficient() > 0)
				string = string + "+ ";
			

			string = string + a.toString();

		}

		if (string.length() == 0)
			return new String("0X^0");
		if (term.get(0).getCoefficient() < 0)
			return string;
		return string.substring(1, string.length() - 1);
	}

	public void addTerm(Monom aMonom) {
		term.add(new Monom((aMonom.getCoefficient()), aMonom.getDegree()));
	}

	public void deleteTerm(Monom aMonom) {
		term.remove(aMonom);
	}

	public List<Monom> getTerm() {
		return term;
	}

	public void setTerm(ArrayList<Monom> term) {
		this.term = term;
	}

	public void deteleteReduntantTerms() {

		ArrayList<Monom> elementToDelete = new ArrayList<>();
		for (Monom i : term) {
			for (Monom j : term) {
				if (i.getDegree() == j.getDegree() && i != j) {

					i.setCoefficient(i.getCoefficient() + j.getCoefficient());

					j.setCoefficient(0f);
					j.setDegree(0);
					elementToDelete.add(j);
				}
			}
		}

		term.removeAll(elementToDelete);

	}
	public void deleteZerous()
	{
		List<Monom> deleleteList=new ArrayList<>();
		for(Monom i:this.getTerm())
		{
			if(i.getCoefficient()==0)
			{
				deleleteList.add(i);
			}
		}
		this.getTerm().removeAll(deleleteList);
	}

	public void copyPolinom(Polinom aPolinom) {
		this.getTerm().clear();
		for (Monom aMonom : aPolinom.getTerm()) {
			this.addTerm(new Monom(aMonom.getCoefficient(), aMonom.getDegree()));
		}

	}

	public Monom getMaxmonom() {
		Monom maxMonom = new Monom();
		for (Monom aMonom : this.getTerm()) {
			if (aMonom.getDegree() > maxMonom.getDegree())
				maxMonom = new Monom(aMonom.getCoefficient(), aMonom.getDegree());

		}

		return maxMonom;
	}
	
	public void  multiplyMonom(Monom aMonom)
	{
		
		for(Monom bMonom:this.getTerm())
		{
			bMonom.setCoefficient(bMonom.getCoefficient()*aMonom.getCoefficient());
			bMonom.setDegree(aMonom.getDegree()+bMonom.getDegree());
		}
	}

	public void sortPolinom() {
		Collections.sort(term);
	}

	public boolean checkDegree(int degree) {

		for (Monom i : term) {
			if (i.getDegree() == degree)
				return true;
		}

		return false;

	}
	

}
