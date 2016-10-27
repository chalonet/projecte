/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class Projecte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ent = new Scanner(System.in);
        int pes = 0;
        double mida = 0, salari = 0;
        String nom = null, nacionalitat = null, equip = null;
        boolean titular = false, omplert = false;

        //Variable del menú
        int opcio;

        //Menu de l'aplicació 
        do {
            System.out.println("-------- Menú jugadors de futbol--------");

            System.out.println(" 0.Sortir");

            System.out.println(" 1.Afegir jugador");

            System.out.println(" 2.Borrar jugador");

            System.out.println(" 3.Modificar jugador");

            System.out.println(" 4.Llistar jugadors");
            
            System.out.println("----------------------------------------");

            switch (opcio = ent.nextInt()) {

                case 1:
                    if (!omplert) { //omplert = false
                        System.out.println("Introdueix el nom del jugador");
                        nom = ent.next();
                        System.out.println("Introdueix la nacionalitat");
                        nacionalitat = ent.next();
                        System.out.println("Introdueix l'equip");
                        equip = ent.next();
                        System.out.println("Introdueix el pes");
                        pes = ent.nextInt();
                        System.out.println("Introdueix la mida");
                        mida = ent.nextDouble();
                        System.out.println("Introdueix el salari");
                        salari = ent.nextDouble();
                        System.out.println("Digues si es titular o no.");
                        titular = ent.nextBoolean();
                        omplert = true;
                    } else {
                        System.out.println("Ja has introduït totes les dades.");
                    }

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                default:

                    System.out.println("L'operació no és valida");
                    break;
            }

        } while (opcio != 0);

    }
}
