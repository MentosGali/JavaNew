import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cuenta {
    private int numeroCuenta;
    private float saldo;
    private Cliente titular;
    private ArrayList<Movimientos> movimientos;

    public Cuenta(int numeroCuenta, float saldo, Cliente titular, ArrayList<Movimientos> movimientos) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.movimientos = movimientos;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public ArrayList<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public void ingreso(float cantidad) {
        if (cantidad < 0) {
            System.out.println("No se puede ingresar salgo negativo");
            return;
        }
        saldo += cantidad;
        movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, Movimientos.INGRESO));
    }

    public void retiro(float cantidad) {
        if (cantidad < 0) {
            System.out.println("No se puede retirar menos de 0");
            return;
        }
        saldo -= cantidad;
        movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, Movimientos.RETIRO));
    }

    private String obtenerMovimientos() {
        String s = " ";
        for (Movimientos m : movimientos) {
            s += m.toString() + " \n";
        }
        return s;
    }

    public void verDatos() {
        String s = " ";
        s += "No.Cuenta: " + numeroCuenta + "\n";
        s += "Titular: " + titular.nombreCompleto() + "\n";
        s += "Domicilio: " + titular.direccionCompleta() + "\n";
        s += "Saldo Actual: " + saldo + "en $";
        s += "----------------MOVIMIENTOS-----------------" + "\n";
        s += obtenerMovimientos();
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", titular=" + titular + ", movimientos="
                + movimientos + "]";
    }

    /*
     * Clase interna de movimientos
     */

    private class Movimientos {
        private static final byte INGRESO = 0;
        private static final byte RETIRO = 1;

        private LocalDateTime fechahora;
        private float importe;
        private float saldoFinal;
        private byte tipo;

        public Movimientos(LocalDateTime fechahora, float importe, byte tipo) {
            this.fechahora = fechahora;
            this.importe = importe;
            // saldo se pude acceder por que es clase interna de Cuenta
            this.saldoFinal = saldo;
            this.tipo = tipo;
        }

        @Override
        public String toString() {

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            return (tipo == INGRESO ? "INGRESO" : "RETIRO")
                    + "\nFecha: " + fechahora.format(dateFormatter)
                    + "\nHora: " + fechahora.format(timeFormatter)
                    + "\nImporte: " + importe
                    + "\nSaldo" + saldoFinal;
        }

    }

}
