package bancoSynchronized;

public class EjecucionTransferencias implements Runnable{

    public EjecucionTransferencias(Banco b, int de, double max){
        banco = b;
        deLaCuenta = de;
        cantidadMax = max;
    }

    @Override
    public void run() {
        try {
            while (true) {

                int paraLaCuenta = (int) (100 * Math.random());
                double cantidad = cantidadMax * Math.random();
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);

                Thread.sleep((int) (Math.random() * 10));
            }
        } catch (InterruptedException e) {}

    }

    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;
}
