import java.util.Arrays;
import java.util.LinkedList;
public class polynomialTester {

	public static void main(String[] args) {
		polynomial Poly1 = new polynomial();
		polynomial Poly2 = new polynomial();
		polynomial Poly3 = new polynomial();

		Poly1.addTerm(3, 4);
		Poly1.addTerm(-2, 0);
		Poly1.addTerm(1, 3);

		Poly2.addTerm(2, 0);
		Poly2.addTerm(1, 2);
		Poly2.addTerm(3, 3);
		Poly2.addTerm(2, 1);
		Poly2.addTerm(1, 5);

		Poly3.addTerm(-3, 3);
		Poly3.addTerm(1, 2);
		Poly3.addTerm(1, 0);

		System.out.println("Poly1");
		System.out.println(Poly1);
		System.out.println("Poly2");
		System.out.println(Poly2);

		System.out.println();
		System.out.println("Poly3");
		System.out.println(Poly3);

		polynomial r = new polynomial();
		
		LinkedList<term> test1 = new LinkedList<term>();
		test1.add(new term(3,4));
		test1.add(new term(2,3));
		test1.add(new term(2,3));
		test1.add(new term(2,3));
		
		LinkedList<term>test2 = new LinkedList<term>();
		test2.add(new term(4,5));
		test2.add(new term(3,2));
		test2.add(new term(2,3));
		
		
		//r = polynomial.combineLinkedList(test1, test2);
		r = Poly2.add(Poly3);
		System.out.println("Poly2+poly3");
		System.out.println();
		System.out.println(r);
		polynomial u = new polynomial();
		u = Poly1.add(Poly3);
		System.out.println("Poly1+Poly3");
		System.out.println(u);
		System.out.println("Poly3*Poly3");
		polynomial s = new polynomial();
		s = Poly3.multiply(Poly3);		 
		System.out.println(s);
		
		System.out.println("Poly1*Poly2");
		polynomial v = new polynomial();
		v = Poly1.multiply(Poly2);
		System.out.println(v);
		polynomial t = new polynomial();
		System.out.println("Poly2'");
		t = Poly2.derivative();
		System.out.println(t);
		polynomial x = new polynomial();
		System.out.println("Poly1'");
		x = Poly1.derivative();
		System.out.println(x);

	}
}
