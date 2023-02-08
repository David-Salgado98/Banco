package Menu.Banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
private Double Saldo = 10000d;

private final List<String> movimientos;
DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

///////////////////Constructor/////////////////////

    public Banco() {
        movimientos = new ArrayList<>();
    }

    ///////////////////get and set/////////////////////
    public Double getSaldo() {
        //System.out.println("Consulta de saldo "+(LocalDateTime.now().format(formato)));
       // movimientos.add("Consulta de saldo "+(LocalDateTime.now().format(formato)));
        return Saldo;
    }


///////////////////metodo/////////////////////
    public void deposito(Double che){
        Saldo+=che;
        movimientos.add("Deposito Cantidad:"+che+" "+(LocalDateTime.now().format(formato)));

    }

    public void credito(Double che){
        Saldo-=che;
        movimientos.add("Credito Cantidad:"+che+" "+(LocalDateTime.now().format(formato)));
    }

    public void transferencia(Double che){
        Saldo-=che;
        movimientos.add("Transferencia Cantidad:"+che+" "+(LocalDateTime.now().format(formato)));
    }

    public List<String> ultimaTrans(){

        return movimientos;
    }

}
