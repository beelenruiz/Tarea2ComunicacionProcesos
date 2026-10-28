package org.tarea2.comunicacionProcesos.ejercicio3;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.IOException;

public class EjecutaVisualizador {
    static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "org.tarea2.comunicacionProcesos.ejercicio3.Visualizador");

        // pedir cadena
        System.out.print("Introduce una cadena: ");
        String cadena = Entrada.cadena();

        // añadimos parametros
        pb.command().add(cadena);
        pb.command().add("5");

        // la salida se mostrara por terminal (incluidos posibles errores)
        pb.inheritIO();

        try {
            Process p = pb.start();

            // lee valor de salida
            int salida = p.waitFor();

            if (salida == 1) {
                System.out.println("Cadena introducida vacía.");
                System.out.println("Valor de salida: " + salida);
                System.out.println("Final incorrecto.");
            }
            if (salida == 0) {
                System.out.println("Valor de salida: " + salida);
                System.out.println("Final correcto.");
            }

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Se interrumpió la espera.");
        }
    }
}
