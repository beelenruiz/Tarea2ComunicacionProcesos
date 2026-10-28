package org.tarea2.comunicacionProcesos.ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Aleatorios {
    static void main(String[] args) {
        Random random = new Random();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (br.readLine() != null) {
                System.out.println(random.nextInt(11));
            }
        } catch (IOException e) {
            System.out.println("No se pudo iniciar el proceso: " + e.getMessage());
        }
    }
}
