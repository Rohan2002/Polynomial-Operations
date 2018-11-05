import java.util.Iterator;
import java.util.LinkedList;

public class term {
	int coef;
	int exp;
	
	public term(int coef, int exp)
	{
		this.coef = coef;
		this.exp = exp;
	}



	public int getCoef() {
		return coef;
	}



	public void setCoef(int coef) {
		this.coef = coef;
	}



	public int getExp() {
		return exp;
	}



	public void setExp(int exp) {
		this.exp = exp;
	}



	public term add(term toAdd)
	{ 
		
		term a = this;
		
		int value = 0;
		if(a.getExp() == toAdd.getExp())
		{
			 value = a.getCoef() + toAdd.getCoef();
			 return new term(value,a.getExp());
		}

		return null;
		
	}

	public term multiply(term toAdd)
	{ 
		
		term a = this;
		
		int value = 0;
	
			 value = a.getCoef() * toAdd.getCoef();
			 return new term(value,a.getExp() + toAdd.getExp());
		
	}
	public term derivative()
	{
		term r = this;
		if(r.getExp() == 0)
		{
			return new term(0,0);
		}
		else {
			return new term(r.getCoef() * r.getExp(), r.getExp() -1);
		}
	}

	@Override
	public String toString() {
		String s = " ";
			s +=  (getCoef() + "x^" + getExp());		
		return s;
	}


}

