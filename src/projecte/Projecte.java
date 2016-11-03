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
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ent = new Scanner(System.in);
        int pes = 0;
        double mida = 0, salari = 0;
        String nom = null, nacionalitat = null, equip = null;
        boolean titular = false, omplert = false;
        char veure, titularChar, mostrar;

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
                        System.out.println("Introdueix l'alçada");
                        mida = ent.nextDouble();
                        System.out.println("Introdueix el salari");
                        salari = ent.nextDouble();
                        System.out.println("Digues si es titular ( S / N )");
                        titularChar = ent.next().charAt(0);
                        do {
                            switch (titularChar) {
                                case 'S':
                                case 's':
                                    titular = true;
                                    break;
                                case 'N':
                                case 'n':
                                    titular = false;
                                    break;
                                default:
                                    System.out.println(titularChar + " No és una opció valida");
                                    System.out.println("Digues si es titular ( S / N )");
                                    titularChar = ent.next().charAt(0);
                                    break;
                            }
                        } while (titularChar != 'S' && titularChar != 's' && titularChar != 'N' && titularChar != 'n');

                        omplert = true;
                    } else {
                        System.out.println("Ja has introduït totes les dades.");
                    }

                    break;

                case 2:
                    if (omplert) {
                        System.out.println("Vols veure les dades del jugador? S/N");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Nom:" + nom);
                                    System.out.println("nacionalitat:" + nacionalitat);
                                    System.out.println("equip:" + equip);
                                    System.out.println("pes:" + pes);
                                    System.out.println("alçada:" + mida);
                                    System.out.println("salari:" + salari);
                                    System.out.println("titular:" + titular);
                                    if (titular == true) {
                                        System.out.println("És titular");
                                    } else {
                                        System.out.println("No és titular");
                                    }
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    System.out.println("Vale");
                                    break;
                                default:
                                    System.out.println("L'opcio no es valida");
                                    System.out.println("Vols veure les dades del jugador? S/N");
                                    veure = ent.next().charAt(0);
                                    break;
                            }
                        } while (veure != 'N');
                        System.out.println("Vols borrar les dades? S/N");
                        veure = ent.next().charAt(0);
                        switch (veure) {
                            case 'S':
                            case 's':
                                System.out.println("Les dades s'han esborrat");
                                pes = 0;
                                mida = 0;
                                salari = 0;
                                nom = null;
                                nacionalitat = null;
                                equip = null;
                                titular = false;
                                omplert = false;
                                veure = 'N';
                                break;
                            case 'N':
                            case 'n':
                                System.out.println("Les dades no s'han esborrat");
                                break;
                            default:
                                System.out.println("L'opcio no es valida");
                                System.out.println("Vols borrar les dades? S/N");
                                veure = ent.next().charAt(0);
                                break;
                        }

                    } else {
                        System.out.println("No hi han dades");
                    }

                    break;

                case 3:
                    if (omplert == true) {
                        System.out.println("Vols veure les dades del jugador? S/N");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Nom:" + nom);
                                    System.out.println("nacionalitat:" + nacionalitat);
                                    System.out.println("equip:" + equip);
                                    System.out.println("pes:" + pes);
                                    System.out.println("alçada:" + mida);
                                    System.out.println("salari:" + salari);
                                    System.out.println("titular:" + titular);
                                    if (titular == true) {
                                        System.out.println("És titular");
                                    } else {
                                        System.out.println("No és titular");
                                    }
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    System.out.println("Vale");
                                    break;

                                default:
                                    System.out.println("L'opcio no es valida");
                                    System.out.println("Vols veure les dades del jugador? S/N");
                                    veure = ent.next().charAt(0);
                                    break;
                            }

                        } while (veure != 'N' && veure != 'n');
                        System.out.println("Vols modificar el nom del jugador? ( S / N )");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Escriu el nou nom");
                                    nom = ent.next();
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(veure + "no és valida");
                                    System.out.println("Vols modificar el nom del jugador");
                                    veure = ent.next().charAt(0);
                                    break;
                            }
                        } while (veure != 'N' && veure != 'n');
                        System.out.println("Vols modificar la nacionalitat del jugador? ( s / n )");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Escriu la nova nacionalitat");
                                    nacionalitat = ent.next();
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;

                                default:
                                    System.out.println(veure + "no és valida");
                                    System.out.println("Vols modificar la nacionalitat del jugador");
                                    veure = ent.next().charAt(0);
                                    break;
                            }
                        } while (veure != 'N' && veure != 'n');
                        System.out.println("Vols modificar l'equip del jugador? ( s / n )");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Escriu el nou equip");
                                    equip = ent.next();
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(veure + "no és valida");
                                    System.out.println("Vols modificar l'equip del jugador");
                                    veure = ent.next().charAt(0);
                                    break;
                            }
                        } while (veure != 'N' && veure != 'n');
                        System.out.println("Vols modificar el pes del jugador? ( s / n )");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Escriu el nou pes");
                                    pes = ent.nextInt();
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(veure + "no és valida");
                                    System.out.println("Vols modificar el pes del jugador");
                                    veure = ent.next().charAt(0);
                                    break;
                            }
                        } while (veure != 'N' && veure != 'n');
                        System.out.println("Vols modificar la mida del jugador? ( s / n )");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Escriu la nova mida");
                                    mida = ent.nextDouble();
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(veure + "no és valida");
                                    System.out.println("Vols modificar la mida del jugador");
                                    veure = ent.next().charAt(0);
                                    break;
                            }
                        } while (veure != 'N' && veure != 'n');
                        System.out.println("Vols modificar el salari del jugador? ( s / n )");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Escriu el nou salari");
                                    salari = ent.nextDouble();
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;
                                default:
                                    System.out.println(veure + "no és valida");
                                    System.out.println("Vols modificar el salari del jugador");
                                    veure = ent.next().charAt(0);
                                    break;
                            }
                        } while (veure != 'N' && veure != 'n');
                        System.out.println("Vols modificar la titularitat del jugador? ( s / n )");
                        veure = ent.next().charAt(0);
                        do {
                            switch (veure) {
                                case 'S':
                                case 's':
                                    System.out.println("Escriu si es titular o no");
                                    titularChar = ent.next().charAt(0);
                                    veure = 'N';
                                    break;
                                case 'N':
                                case 'n':
                                    break;

                                default:
                                    System.out.println(veure + "no és valida");
                                    System.out.println("Vols modificar la titularitat del jugador");
                                    veure = ent.next().charAt(0);
                                    break;
                            }
                        } while (veure != 'N' && veure != 'n');
                        veure = ent.next().charAt(0);
                           break;
                    } else {
                        System.out.println("No hi han dades");
                    }

                    break;

                case 4:
                    if (omplert == false) {
                        System.out.println("No hi han dades");
                    } else {
                        System.out.println("Nom:" + nom);
                        System.out.println("Nacionalitat:" + nacionalitat);
                        System.out.println("Equip:" + equip);
                        System.out.println("Pes:" + pes);
                        System.out.println("Alçada:" + mida);
                        System.out.println("Salari:" + salari);                        
                        if (titular == true) {
                            System.out.println("És titular");
                        } else {
                            System.out.println("No és titular");
                        }
                    }
                    break;

                default:

                    System.out.println("L'operació no és valida");
                    break;

            }

        } while (opcio != 0);

    }

}
