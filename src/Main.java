import com.google.gson.JsonObject;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        while (true){
            Conversor conversor = new Conversor();
            System.out.println("""
                *******************************************************************
                Bienvenido/a al Conversor de Moneda =
               \s
                1) Dólar =>>Peso argentino
                2) Peso argentino =>>Dólar
                3) Dólar =>>Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>>Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir\s
                Elija una opción válida:
               \s
                *********************************************************************
               \s
               \s""");

            try {

                var numero= lectura.nextInt();

                if (numero==7){
                    break;
                } else {
                    System.out.println("Ingrese el valor que desea convertir: ");
                    var cantidad= lectura.nextDouble();
                    switch (numero){
                        case 1:
                            System.out.println(conversor.hacerConversion("USD", "ARS" , cantidad));
                            break;
                        case 2:
                            System.out.println(conversor.hacerConversion("ARS", "USD" , cantidad));
                            break;
                        case 3:
                            System.out.println(conversor.hacerConversion("USD", "BRL" , cantidad));
                            break;
                        case 4:
                            System.out.println(conversor.hacerConversion("BRL", "USD" , cantidad));
                            break;
                        case 5:
                            System.out.println(conversor.hacerConversion("USD", "COP" , cantidad));
                            break;
                        case 6:
                            System.out.println(conversor.hacerConversion("COP", "USD" , cantidad));
                            break;
                    }
                }


            } catch (Exception e){
                System.out.println(STR."Hubo un error: \{e.getMessage()}");
            }
        }

        System.out.println("Termino el programa, Gracias por participar :D");

    }
}