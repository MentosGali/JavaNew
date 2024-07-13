public class Punto {
    public int x;
    public int y;

    public Punto(int a) {
        x = a;
        y = a;
    }

    public Punto(int a, int by) {
        x = a;
        y = by;
    }

    public double calcularDistanciCentro() {
        double z;
        z = Math.sqrt((x * x) + (y * y));
        return z;
    }

    // solo lo puedo invocar desde otro metodo propio de la clase
    private void mostrarDatos() {
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
        System.out.println("La distacia con respecto al centro: " + calcularDistanciCentro());
        System.out.println("--------------");
    }

    public void mostrarDatos(String n) {
        System.out.println(n);
        mostrarDatos();
    }

}