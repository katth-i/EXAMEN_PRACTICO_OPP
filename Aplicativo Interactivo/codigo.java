import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Codigo {
1

    // FUNCION PARA OBTENER FECHA
    public static String obtenerFecha() {

        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd HH:mm:ss");

        return ahora.format(formato);
    }

    public static void main(String[] args) {

        try (Scanner teclado = new Scanner(System.in)) {

            int opcion = 0;

            String nombreEstudiante = "No seleccionado";

            double[] notas = new double[5];

            boolean notasRegistradas = false;

            String resultadosTxt = "";

            String estado = "SIN SUBIR NOTAS";

            String[] listaEstudiantes = {

                    "ACOSTA SOLIS HANNA AIDE",
                    "ANDRADE SANCHEZ HUGO ALEXANDER",
                    "ATIENCIA CHERRES JOSUE ALEXANDER",
                    "BALAREZO PEREZ DIEGO SEBASTIAN",
                    "BARRIONUEVO MONTESDEOCA JOB GABRIEL",
                    "BEDOYA MAZO JUAN MANUEL",
                    "BRAVO LOPEZ JORDAN SAMUEL",
                    "CAJIAO VALDIVIESO PAULO ALESSANDRO",
                    "CALVOPIÑA HERRERA BRANDON ISRAEL",
                    "CASTELO BERRONES KATHERINE NICOL",
                    "CHACHA CHANGO VICTOR MANUEL",
                    "CHILUIZA QUISHPE DIEGO STEED",
                    "DOMINGUEZ LESCANO DANIEL SEBASTIAN",
                    "FREIRE AREBALO ALAN ANDERSON",
                    "GUALLE AUCANSHALA ABISAG LISENIA",
                    "GUAMAN CHANAHUANO HAMILTON ALEXANDER",
                    "GUANGA ALTAMIRANO EDWIN SEBASTIAN",
                    "GUANOTOA ESCOBAR KARLA LEONELA",
                    "LANDETA TAPIA EDISON PAUL",
                    "LARA BALSECA KAREN ARACELY",
                    "LOOR VELEZ JHON ALEJANDRO",
                    "LOPEZ SANCHEZ WASHINGTON STEVEN",
                    "MIRANDA GARCES ALAN IMANOL",
                    "MONAR PARCO JHAIR ALEXANDER",
                    "MUYULEMA MOYOLEMA MATEO ALEXANDER",
                    "NARVAEZ GAVILANES ANTONELLA NICOLE",
                    "NUÑEZ ESPIN BRYAN SEBASTIAN",
                    "PILCO FLORES MARIO DAVID",
                    "POMAQUERO CHANGO KATHERINE SOLEDAD",
                    "QUEVEDO AJON GINA ANAHI",
                    "RIVADENEYRA ULLOA MATIAS SEBASTIAN",
                    "ROCHA ROCHA CAROLINA ESTEFANIA",
                    "SANCHEZ LEMA ISAAC ADRIAN",
                    "SEGOVIA GARCIA JOSEPH ANDRE",
                    "SUPE GARCES JOAN SEBASTIAN",
                    "TOAPANTA IZA KEVIN MATIAS",
                    "VERDESOTO AZOGUE KEVIN ALEXANDER",
                    "VILLACRES TOALOMBO JOSUE ALEJANDRO",
                    "VITERI CAMINO MAYDELIN SHANTAL"
            };

            do {

                System.out.println("\n================================");
                System.out.println("      SISTEMA ACADEMICO");
                System.out.println("================================");

                System.out.println("Estudiante actual: " + nombreEstudiante);
                System.out.println("Estado: " + estado);

                System.out.println("\n1. Seleccionar estudiante");
                System.out.println("2. Operaciones basicas");
                System.out.println("3. Registro de notas");
                System.out.println("4. Guardar resultados");
                System.out.println("5. Salir");

                System.out.print("\nSeleccione una opcion: ");

                try {
                    opcion = Integer.parseInt(teclado.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debe ingresar numeros.");
                    continue;
                }

                switch (opcion) {

                    case 1 -> {

                        System.out.println("\n===== LISTA DE ESTUDIANTES =====");

                        for (int i = 0; i < listaEstudiantes.length; i++) {
                            System.out.println((i + 1) + ". " + listaEstudiantes[i]);
                        }

                        System.out.print("\nSeleccione estudiante: ");

                        try {

                            int seleccion = Integer.parseInt(teclado.nextLine());

                            if (seleccion >= 1 && seleccion <= listaEstudiantes.length) {

                                nombreEstudiante = listaEstudiantes[seleccion - 1];
                                notasRegistradas = false;
                                estado = "SIN SUBIR NOTAS";

                            } else {
                                System.out.println("Numero fuera de rango.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese numeros validos.");
                        }
                    }

                    case 2 -> {

                        try {

                            System.out.print("\nIngrese numero 1: ");
                            double n1 = Double.parseDouble(teclado.nextLine());

                            System.out.print("Ingrese numero 2: ");
                            double n2 = Double.parseDouble(teclado.nextLine());

                            System.out.println("\n===== RESULTADOS =====");

                            System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
                            System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
                            System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));

                            if (n2 != 0) {
                                System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
                            } else {
                                System.out.println("No se puede dividir para cero.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese numeros validos.");
                        }
                    }

                    case 3 -> {

                        if (nombreEstudiante.equals("No seleccionado")) {

                            System.out.println("\nPrimero seleccione estudiante.");

                        } else {

                            double suma = 0;

                            int aprobados = 0;
                            int reprobados = 0;

                            System.out.println("\n===== REGISTRO DE NOTAS =====");

                            for (int i = 0; i < 5; i++) {

                                while (true) {

                                    try {

                                        System.out.print("Ingrese nota " + (i + 1) + " (0-10): ");
                                        double nota = Double.parseDouble(teclado.nextLine());

                                        if (nota >= 0 && nota <= 10) {

                                            notas[i] = nota;
                                            suma += nota;

                                            if (nota >= 7) aprobados++;
                                            else reprobados++;

                                            break;

                                        } else {
                                            System.out.println("La nota debe estar entre 0 y 10.");
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Ingrese numeros validos.");
                                    }
                                }
                            }

                            double promedio = suma / 5;

                            double mayor = notas[0];
                            double menor = notas[0];

                            for (int i = 1; i < 5; i++) {
                                if (notas[i] > mayor) mayor = notas[i];
                                if (notas[i] < menor) menor = notas[i];
                            }

                            if (promedio >= 7) estado = "APROBADO";
                            else estado = "REPROBADO";

                            resultadosTxt =
                                    "Promedio: " + promedio + "\n"
                                    + "Nota mayor: " + mayor + "\n"
                                    + "Nota menor: " + menor + "\n"
                                    + "Aprobados: " + aprobados + "\n"
                                    + "Reprobados: " + reprobados + "\n"
                                    + "Estado: " + estado + "\n";

                            notasRegistradas = true;
                        }
                    }

                    case 4 -> {

                        System.out.println("\n--- Guardando Resultados ---");

                        if (!notasRegistradas) {

                            System.out.println("No hay notas registradas.");

                        } else {

                            try {

                                String carpeta = "Archivos";
                                String archivo = "resultados.txt";

                                java.io.File dir = new java.io.File(carpeta);

                                if (!dir.exists()) {
                                    dir.mkdirs();
                                }

                                FileWriter fw = new FileWriter(carpeta + "/" + archivo, true);
                                PrintWriter pw = new PrintWriter(fw);

                                pw.println("================================");
                                pw.println("ESTUDIANTE: " + nombreEstudiante);
                                pw.println("FECHA: " + obtenerFecha());
                                pw.println("LENGUAJE: JAVA");
                                pw.println(resultadosTxt);
                                pw.println("================================");

                                pw.close();

                                System.out.println("Guardado correctamente en Archivos/resultados.txt");

                            } catch (IOException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                    }

                    case 5 -> System.out.println("\nSaliendo del sistema...");

                    default -> System.out.println("\nOpcion invalida.");
                }

            } while (opcion != 5);
        }
    }
}