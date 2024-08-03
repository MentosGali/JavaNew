import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
        movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, Movimientos.ingreso));
    }

    public void retiro(float cantidad) {
        if (cantidad < 0) {
            System.out.println("No se puede retirar menos de 0");
            return;
        }
        saldo -= cantidad;
        movimientos.add(new Movimientos(LocalDateTime.now(), cantidad, Movimientos.retiro));
    }

    private String obtenerMovimientos() {
        String s = " ";
        for (Movimientos m : movimientos) {
            s += toString() + " \n";
        }
        return s;
    }

    public void verDatos() {

    }

    /*
     * Clase interna de movimientos
     */

    private class Movimientos {
        private static final byte ingreso = 0;
        private static final byte retiro = 1;

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
            return (tipo == ingreso ? "INGRESO" : "RETIRO")
                    + "\nfecha: " + fechahora.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
                    + "\nHora: " + fechahora.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))
                    + "\nImporte: " + importe
                    + "\nSaldo" + saldoFinal;
        }

    }

}
