package examenFinalSao;

import java.util.Scanner;

public class examenSAO151222 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Indique el tamaño del arreglo: ");
        int MAXTAM = entrada.nextInt();
        int arreglo[] = new int[MAXTAM];
        int conteo_pares = 0, conteo_impares = 0;

        System.out.println("Llene el arreglo con numeros del 11 al 20: ");
        for (int i = 0; i <= MAXTAM; i++) {
            System.out.println("Dijite un numero: ");
            arreglo[i] = entrada.nextInt();

            if (arreglo[i] % 2 == 0) { //en caso de ser par
                conteo_pares++;
            } else {    //en caso de ser impar
                conteo_impares++;
            }
        }

        //creacion de arreglos de almacenamiento de pares como de impares
        int par[] = new int[conteo_pares];
        int impar[] = new int[conteo_impares];

        conteo_pares = 0;
        conteo_impares = 0;

        //almacenamiento los numeros pares en su arreglo y los impares en el suyo
        for (int i = 0; i <= MAXTAM; i++) {
            if (arreglo[i] % 2 == 0) { //si es par
                par[conteo_pares] = arreglo[i];
                conteo_pares++;
            } else {
                impar[conteo_impares] = arreglo[i];
                conteo_impares++;
            }
        }

        System.out.print("\nArreglo pares: ");
        for (int i = 0; i < conteo_pares; i++) {
            System.out.println(par[i] + " - ");
        }

        System.out.println("");

        System.out.print("\nArreglo impares: ");
        for (int i = 0; i < conteo_impares; i++) {
            System.out.println(impar[i] + " - ");
        }
        System.out.println("");
    }
}
