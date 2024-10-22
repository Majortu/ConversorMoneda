import java.util.Scanner;

public class Principal {
        public static void main(String[] args) {
            Scanner lectura = new Scanner(System.in);
            boolean exit = false;
            Api exchangeAPI = new Api("11e42cf37bc0293a6e93d04e");

            while (!exit) {
                System.out.println("Menú de Conversión de Monedas");
                System.out.println("1. Convertir USD a COP");
                System.out.println("2. Convertir COP a USD");
                System.out.println("3. Convertir CAD a USD");
                System.out.println("4. Convertir CAD a COP");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                int opcion = lectura.nextInt();

                try {
                    switch (opcion) {
                        case 1:
                            System.out.print("Ingresa la cantidad de dolares: ");
                            double montoUSD = lectura.nextDouble();
                            double montoCopFromUsd = exchangeAPI.convertir(Money.USD, Money.COP, montoUSD);
                            System.out.println(montoUSD + " dolar es igual a " + montoCopFromUsd + " Pesos Colombianos");
                            break;
                        case 2:
                            System.out.print("Ingresa la cantidad de pesos colombianos: ");
                            double montoCOP = lectura.nextDouble();
                            double montoUsdFromCop = exchangeAPI.convertir(Money.COP, Money.USD, montoCOP);
                            System.out.println(montoCOP + " pesos colombianos es igual a " + montoUsdFromCop + " mis dolares");
                            break;
                        case 3:
                            System.out.print("Ingresa la cantidad de dolares canadienses: ");
                            double montoCAD = lectura.nextDouble();
                            double montoUsdFromCad = exchangeAPI.convertir(Money.CAD, Money.USD, montoCAD);
                            System.out.println(montoCAD + " dolares canadienses es igual a " + montoUsdFromCad + " dolares");
                            break;
                        case 4:
                            System.out.print("Ingresa la cantidad de dolares canadienses: ");
                            double montoCAD2 = lectura.nextDouble();
                            double montoCad2FromCop = exchangeAPI.convertir(Money.CAD, Money.COP, montoCAD2);
                            System.out.println(montoCAD2 + " dolares canadienses es igual a " + montoCad2FromCop + " pesos colombianos");
                            break;
                        case 5:
                            exit = true;
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            lectura.close();
        }
    }
