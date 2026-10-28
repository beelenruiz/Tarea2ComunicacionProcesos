package org.tarea2.comunicacionProcesos.ejercicio4;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class GeneraAleatorios {
    static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "org.tarea2.comunicacionProcesos.ejercicio4.Aleatorios");

        try {
            Process p = pb.start();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String cadena = "";

            cadena = Entrada.cadena();

            // mientras la cadena sea distinta a "fin" recojo salida
            while (!cadena.equals("fin")){
                writer.write(cadena);
                writer.newLine();
                writer.flush();

                int salida = Integer.parseInt(reader.readLine());

                System.out.println(salida);

                cadena = Entrada.cadena();
            }

            writer.close();
            reader.close();

            p.waitFor();

        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Se interrumpió la espera.");
        }
    }
}
