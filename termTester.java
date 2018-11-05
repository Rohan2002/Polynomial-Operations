public class termTester {
	public static void main(String[] args) {
		term p = new term(3, 5);
		term q = new term(2, 5);
		term r = new term(4, 6);

		System.out.println(p.add(q));
		System.out.println(q.multiply(r));
		System.out.println(p.derivative());

	}
}
