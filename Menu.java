package Menu;


import Menu.Banco.Banco;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Menu {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scan = new Scanner(System.in);
        int res;
        int cont = 0;
        double val;
        do {
            res = opcion();
            val = 0.0;

            switch (res) {
                case 1:
                    val = valorObtener();
                    if (val > 0 && multipo(val) && val <= 6000 &&val< banco.getSaldo()) {
                        banco.credito(val);
                    } else {
                        System.out.println("Valor invalido o Mayor a 6000");
                    }
                    break;
                    ////////////////////////////////////////
                case 2:
                    int sub = submenu();
                    if (sub > 0 && sub < 4) {
                        switch (sub) {
                            case 1:
                                val = valorObtener();
                                if (val > 0 && multipo(val) ) {
                                    banco.deposito(val);
                                }
                                break;
                            case 2, 3:
                                val = valorObtener();
                                if (val <= banco.getSaldo()) {
                                    banco.credito(val);
                                }else{
                                    System.out.println("Saldo insuficiente");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    break;
////////////////////////////////////////
                case 3:
                    val = banco.getSaldo();
                    System.out.println("El saldo disponible es " + val);
                    imprimir();
                    break;
                case 4:
                    res = 9;
                    break;

                case 5:
                    List<String> mov = banco.ultimaTrans();
                    mov.forEach(c -> System.out.println(c));
                    imprimir();
                    break;
                case 7:
                    System.out.println("No es horario de atencion");
                    imprimir();
                    break;

                default:
                    if (cont < 2) {
                        cont++;
                        break;
                    } else {
                        res = 9;
                        break;
                    }
            }


        } while (res != 9);


    }

    public static void imprimir(){
        System.out.println();
        System.out.println();
    }

    public static Integer validarOpcion() {
        Scanner scan = new Scanner(System.in);
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opcion invalida");
        }
        return 11;
    }

    public static Integer opcion() {

        System.out.println("Opción 1: Retirar dinero");
        System.out.println("Opción 2: Hacer depósitos");
        System.out.println("Opción 3: Estado de cuenta");
        System.out.println("Opción 4: Quejas");
        System.out.println("Opción 5: Último movimiento");
        System.out.println("Opción 7: Hablar con un asesor");
        System.out.println("Opción 9: Salir del cajero");

        return validarOpcion();
    }

    public static Integer submenu() {

        System.out.println("Opción 1) Cuenta de cheques");
        System.out.println("Opción 2) Tarjeta de crédito");
        System.out.println("Opción 3) Cuenta de terceros");

        return validarOpcion();
    }

    public static Double valorObtener() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un valor");
        try {
            return scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("No es un valor valido");
            return 0.0;
        }


    }

    public static boolean multipo(Double valor) {
        if (valor - Math.floor(valor) == 0.0) {
            return valor.intValue() % 50 == 0 || valor.intValue() % 100 == 0;

        } else {

            return false;
        }
    }


}
