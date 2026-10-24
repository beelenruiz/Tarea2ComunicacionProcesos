package org.tarea2.comunicacionProcesos.ejercicio2;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class LectorTxt {
    static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "org.tarea2.comunicacionProcesos.ejercicio2.TransformadorTxt");
        pb.redirectErrorStream(true);

        try {
            Process p = pb.start();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String msg;
            do {
                System.out.print("Introduce un mensaje ('fin' para terminar): ");
                msg = Entrada.cadena();

                // mandamos cadena al hijo por entrada estandar
                writer.write(msg);
                writer.newLine();
                writer.flush();

                // leemos salida standar del hijo
                String respuesta = reader.readLine();

                System.out.println(respuesta);

            } while (!msg.equals("fin"));

            // cerramos buffers
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
