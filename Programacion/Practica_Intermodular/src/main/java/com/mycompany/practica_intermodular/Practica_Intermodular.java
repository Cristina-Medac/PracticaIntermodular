package com.mycompany.practica_intermodular;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica_Intermodular {

    public static void main(String[] args) {

        ArrayList<Pais> listaPaisesElegidos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int indice = 1;
        int eleccion = 0;
        int eleccion2 = 0;
        String eleccion3 = "";

        // Bucle para que el menu se repita siempre hasta que el usuario decida cerrarlo
        while (eleccion != 6) {
            // "try" dentro del bucle para que en caso de excepcion se vuelva al menu principal y no termine el programa
            try {
                // Conexion con la BBDD
                DataBaseManager dbm = new DataBaseManager();
                // Accedemos y guardamos los datos de los continentes
                ArrayList<Continente> listaContinentes = dbm.continentes();
                // Accedemos y guardamos los datos de los paises y sus curiosidades
                ArrayList<Pais> listaPaises = dbm.paises();
                // Limpiamos este arrayList para poder seguir eligiendo paises
                listaPaisesElegidos.clear();

                /*Menu para seleccionar continentes*/
                System.out.println("<-----Bienvenido al explorador de regiones de nuestro planeta!----->");
                System.out.println("Elige el continente que quieras consultar:");
                System.out.println("1. Africa");
                System.out.println("2. Europa");
                System.out.println("3. Asia");
                System.out.println("4. America");
                System.out.println("5. Oceania");
                System.out.println("6. Apagar el programa");
                System.out.print("Tu eleccion: ");
                eleccion = Integer.parseInt(sc.nextLine());
                System.out.println("<------------------------->");
                // Condicional para determinar cuando cerrar el programa
                if (eleccion == 6) {
                    System.out.println("De acuerdo, cerrando el programa. Nos vemos en otra!");
                    dbm.cerrarSesion();
                } else {
                    System.out.println("Informacion de " + listaContinentes.get(eleccion - 1).getNombre() + ": ");
                    System.out.println("Este continente tiene unos " + listaContinentes.get(eleccion - 1).getSuperficie() + " millones de km2 aproximadamente");
                    System.out.println("Tiene un clima mayormente " + listaContinentes.get(eleccion - 1).getClima());
                    System.out.println("Tiene un total de " + listaContinentes.get(eleccion - 1).getNumeroPaises() + " paises");
                    System.out.println("Que pais quieres consultar dentro de este continente:");

                    // Bucle para mostrar los paises dentro del continente elegido
                    for (int i = 0; i < listaPaises.size(); i++) {
                        // Hacemos coincidir la eleccion del usuario con la clave foranea de los paises que los relaciona con sus continentes
                        if (listaPaises.get(i).getIdCont() == eleccion) {
                            // Guardamos los paises que conciden en una lista para mostrarlos y poder seleccionarlos
                            listaPaisesElegidos.add(listaPaises.get(i));
                            System.out.println(indice + ". " + listaPaises.get(i).getNombre());
                            indice++;
                        }
                    }
                    // Reseteamos el indice de los paises que se le muestran al usuario para que se muestren bien en los siguientes ciclos
                    indice = 1;
                    System.out.println("4. Volver al menu principal");
                    System.out.print("Tu eleccion: ");
                    eleccion2 = Integer.parseInt(sc.nextLine());
                    System.out.println("<------------------------->");

                    /*Menu para seleccionar paises*/
                    if (eleccion2 != 4) {
                        System.out.println("Informacion  de " + listaPaisesElegidos.get(eleccion2 - 1).getNombre() + ": ");
                        System.out.println("Tiene unos " + listaPaisesElegidos.get(eleccion2 - 1).getPoblacion() + " millones de habitantes");
                        System.out.println("El idioma principal de esta region es el " + listaPaisesElegidos.get(eleccion2 - 1).getIdioma());

                        /* Decision para mostrar curiosidades del pais elegido */
                        System.out.println("Quieres ver curiosidades de " + listaPaisesElegidos.get(eleccion2 - 1).getNombre() + "(Si/No)");
                        eleccion3 = sc.nextLine();
                        if (eleccion3.equalsIgnoreCase("Si")) {
                            System.out.println("<------------------------->");
                            System.out.println("Curiosidades de " + listaPaisesElegidos.get(eleccion2 - 1).getNombre() + ": ");
                            System.out.println("Uno de los platos principales es " + listaPaisesElegidos.get(eleccion2 - 1).getListaCuriosidades().getGastronomia());
                            System.out.println("Algo curioso de este pais: " + listaPaisesElegidos.get(eleccion2 - 1).getListaCuriosidades().getHistoria());
                            System.out.println("Un dia festivo destacado es: " + listaPaisesElegidos.get(eleccion2 - 1).getListaCuriosidades().getFiesta());
                            System.out.println("<------------------------->");
                            System.out.println("Hemos terminado esta vuelta. Volvemos al menu principal para seguir explorando el mundo");
                        // Decidir no querer ver curiosidades del pais
                        } else {
                            System.out.println("Estupendo. Volvemos al punto de partida");
                        }
                    // Decidir no querer ver ningun pais del continente
                    } else {
                        System.out.println("Estupendo. Volvemos al punto de partida");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error en la base de datos: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un numero. Volvemos al menu principal y por favor introduce numeros esta vez");
            }
        }
    }
}