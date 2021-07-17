package bancoSynchronized;

public class BancoMain {
    public static void main(String[] args) {

        Banco b = new Banco();

        for(int i=0; i<100; i++){

            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

