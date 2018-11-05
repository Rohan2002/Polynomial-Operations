
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import javax.sound.midi.Synthesizer;

//import term.Node;


public class polynomial {

	
	term start = new term(0,0);
	private double TOLERANCE = 0.00000001;
	term end = start;
	private LinkedList<term> polynomial;


	public polynomial() {
		polynomial = new LinkedList<term>();
//		polynomial.add(new term(0, 0));
//		polynomial.add(new term(3, 4));
//		polynomial.add(new term(1, 3));
	}

	
	public void removeTerm(term t)
	{
		Iterator<term> iterator = polynomial.iterator();
		while(iterator.hasNext())
		{
			if(iterator.next().equals(t))
			{
				iterator.remove();
			}
		}
		
	}
	
	public void addTerm(int coef,int base)
	{
		Iterator<term> iterator = polynomial.iterator();
		term nextValue = null;
		while(iterator.hasNext())
		{	
			nextValue = iterator.next();
			if(base != nextValue.exp)
			{	
				continue;
			}	
			else
			{
				nextValue.coef+=coef;//edit next value by adding curr coef to be added
				return;
			}
		} 
		polynomial.add(new term(coef,base));		
		
	}
	public polynomial derivative()
	{
		LinkedList<term> dervativeList = new LinkedList<term>();
		Iterator<term> iter = polynomial.iterator();
		polynomial newderList = new polynomial();
		term newTerm = null;
		while(iter.hasNext())
		{
			
			term value = iter.next();
			newTerm = value.derivative();
			dervativeList.add(newTerm);
		}
		Iterator<term> iterList = dervativeList.iterator();
		while(iterList.hasNext())
		{
			term val = iterList.next();
			newderList.addTerm(val.getCoef(), val.getExp());
		}
		
		return newderList;
	}
	
	public LinkedList<term> getPolynomial() {
		return polynomial;
	}

	public static polynomial AddLinkedList(LinkedList<term> a, LinkedList<term> b)
	{ 
		//LinkedList<term> addList = new LinkedList<term>();
		polynomial add = new polynomial();
		Iterator<term> lista = a.iterator();
		Iterator<term> listb = b.iterator();
		while(lista.hasNext())
		{
			term value = lista.next();
			add.addTerm(value.getCoef(), value.getExp());
			
		}
		while(listb.hasNext())
		{
			term value = listb.next();
			add.addTerm(value.getCoef(), value.getExp());
		}
		return add;
	}
	public static term[] listToArray(LinkedList<term> a)
	{
		term[] array = new term[a.size()];
		Iterator<term> iter = a.iterator();
		int x = 0;
		while(iter.hasNext())
		{
			term val = iter.next();
			array[x] = val;
			x++;
		}
		return array;
	}
	
	public static polynomial MultiplyLinkedList(LinkedList<term> a, LinkedList<term> b)
	{ 
		//LinkedList<term> addList = new LinkedList<term>();
		polynomial MultipliedNoSimplfy = new polynomial();
		term[] first = listToArray(a);
		term[] second = listToArray(b);
		LinkedList<term> res = new LinkedList<term>();
		
		for (int i = 0; i < first.length; i++) 
		{
			for (int j = 0; j < second.length; j++) 
			{
				res.add(new term(first[i].getCoef() * second[j].getCoef()
						, first[i].getExp() + second[j].getExp()));
			}
			
		}
		Iterator<term> iter =  res.iterator();	
		while(iter.hasNext())
		{
			term val = iter.next();
			MultipliedNoSimplfy.addTerm(val.getCoef(),val.getExp());
		}
		return  MultipliedNoSimplfy;
	}
		
	public polynomial multiply(polynomial one)
	{
		return (MultiplyLinkedList(this.getPolynomial(),one.getPolynomial()));
	}
	public polynomial add(polynomial one)
	{
		return AddLinkedList(this.getPolynomial(),one.getPolynomial());
	}
	

	public void setPolynomial(LinkedList<term> polynomial) {
		this.polynomial = polynomial;
	}


	public polynomial sortPolynomial(polynomial P)
	{
		Iterator<term> iter = P.getPolynomial().iterator();
		LinkedList<term> sorted = new LinkedList<term>();
		term[] temp = listToArray(P.getPolynomial());
		int max = 0;
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i].getExp() > temp[max].getExp())
			{
				max = i;
			}
			sorted.add(new term(temp[max].getCoef(),temp[max].getExp()));
		}
		Iterator<term> itermain = sorted.iterator();
		polynomial ne = new polynomial();
		while(itermain.hasNext())
		{
			term val = itermain.next();
			ne.addTerm(val.getCoef(), val.getExp());
		}
		return ne;
	}
	public String toString() {
		Iterator<term> iterator = polynomial.iterator();
		String string = "";
		while (iterator.hasNext()) {
			term nextvalue = iterator.next();
			if (nextvalue.getCoef() > 0)
				string += " +" + nextvalue;
			else if(nextvalue.getCoef() < 0)
				string += nextvalue;
			else if(nextvalue.getCoef() ==0)
				string += "";
		}
		return string;
	}
	public void display()
	{
		System.out.println(polynomial);
	}
	
	
	
}
	

