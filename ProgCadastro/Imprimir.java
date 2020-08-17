public class Imprimir {

    public static void n(String texto) {
        System.out.print(texto);
    }

    public static void l(String texto) {
        System.out.println(texto);

    }

    public static void f(String format, Object args) {
        System.out.printf(format, args);
    }
}