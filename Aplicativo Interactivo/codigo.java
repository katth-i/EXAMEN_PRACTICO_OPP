import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaAcademico {

    // Función para obtener la fecha actual formateada
    public static String obtenerFecha() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ahora.format(formato);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String nombreEstudiante = "No seleccionado";
        double[] notas = new double[5]; // Arreglo unidimensional
        boolean notasRegistradas = false;
        String resultadosTxt = "";

        // LISTADO DE ESTUDIANTES
        String[] listaEstudiantes = {
            "ACOSTA SOLIS HANNA AIDE", "ANDRADE SANCHEZ HUGO ALEXANDER", "ATIENCIA CHERRES JOSUE ALEXANDER",
            "BALAREZO PEREZ DIEGO SEBASTIAN", "BARRIONUEVO MONTESDEOCA JOB GABRIEL", "BEDOYA MAZO JUAN MANUEL",
            "BRAVO LOPEZ JORDAN SAMUEL", "CAJIAO VALDIVIESO PAULO ALESSANDRO", "CALVOPIÑA HERRERA BRANDON ISRAEL",
            "CASTELO BERRONES KATHERINE NICOL", "CHACHA CHANGO VICTOR MANUEL", "CHILUIZA QUISHPE DIEGO STEED",
            "DOMINGUEZ LESCANO DANIEL SEBASTIAN", "FREIRE AREBALO ALAN ANDERSON", "GUALLE AUCANSHALA ABISAG LISENIA",
            "GUAMAN CHANAHUANO HAMILTON ALEXANDER", "GUANGA ALTAMIRANO EDWIN SEBASTIAN", "GUANOTOA ESCOBAR KARLA LEONELA",
            "LANDETA TAPIA EDISON PAUL", "LARA BALSECA KAREN ARACELY", "LOOR VELEZ JHON ALEJANDRO",
            "LOPEZ SANCHEZ WASHINGTON STEVEN", "MIRANDA GARCES ALAN IMANOL", "MONAR PARCO JHAIR ALEXANDER",
            "MUYULEMA MOYOLEMA MATEO ALEXANDER", "NARVAEZ GAVILANES ANTONELLA NICOLE", "NUÑEZ ESPIN BRYAN SEBASTIAN",
            "PILCO FLORES MARIO DAVID", "POMAQUERO CHANGO KATHERINE SOLEDAD", "QUEVEDO AJON GINA ANAHI",
            "RIVADENEYRA ULLOA MATIAS SEBASTIAN", "ROCHA ROCHA CAROLINA ESTEFANIA", "SANCHEZ LEMA ISAAC ADRIAN",
            "SEGOVIA GARCIA JOSEPH ANDRE", "SUPE GARCES JOAN SEBASTIAN", "TOAPANTA IZA KEVIN MATIAS",
            "VERDESOTO AZOGUE KEVIN ALEXANDER", "VILLACRES TOALOMBO JOSUE ALEJANDRO", "VITERI CAMINO MAYDELIN SHANTAL"
        };

        // CICLO DO WHILE
        do {
            System.out.println("\n================================");
            System.out.println("      SISTEMA ACADEMICO (JAVA)");
            System.out.println("================================");
            System.out.println("Estudiante actual: " + nombreEstudiante);
            System.out.println("1. Seleccionar Estudiante");
            System.out.println("2. Operaciones básicas");
            System.out.println("3. Registro de notas");
            System.out.println("4. Guardar resultados en archivo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- LISTA DE ESTUDIANTES ---");
                    for (int i = 0; i < listaEstudiantes.length; i++) {
                        System.out.println((i + 1) + ". " + listaEstudiantes[i]);
                    }
                    System.out.print("Elija el número del estudiante: ");
                    int seleccion = Integer.parseInt(teclado.nextLine());
                    if (seleccion >= 1 && seleccion <= listaEstudiantes.length) {
                        nombreEstudiante = listaEstudiantes[seleccion - 1];
                        System.out.println("Estudiante seleccionado: " + nombreEstudiante);
                        notasRegistradas = false; // Resetear para nuevo registro
                    } else {
                        System.out.println("Selección inválida.");
                    }
                    break;

                case 2:
                    System.out.print("\nIngrese número 1: ");
                    double n1 = Double.parseDouble(teclado.nextLine());
                    System.out.print("Ingrese número 2: ");
                    double n2 = Double.parseDouble(teclado.nextLine());

                    System.out.println("\nRESULTADOS:");
                    System.out.println("Suma: " + n1 + " + " + n2 + " = " + (n1 + n2));
                    System.out.println("Resta: " + n1 + " - " + n2 + " = " + (n1 - n2));
                    System.out.println("Multiplicación: " + n1 + " * " + n2 + " = " + (n1 * n2));
                    if (n2 != 0) {
                        System.out.println("División: " + n1 + " / " + n2 + " = " + (n1 / n2));
                    } else {
                        System.out.println("División: Error (División por cero)");
                    }
                    break;

                case 3:
                    if (nombreEstudiante.equals("No seleccionado")) {
                        System.out.println("\nError: Primero seleccione un estudiante.");
                        break;
                    }
                    double suma = 0;
                    int aprobados = 0, reprobados = 0;
                    System.out.println("\n--- REGISTRO DE NOTAS PARA: " + nombreEstudiante + " ---");
                    
                    for (int i = 0; i < 5; i++) {
                        while (true) {
                            System.out.print("Ingrese nota " + (i + 1) + " (0-10): ");
                            double nota = Double.parseDouble(teclado.nextLine());
                            if (nota >= 0 && nota <= 10) {
                                notas[i] = nota;
                                suma += nota;
                                if (nota >= 7) aprobados++; else reprobados++;
                                break;
                            } else {
                                System.out.println("Nota inválida. Intente de nuevo.");
                            }
                        }
                    }

                    double promedio = suma / 5;
                    String estado = (promedio >= 7) ? "APROBADO" : "REPROBADO";

                    System.out.println("\nRESULTADOS:");
                    System.out.println("PROMEDIO: " + promedio + " (" + estado + ")");
                    System.out.println("APROBADOS: " + aprobados + " | REPROBADOS: " + reprobados);

                    // Preparar texto para el archivo
                    resultadosTxt = "Promedio: " + promedio + " [" + estado + "]\n"
                                  + "Aprobados: " + aprobados + "\n"
                                  + "Reprobados: " + reprobados + "\n";
                    notasRegistradas = true;
                    break;

                case 4:
                    if (!notasRegistradas) {
                        System.out.println("\nError: Debe registrar notas antes de guardar.");
                    } else {
                        try (FileWriter fw = new FileWriter("resultados.txt", true);
                             PrintWriter pw = new PrintWriter(fw)) {
                            
                            pw.println("ESTUDIANTE: " + nombreEstudiante);
                            pw.println("FECHA: " + obtenerFecha() + " | LENGUAJE: Java");
                            pw.print(resultadosTxt);
                            pw.println("--------------------------------");
                            
                            System.out.println("\nDatos de " + nombreEstudiante + " guardados exitosamente.");
                        } catch (IOException e) {
                            System.out.println("Error al escribir en el archivo: " + e.getMessage());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        teclado.close();
    }
}