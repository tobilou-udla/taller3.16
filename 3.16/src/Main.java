/*3.16 (Calculadora de la frecuencia cardiaca esperada) Mientras se ejercita,
 * puede usar un monitor de frecuencia cardiaca para ver que su corazón permanezca
 * dentro de un rango seguro sugerido por sus entrenadores y doctores.
 * De acuerdo con la Asociación Estadounidense del Corazón (AHA)
 * (www.americanheart.org/presenter. jhtml?identifier=4736),
 * la fórmula para calcular su frecuencia cardiaca máxima en pulsos por minuto es 220
 * menos su edad en años. Su frecuencia cardiaca esperada tiene un rango que está entre
 * el 50 y el 85% de su frecuencia cardiaca máxima. [Nota: estas fórmulas
 * son estimaciones proporcionadas por la AHA. Las frecuencias cardiacas
 * máxima y esperada pueden variar con base en la salud, condición física
 * y sexo del individuo. Siempre debe consultar un médico o a un profesional de la salud
 * antes de empezar o modificar un programa de ejercicios]. Cree una clase llamada
 * FrecuenciasCardiacas. Los atributos de la clase deben incluir el primer nombre de la persona,
 * su apellido y fecha de nacimiento (la cual debe consistir de atributos independientes para
 * el mes, día y año de nacimiento). Su clase debe tener un constructor que reciba estos
 * datos como parámetros. Para cada atributo debe proveer métodos establecer y obtener.
 * La clase también debe incluir un método que calcule y devuelva la edad de la persona
 * (en años), un método que calcule y devuelva la frecuencia cardiaca máxima de esa persona,
 * y otro método que calcule y devuelva la frecuencia cardiaca esperada de la persona.
 * Escriba una aplicación de Java que pida la información de la persona, cree una
 * instancia de un objeto de la clase FrecuenciasCardiacas e imprima la información
 * a partir de ese objeto (incluyendo el primer nombre de la persona, su apellido
 * y fecha de nacimiento), y que después calcule e imprima la edad de la persona en (años),
 * frecuencia cardiaca máxima y rango de frecuencia cardiaca esperada.
 *
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/*
 * Aplicación de consola (con un cuadro de diálogo final) para calcular:
 * - Edad (usando únicamente el año 2025)
 * - Frecuencia cardiaca máxima (220 - edad)
 * - Rango de frecuencia cardiaca esperada (50% - 85% de la máxima)
 *
 * Entradas: nombre, apellido, día, mes y año de nacimiento ingresados por teclado.
 * Salidas: resumen por consola y ventana informativa (JOptionPane) con FC máxima y rango.
 *
 */
import javax.swing.*;
import java.util.Scanner;

/*
 * Punto de entrada de la aplicación. Solicita los datos al usuario, crea una instancia de
 * FrecuenciasCardiacas y muestra los resultados tanto en consola como en un cuadro de diálogo.
 */
public class Main {
    /*
     * Ejecuta el flujo principal de la aplicación. Los argumentos de línea de comandos no se usan.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer nombre: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Ingrese el apellido: ");
        String apellido = sc.nextLine().trim();

        System.out.print("Ingrese el día de nacimiento (1-31): ");
        int dia = sc.nextInt();
        sc.nextLine(); // consumir fin de línea

        System.out.print("Ingrese el mes de nacimiento (1-12): ");
        int mes = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el año de nacimiento (e.g., 1990): ");
        int anio = sc.nextInt();
        sc.nextLine();

        FrecuenciasCardiacas persona = new FrecuenciasCardiacas(nombre, apellido, dia, mes, anio);

        System.out.println();
        System.out.println("===== Resumen =====");
        System.out.println("Persona: " + persona);

        int edad = persona.calcularEdad();
        System.out.println("Edad (años): " + edad);

        int fcMax = persona.frecuenciaCardiacaMaxima();
        System.out.println("Frecuencia cardiaca máxima (lpm): " + fcMax);

        double[] rango = persona.rangoFrecuenciaCardiacaEsperada();
        System.out.printf("Rango esperado (50%% - 85%%) (lpm): %.2f - %.2f%n", rango[0], rango[1]);

        JOptionPane.showMessageDialog(
                null,
                "Frecuencia cardiaca máxima (lpm): " + fcMax +
                        "\nRango esperado (50% - 85%) (lpm): " + String.format("%.2f - %.2f", rango[0], rango[1]),
                "Resultados de Frecuencia Cardiaca",
                JOptionPane.INFORMATION_MESSAGE
        );

        sc.close();
    }
}