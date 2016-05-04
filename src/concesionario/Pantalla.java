package concesionario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Pantalla {

    static String letrasCorrectas = "bcdfghjklmnprstvwxyz";

    public static int pideInt(String texto) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String cadnum;
        int numero = 0;
        boolean correcto;
        do {
            try {
                correcto = true;
                System.out.print(texto);
                cadnum = teclado.readLine();
                numero = Integer.parseInt(cadnum);
            } catch (NumberFormatException e) {
                System.out.println("\t\tTienes que introducir un nº: " + e);
                correcto = false;
            } catch (IOException e) {
                System.out.println("\t\tSe ha producido un error: " + e);
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }

    public static void cabecera() {
        System.out.printf("\t\t%-20s%10s%10s\n", "MODELO", "MATRICULA", "PRECIO");
        /*  
         Si queréis mostrar correctamente los datos de cada coche con printf 
         sería la siguiente intrucción:
         System.out.printf("\t\t%-20s%10s%,10d\n", modelo, matricula, precio);
         */
    }

    public static String pideCadena(String texto) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(texto);
        return teclado.nextLine();

    }

    public static void muestraMenu() {
        System.out.println("\n\n\t\t******************************************");
        System.out.println("\t\t*********** CONCESIONARIO ***********");
        System.out.println("\t\t******************************************");
        System.out.println("\t\t\t\t1.-  Compra de vehículo. (Alta)");
        System.out.println("\t\t\t\t2.-  Venta de vehículo. (Baja)");
        System.out.println("\t\t\t\t3.-  Listado completo de vehículos.");
        System.out.println("\t\t\t\t4.-  Mejor oferta.");
        System.out.println("\t\t\t\t0.-  Fin.");
    }

}
