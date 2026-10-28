package org.tarea2.comunicacionProcesos.ejercicio1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.List;

public class EjecutaValidaArgumentos {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "org.tarea2.comunicacionProcesos.ejercicio1.ValidaArgumentos");

        // mostrará errores por consola, si los hay
        pb.inheritIO();

        try {
            // escribimos el valor en los parametros del proceso hijo
            pb.command().add("hola");

            // iniciamos
            Process p = pb.start();

            // recogemos la salida de System.exit
            int respuesta = p.waitFor();

            System.out.println("Valor de salida: " + respuesta);
            switch (respuesta){
                case 1:
                    System.out.println("No hay argumentos...");
                    break;
                case 2:
                    System.out.println("Es una cadena...");
                    break;
                case 3:
                    System.out.println("Número menor que 0...");
                    break;
                case 4:
                    System.out.println("Número mayor o igual que 0...");
                    break;
            }

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Se interrumpió la espera.");
        }
    }
}
