package bancoSynchronized;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    public Banco(){
        cuentas = new double[100];
        for(int i=0; i<cuentas.length;i++){
            cuentas[i]=2000;
        }
   //     saldoSuficiente = cierreBanco.newCondition();
    }

    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {

    //    cierreBanco.lock();
        // Bloqueo todo este bloque
       // try {
            while (cuentas[cuentaOrigen] < cantidad) {

                // pone el hilo a la espera Y LIBERA EL LOCK
            //  saldoSuficiente.await();
                wait();
            }
            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen] -= cantidad;

            System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

            cuentas[cuentaDestino] += cantidad;

            System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());

           // saldoSuficiente.signalAll();
            notifyAll();
        } //finally{
          //  cierreBanco.unlock(); // DESPIERTA TODOS LOS HILOS ESPERANDO
       // }
  //  }

    public double getSaldoTotal(){

        double suma_cuentas = 0;

        for(double a: cuentas){
            suma_cuentas+=a;
        }
        return  suma_cuentas;

    }

    private final double[] cuentas;

 //   private Lock cierreBanco = new ReentrantLock();
 //   private Condition saldoSuficiente;

}

