/**
 * Modelo para calcular frecuencia cardiaca máxima y rango esperado de una persona.
 * Fórmulas (AHA):
 * - Frecuencia cardiaca máxima: 220 - edad.
 * - Rango esperado: 50% a 85% de la frecuencia máxima.
 */
public class FrecuenciasCardiacas {
    /** Primer nombre de la persona. */
    private String nombre;
    /** Apellido de la persona. */
    private String apellido;
    /** Día de nacimiento (1-31). */
    private int diaNacimiento;
    /** Mes de nacimiento (1-12). */
    private int mesNacimiento;
    /** Año de nacimiento (p. ej., 1990). */
    private int anioNacimiento;

    /** Constructor por defecto. */
    public FrecuenciasCardiacas() {
    }

    /**
     * Constructor con datos completos: nombre, apellido, día (1-31), mes (1-12) y año (p. ej., 1990).
     */
    public FrecuenciasCardiacas(String nombre, String apellido, int diaNacimiento, int mesNacimiento, int anioNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
    }

    /**
     * Obtiene el primer nombre de la persona (primer nombre).
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el primer nombre de la persona (nuevo primer nombre).
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona (nuevo apellido).
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el día de nacimiento (1-31).
     */
    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    /**
     * Establece el día de nacimiento (1-31).
     */
    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    /**
     * Obtiene el mes de nacimiento (1-12).
     */
    public int getMesNacimiento() {
        return mesNacimiento;
    }

    /**
     * Establece el mes de nacimiento (1-12).
     */
    public void setMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    /**
     * Obtiene el año de nacimiento.
     */
    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    /**
     * Establece el año de nacimiento (nuevo año).
     */
    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    /**
     * Calcula y devuelve la edad en años completos usando exclusivamente el año de referencia 2025.
     * Si el año es inválido (<= 0 o > 2025) la edad será 0. Retorna un entero no negativo.
     */
    public int calcularEdad() {
        int anioActual = 2025;
        int edad = 0;
        if (anioNacimiento > 0 && anioNacimiento <= anioActual) {
            edad = anioActual - anioNacimiento;
        }
        return edad;
    }

    /**
     * Calcula la frecuencia cardiaca máxima usando la fórmula 220 - edad.
     * Devuelve la frecuencia en latidos por minuto (lpm), nunca negativa.
     */
    public int frecuenciaCardiacaMaxima() {
        int edad = calcularEdad();
        int maxima = 220 - edad;
        return Math.max(0, maxima);
    }

    /**
     * Calcula el rango esperado de la frecuencia cardiaca (50% - 85% de la máxima).
     * Devuelve un arreglo de tamaño 2: [min, max] en lpm.
     */
    public double[] rangoFrecuenciaCardiacaEsperada() {
        int maxima = frecuenciaCardiacaMaxima();
        double min = maxima * 0.50;
        double max = maxima * 0.85;
        return new double[]{min, max};
    }

    /**
     * Representación legible con nombre completo y fecha en formato dd/mm/aaaa.
     */
    public String toString() {
        String fecha = String.format("%02d/%02d/%04d", diaNacimiento, mesNacimiento, anioNacimiento);
        return nombre + " " + apellido + " (Nacimiento: " + fecha + ")";
    }
}
