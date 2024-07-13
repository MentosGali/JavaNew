public class Punto {
    public int x;
    public int y;
    public String nombre;

    public Punto(int x) {
        this.x = x;
        this.y = x;
    }

    public Punto(int x, String nombre) {
        this(x);
        this.nombre = nombre;
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Punto(int x, int y, String nombre) {
        this(x, y);
        this.nombre = nombre;
    }

    public double calcularDistanciCentro() {
        double z;
        z = Math.sqrt((x * x) + (y * y));
        return z;
    }

    // solo lo puedo invocar desde otro metodo propio de la clase
    public void mostrarDatos() {
        if (this.nombre == null)
            System.out.println("El punto no tiene nombre, sus datos son:");
        else
            System.out.println("Punto con nombre: " + nombre);
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
        System.out.println("La distacia con respecto al centro: " + calcularDistanciCentro());
        System.out.println("--------------");
    }

}