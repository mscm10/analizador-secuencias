package src;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {


    // Lee y retorna un arreglo de tamaño n
    public static int[] leerArreglo(int n) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el elemento #" + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }
        return a;
    }

    // Retorna true si x es primo (>1)
    public static boolean esPrimo(int x) {
        if (x <= 1) return false;     // por definición, primos > 1
        if (x == 2) return true;
        if (x % 2 == 0) return false; // evita pares mayores

        // probar divisores impares hasta la raíz
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    // Devuelve cuántos primos hay en el arreglo
    public static int contarPrimos(int[] a) {
        int count = 0;
        for (int x : a) {
            if (esPrimo(x)) {
                count++;
            }
        }
        return count;
    }

    // Devuelve el valor máximo del arreglo
    public static int maximo(int[] a) {
        int max = a[0];
        for (int x : a) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    // Devuelve las posiciones donde aparece el máximo
    public static int[] indicesDeMaximo(int[] a) {
        int max = maximo(a);

        // Primera pasada: contar cuántas veces aparece
        int count = 0;
        for (int x : a) {
            if (x == max) count++;
        }

        // Segunda pasada: guardar los índices
        int[] indices = new int[count];
        int pos = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                indices[pos] = i;
                pos++;
            }
        }
        return indices;
    }

    // Retorna true si el arreglo es capicúa
    public static boolean esCapicua(int[] a) {
        int i = 0, j = a.length - 1;

        while (i < j) {
            if (a[i] != a[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    // ---------------------------
    // ---------- MAIN -----------
    // ---------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese N (5 a 50): ");
        int n = sc.nextInt();

        // Validación de tamaño
        if (n < 5 || n > 50) {
            System.out.println("ERROR: N debe estar entre 5 y 50.");
            return;
        }

        // Leer arreglo
        int[] arreglo = leerArreglo(n);

        System.out.println("\nArreglo ingresado: " + Arrays.toString(arreglo));

        // Resultados
        int cantPrimos = contarPrimos(arreglo);
        int max = maximo(arreglo);
        int[] indicesMax = indicesDeMaximo(arreglo);
        boolean capicua = esCapicua(arreglo);

        System.out.println("Cantidad de números primos: " + cantPrimos);
        System.out.println("Valor máximo del arreglo: " + max);
        System.out.println("Índices donde aparece el máximo: " + Arrays.toString(indicesMax));
        System.out.println("¿Es capicúa?: " + (capicua ? "Sí" : "No"));
    }
    

}
    


    
    



