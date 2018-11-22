//Rohan Deshpande, Tejas Nimkar period 7
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import javax.sound.midi.Synthesizer;

//import term.Node;


public class polynomial {

	
	term start = new term(0,0);
	term end = start;
	private LinkedList<term> polynomial;


	public polynomial() {
		polynomial = new LinkedList<term>();
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
		
		return sortPolynomial(newderList);
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
		//return sortPolynomial(add);
		return add;
	}
	
	
	public static polynomial MultiplyLinkedList(LinkedList<term> a, LinkedList<term> b)
	{ 
		polynomial MultipliedNoSimplfy = new polynomial();
		Iterator<term> firsts = a.iterator();
		LinkedList<term> res = new LinkedList<term>();
		while(firsts.hasNext())
		{
			term firstVal = firsts.next();
			Iterator<term> sec = b.iterator();
			while(sec.hasNext())
			{
				term secVal = sec.next();
				res.add(new term(firstVal.getCoef() * secVal.getCoef(), firstVal.getExp() + secVal.getExp()));
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
		return sortPolynomial(MultiplyLinkedList(this.getPolynomial(),one.getPolynomial()));
	}
	public polynomial add(polynomial one)
	{
		return sortPolynomial(AddLinkedList(this.getPolynomial(),one.getPolynomial()));
	}
	

	public void setPolynomial(LinkedList<term> polynomial) {
		this.polynomial = polynomial;
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
	public static LinkedList<term> ArrayTolist(term[] a)
	{
		LinkedList<term> temp = new LinkedList<term>();
		for(term v : a)
		{
			temp.add(v);
		}
		return temp;
	}

	public static polynomial sortPolynomial(polynomial P)
	{
		LinkedList<term> sorted = new LinkedList<term>();
		term[] temp = listToArray(P.getPolynomial());
		for(int i = 0; i < temp.length; i++)
		{
			for(int j = 0; j < temp.length-1; j++)
			{
				if(temp[j].getExp() < temp[j+1].getExp())
				{
					term a = temp[j];
					temp[j] = temp[j+1];
					temp[j+1] = a;
				}
			}		
		}
		sorted = ArrayTolist(temp);
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
				string += " + " + nextvalue;
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
	

