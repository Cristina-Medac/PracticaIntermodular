package com.mycompany.practica_intermodular;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica_Intermodular {

    public static void main(String[] args) {
        
        try {
        DataBaseManager dbm = new DataBaseManager();
        

        ArrayList<Continente> listaContinentes = dbm.continentes();
        ArrayList<Pais> listaPaises = dbm.paises();
        ArrayList<Curiosidad> listaCuriosidades = dbm.curiosidades();
            for (int i = 0; i < listaContinentes.size(); i++) {
                System.out.println(listaContinentes.get(i).getNombre());
            }
            
            for (int i = 0; i < listaPaises.size(); i++) {
                System.out.println(listaPaises.get(i).getNombre());
            }
            
            for (int i = 0; i < listaCuriosidades.size(); i++) {
                System.out.println(listaCuriosidades.get(i).getHistoria());
            }
            
        } catch (SQLException e) {
            System.out.println("Error con la base de datos");
        }
        
        /*
            - Preguntar a Dani sobre la clase "Sistema informativo" del enunciado del proyecto
            - Investigar menu (guiandose con lo de abajo) que se base en llamar a metodos de las clases
            - Basicamente a cada eleccion del usuario se podria llamar a un metodo
            - Investigar como leer base de datos y crear objetos con los datos
            - Manager puede ser sistema informativo
        */
        
        /*
        Scanner sc = new Scanner(System.in);
        String menu1 = "0";
        String menu2 = "0";
        String menu3 = "0";
        String eleccion;
        String paisElegido;
        
        do  {
             
            System.out.println("Elige que quieres hacer:");
            System.out.println("1. Ver continentes");
            System.out.println("2. Ver paises");
            System.out.println("3. Ver curiosidades");
            System.out.println("4. Cerrar el programa");
            System.out.print("Tu eleccion: ");
            menu1 = sc.nextLine();
            
            // A partir de aqui podria ser un metodo
            if(menu1.equals("1")){
                
                System.out.println("Que continente quieres ver:");
                System.out.println("1. Europa");
                System.out.println("2. Asia");
                System.out.println("3. America");
                System.out.println("4. Africa");
                System.out.println("5. Oceania");
                System.out.println("6. Volver al menu anterior");
                System.out.print("Tu eleccion: ");
                menu2 = sc.nextLine();
                
                // A partir de aqui podria ser otro metodo
                if(menu2.equals("1")) {
                    
                    System.out.println("En europa hay europeos");
                    // Esta eleccion se puede suprimir. Indagar despues
                    System.out.println("Quieres ver paises europeos?");
                    System.out.print("Tu respuesta: ");
                    eleccion = sc.nextLine();
                    // Esto podria ser otra funcion tambien
                    if (eleccion.equals("Si")) {
                        
                        System.out.println("De qué pais quieres ver información: ");
                        System.out.println("Pais 1");
                        System.out.println("Pais 2");
                        System.out.print("Tu eleccion: ");
                        paisElegido = sc.nextLine();
                        
                    }
                    
                    
                } else if (menu2.equals("6")) {
                    System.out.println("Volviendo al menu anterior");
                    System.out.println("<--------------------->");
                }
                
            } else if (menu1.equals("4")) {
                System.out.println("Cerrando programa");
                System.out.println("<----------------->");
            }
                
            } while (!menu1.equals("4"));
        
        
        
        
        
        /* switch (menu1) {
            case "0":
                
                System.out.println("Elige que quieres hacer:");
                System.out.println("1. Ver continentes");
                System.out.println("2. Ver paises");
                System.out.println("3. Ver curiosidades");
                System.out.println("4. Cerrar el programa");
                System.out.print("Tu eleccion: ");
                menu1 = sc.nextLine();
                break;
               
                
            case "1":
                
                System.out.println("Que continente quieres ver:");
                System.out.println("1. Europa");
                System.out.println("2. Asia");
                System.out.println("3. America");
                System.out.println("4. Africa");
                System.out.println("5. Oceania");
                System.out.println("6. Volver al menu anterior");
                System.out.print("Tu eleccion: ");
                menu2 = sc.nextLine();
                
                if(menu2.equals("1")) {
                    
                    System.out.println("En Europa hay europeos");
                    
                    
                }
                menu1 = "0";
                break;
                
                
                
            default:
                throw new AssertionError();
        } */
        
    }
}
