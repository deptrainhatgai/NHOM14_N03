public class phan2 {
    public static class Number {
        public int i;
    }
        public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();
        n1.i = 2;
        n2.i = 5;
        n1 = n2;
        n2.i = 10;
        n1.i = 20;
        }
       }

