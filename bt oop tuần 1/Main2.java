public class Main2 {
    public static class Number{
		public int i;
	}
	
	static void f(Number m) {
		m.i = 15;
	}
	public static void main(String[] args) {
		Number n = new Number();
		n.i = 14;
		f(n); 
		System.out.println(n.i);
	}
}
