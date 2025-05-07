import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String cadena1 = "";
        String cadena2 = "";
        int seleccion =1;

            while (seleccion>=1 & seleccion<=7){
                if (seleccion == 7) {

                    System.out.println("Programa finalizado, gracias por usar nuestro Conversor de Moneda");
                    break;
                }else {
                    System.out.println("Sea bienvenido/a al Conversor de Moneda: ");
                    System.out.println(" ");
                    System.out.println("1- Dolar -> Peso Argentino");
                    System.out.println("2- Peso Argentino -> Dolar");
                    System.out.println("3- Dolar -> Real Brasileño");
                    System.out.println("4- Real Brasileño -> Dolar");
                    System.out.println("5- Dolar ->Peso Colombiano");
                    System.out.println("6- Peso Colombiano -> Dolar");
                    System.out.println(" ");
                    System.out.println("7- Salir ");

                    Scanner leer = new Scanner(System.in);
                    ConsultaApi consulta = new ConsultaApi();
                    System.out.println("ingrese su opción de 1 a 7");
                    seleccion = leer.nextInt();

                    if (seleccion >= 1 & seleccion <= 7) {
                        System.out.println("su opción: " + seleccion);
                        switch (seleccion) {
                            case 1:
                                cadena1 = "USD";
                                cadena2 = "ARS";
                                System.out.println(cadena2);
                                break;
                            case 2:
                                cadena1 = "ARS";
                                cadena2 = "USD";
                                break;
                            case 3:
                                cadena1 = "USD";
                                cadena2 = "BRL";
                                break;
                            case 4:
                                cadena1 = "BRL";
                                cadena2 = "USD";
                                break;
                            case 5:
                                cadena1 = "USD";
                                cadena2 = "COP";
                                break;
                            case 6:
                                cadena1 = "COP";
                                cadena2 = "USD";
                                break;
                            default:
                                break;
                        }

                        Moneda valor3 = consulta.buscaCambio(cadena1, cadena2);
                        System.out.println(valor3);
                    } else {
                        System.out.println("opción: no corresponde" + seleccion);
                    }
                }
            }
    }
}
