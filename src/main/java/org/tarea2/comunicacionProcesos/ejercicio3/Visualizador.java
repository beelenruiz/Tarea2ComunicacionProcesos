package org.tarea2.comunicacionProcesos.ejercicio3;

public class Visualizador {
    static void main(String[] args) {
        if (args.length < 2){
            System.err.println("El proceso necesita dos parametros para ejecutar.");
        }

        String cadena = null;
        int num = 0;

        // comprobamos si la cadena esta vacia
        cadena = args[0];
        if (cadena.trim().isEmpty()) System.exit(1);

        // comprobamos el numero de repeticiones
        try {
            num = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("El número de veces no es valido");
        }

        for (int i = 1; i < num; i++){
            System.out.println(i + ". " + cadena);
        }
        System.exit(0);
    }
}
