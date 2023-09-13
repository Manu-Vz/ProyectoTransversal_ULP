
package AccesoADatos;

import java.util.Scanner;

public class AccesoInscripcion {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("¡Bienvenido al sistema de inscripción!");
            // Solicitar información del estudiante
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            
            scanner.nextLine(); // Limpia el buffer
            System.out.print("Correo electrónico: ");
            
            String correoElectronico = scanner.nextLine();
            // Mostrar la información del estudiante
            System.out.println("\nResumen de la inscripción:");
            System.out.println("Nombre: " + nombre + " " + apellido);
            System.out.println("Edad: " + edad);
            System.out.println("Correo electrónico: " + correoElectronico);
            // Realizar acciones adicionales según tus necesidades
            // Por ejemplo, guardar la información en una base de datos o archivo.
            System.out.println("\n¡Inscripción exitosa!");
            // Cierra el scanner
        }
    }
}

