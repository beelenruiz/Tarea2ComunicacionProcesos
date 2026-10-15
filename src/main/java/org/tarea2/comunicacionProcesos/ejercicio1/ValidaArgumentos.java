package org.tarea2.comunicacionProcesos.ejercicio1;

public class ValidaArgumentos {
    public static void main(String[] args) {
        String[] valor = args;

        // numero de argumentos menor que 1
        if (args.length < 1) System.exit(1);

        try {
            // el argumento es un numero menos que 0
            int numero = Integer.parseInt(args[0]);
            if (numero < 0) {
                System.exit(3);
            }

            // otro, es decir, numero mayor que 0
            System.exit(4);

        } catch (NumberFormatException e) {
            // el argumento e suna cadena
            System.exit(2);
        }
    }
}
