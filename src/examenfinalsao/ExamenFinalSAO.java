package examenfinalsao;

import java.util.Random;

public class ExamenFinalSAO {

    public static void main(String[] args) {

        int[][] youtubers = generarYoutubers(10);
        imprimirYoutubers(youtubers);
        System.out.println();
        int youtuberMasRentable = calMasRentable(youtubers);
        System.out.println("El youtuber mas rentable es el nro:" + youtuberMasRentable);
        System.out.println();
        double promedioReproducciones = calPromedioReproducciones(youtubers, 200000);
        System.out.printf("El numero promedio de reproducciones de los youtubers con más de 200000 suscriptores es: %.2f%n", promedioReproducciones);
        System.out.println();
    }
//MODULO QUE GENERA LOS DATOS ALEATORIOS PARA CADA UNOS DE LOS 10 YOUTUBERS Y ALMACENA EN LOS 3 ARREGLOS

    public static int[][] generarYoutubers(int cantidad) {
        int[][] youtubers = new int[cantidad][3];
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            youtubers[i][0] = random.nextInt(300000 - 1000 + 1) + 1000; //suscripciones
            youtubers[i][1] = random.nextInt(30000000 - 300000 + 1) + 300000; //reproducciones
            youtubers[i][2] = random.nextInt(20000000 - 100000 + 1) + 100000; //ganancias

        }
        return youtubers;
    }
//RETORNA LOS DATOS OBTENIDOS CONCATENADOS

    public static void imprimirYoutubers(int[][] youtubers) {
        for (int i = 0; i < youtubers.length; i++) {
            System.out.println("Youtuber nro " + (i + 1) + ": " + youtubers[i][0] + " suscriptores, " + youtubers[i][1] + " reproducciones, $" + youtubers[i][2] + " de ganancias anuales.");

        }
    }

//MODULO QUE CALCULA LA RENTABILIDAD DE CADA YOUTUBER
    public static int calMasRentable(int[][] youtubers) {
        int youtuberMasRentable = 0;
        double rentabilidadMax = youtubers[0][2] / (double) youtubers[0][0];
        for (int i = 1; i < youtubers.length; i++) {
            double rentabilidadActual = youtubers[i][2] / (double) youtubers[i][0];
            if (rentabilidadActual > rentabilidadMax) {
                rentabilidadMax = rentabilidadActual;
                youtuberMasRentable = i;
            }
        }
        return youtuberMasRentable + 1; //sumo 1 para mostrar el numero de youtuber en lugar de su indice
    }
//MODULO QUE CALCULA EL PROMEDIO DE REPRODUCCIONES DE QUIENES TENGAN MAS DE 200.000 SUBS

    public static double calPromedioReproducciones(int[][] youtubers, int subsMinimos) {
        int totalReproducciones = 0;
        int cantidadYoutubers = 0;
        for (int i = 0; i < youtubers.length; i++) {
            if (youtubers[i][0] > subsMinimos) {
                totalReproducciones += youtubers[i][1];
                cantidadYoutubers++;
            }
        }
        return totalReproducciones / (double) cantidadYoutubers;
    }

}
