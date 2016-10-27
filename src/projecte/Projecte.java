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
        Scanner entrada = new Scanner(System.in);
        int pes = 0;
        double mida = 0, salari = 0;
        String nom = null, nacionalitat = null, equip = null;
        boolean titular = false, omplit =false;

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
   

            switch (opcio = entrada.nextInt()) {

                case 1:

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
    
    

