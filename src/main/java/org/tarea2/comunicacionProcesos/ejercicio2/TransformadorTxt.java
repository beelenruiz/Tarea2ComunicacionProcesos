package org.tarea2.comunicacionProcesos.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformadorTxt {
    static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String mensaje;
            while ((mensaje = br.readLine()) != null){
                System.out.println(mensaje.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        }
    }




}
