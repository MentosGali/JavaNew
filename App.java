public class App {

    public static void main(String[] args) {
        // Nombre clase + metodo
        // no necesita una instacia
        Constantes.imprimirDatos();
        // Nombre clase + atributo estatico
        System.out.println("------------------------------------");
        System.out.println("Desde el main");
        System.out.println("PI " + Constantes.pi);
        System.out.println("e " + Constantes.e);

    }
}
