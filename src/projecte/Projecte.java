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
    // Número màxim de caselles de l'array
    private static final int MAX_JUGADORS = 2;
    // Array on guardarem la informació
    private static Jugador[] array = new Jugador[MAX_JUGADORS];

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ent = new Scanner(System.in);
        
        for (int j = 0; j< array.length; j++) {
            array[j] = new Jugador();
            array[j].setOmplert(false);
        }
                   
        int pes = 0;
        double mida = 0, salari = 0;
        String nom = null, nacionalitat = null, equip = null;
        boolean titular = false, omplert = false;
        char veure, titularChar, mostrar;

        //Variable del menú
        int opcio, i;
        Jugador p=null;

        //Menu de l'aplicació 
        do {
            
            System.out.println("-------- Menú jugadors de futbol--------");

            System.out.println(" 0.Sortir");

            System.out.println(" 1.Afegir jugador");

            System.out.println(" 2.Borrar jugador");

            System.out.println(" 3.Modificar jugador");

            System.out.println(" 4.Llistar jugadors");

            System.out.println("----------------------------------------");

            switch (opcio = ent.skip("[\r\n]*").nextInt()) {

                case 1:
                    // Buscar una casella buida al vector
                    for (i = 0; i < array.length && array[i].isOmplert(); i++);
                    
                    if (i != array.length) { //omplert = false
                        System.out.println("Introdueix el nom del jugador");
                        array[i].setNom(ent.skip("[\n\n]*").nextLine());
                        System.out.println("Introdueix la nacionalitat");
                        array[i].setNacionalitat(ent.skip("[\n\n]*").nextLine());
                        System.out.println("Introdueix l'equip");
                        array[i].setEquip(ent.skip("[\n\n]*").nextLine());
                        System.out.println("Introdueix el pes");
                        array[i].setPes(ent.skip("[\n\n]*").nextInt());
                        System.out.println("Introdueix l'alçada");
                        array[i].setMida(ent.skip("[\n\n]*").nextDouble());
                        System.out.println("Introdueix el salari");
                        array[i].setSalari(ent.skip("[\n\n]*").nextDouble());
                        System.out.println("Digues si es titular ( S / N )");
                        array[i].setTitularChar(ent.skip("[\n\n]*").nextLine().toUpperCase().charAt(0));
                        do {
                            switch (array[i].getTitularChar()) {
                                case 'S':
                                    array[i].setTitular(true);
                                    break;
                                case 'N':
                                    array[i].setTitular(false);
                                    break;
                                default:
                                    System.out.println(array[i].getTitularChar() + " No és una opció valida");
                                    System.out.println("Digues si es titular ( S / N )");
                                    array[i].setTitularChar(ent.skip("[\n\n]*").nextLine().toUpperCase().charAt(0));
                                    break;
                            }
                        } while (array[i].getTitularChar() != 'S' && array[i].getTitularChar() != 'N');
                        array[i].setOmplert(true);
                    } else {
                        System.out.println("Ja has introduït totes les dades.");
                    }

                    break;

                case 2:
                    veure='N';
                     for (i = 0; i < array.length && veure!='F'; i++) {
                        p=array[i];
                        if (array[i].isOmplert()) {
                            System.out.println(array[i]);
                            if (array[i].isTitular()) {
                                System.out.println("Es titular");
                            } else {
                                System.out.println("No és titular");
                            }
                            
                            do {
                                System.out.println("\nVols borrar les dades? S/N");
                                 veure= ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); //usem toUpperCase() que traduix el text introduït per l'usuari a majúscules, 
                                                                                                //per tant només haurem de tractar les lletres majúscules
                            } while ( veure != 'S' &&  veure != 'N' &&  veure != 'F');
                        }
                        if( veure=='S') break;                    
                    }
                    
                    if ( veure=='S') {
                        p.setOmplert(false);       
                        System.out.println("Pilot borrat correctament.");
                        
                    } else {
                        System.out.println("\nNo s'ha borrat cap pilot.");
                    }
                    break;   
//                   
                case 3:
//                        
                    veure='N';
                    int cont=1;
                    for(i=0; i<array.length && veure!='F';i++){
                        if(array[i].isOmplert()){
                            System.out.format("\nPilot %d:\n", cont++);
                            System.out.println(array[i].toString());
                            do {
                                System.out.println("\nVols modificar el pilot(S/N) o finalitzar la cerca (F)?:");
                                veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                            } while (veure != 'S' && veure != 'N' && veure != 'F');
                        }
                        if(veure=='S') break;
                    }
                    if (veure=='S') {
                        System.out.println("\nNom: "+array[i].getNom());
                        do {
                            System.out.println("\nVols modificar el nom?(S/N):");
                            veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                        } while (veure != 'S' && veure != 'N');
                        if (veure == 'S'){
                            System.out.print("Nou nom: ");
                            array[i].setNom(ent.skip("[\r\n]*").nextLine());
                        }
                        
                        
                        System.out.println("\nNacionalitat: "+array[i].getNacionalitat());
                        do {
                            System.out.println("\nVols modificar la nacionalitat?(S/N):");
                            veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                        } while (veure != 'S' && veure != 'N');
                        if (veure == 'S'){
                            System.out.print("Nova nacionalitat: ");
                            array[i].setNacionalitat(ent.skip("[\r\n]*").nextLine());
                        }
                        
                        
                         System.out.println("\nEquip: "+array[i].getEquip());
                        do {
                            System.out.println("\nVols modificar l'equip?(S/N):");
                            veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                        } while (veure != 'S' && veure != 'N');
                        if (veure == 'S'){
                            System.out.print("Nou equip: ");
                            array[i].setEquip(ent.skip("[\r\n]*").nextLine());
                        }
                        
                        System.out.println("\nPes: "+array[i].getPes());
                        do {
                            System.out.println("\nVols modificar el pes?(S/N):");
                            veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                        } while (veure != 'S' && veure != 'N');
                        if (veure == 'S'){
                            System.out.print("Nou pes: ");
                            array[i].setPes(ent.skip("[\r\n]*").nextInt());
                        }
                        
                        System.out.println("\nMida: "+array[i].getMida());
                        do {
                            System.out.println("\nVols modificar la mida?(S/N):");
                            veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                        } while (veure != 'S' && veure != 'N');
                        if (veure == 'S'){
                            System.out.print("Nova mida: ");
                            array[i].setMida(ent.skip("[\r\n]*").nextDouble());
                        }
                        
                         System.out.println("\nSalari: "+array[i].getSalari());
                        do {
                            System.out.println("\nVols modificar el salari?(S/N):");
                            veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                        } while (veure != 'S' && veure != 'N');
                        if (veure == 'S'){
                            System.out.print("Nou salari: ");
                            array[i].setSalari(ent.skip("[\r\n]*").nextDouble());
                        }
                        
                        if(array[i].isTitular()) System.out.println("\nÉs titular");
                        else System.out.println("\nNo és titular");
                        do {
                            System.out.println("\nVols modificar la titularitat?(S/N):");
                            veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                        } while (veure != 'S' && veure != 'N');
                        if (veure == 'S'){
                            char esHome;
                            do {
                                System.out.println("Vols modificar la titularitat? ( s / n )");
                                esHome = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                            } while (esHome != 'H' && esHome != 'D');
                            array[i].setTitular(esHome == 'H');     //si esHome conté la 'H' home serà true i sinó false. Fa el mateix que un if_else però és molt més curt
                            System.out.print("Titular: ");
                            if(array[i].isTitular()) System.out.println("titular");
                            else System.out.println("No titular");
                        }

                        System.out.println("Jugador modificat correctament.");
                        
                        
                    } else {
                        System.out.println("\nNo hi ha jugadors per modificar, o no n'has triat cap per modificar.");
                    }
                    break;
                
//                        
                case 4:
                    
                    boolean algun=false;
                    veure='S';
                    for (i = 0; i < array.length; i++) {
                        p=array[i];
                        if(p.isOmplert()){
                            algun=true;
                            System.out.println(p);
                            do {
                                System.out.println("\nVols vore més jugadors(S/N)?:");
                               veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                            } while (veure != 'S' && veure != 'N');
                        }
                        if(veure=='N') break;                    
                    }
                    if (!algun) {
                        System.out.println("\nNo hi ha jugadors per mostrar, si vols, primer crea'n.");                        
                    }                    
                    break;
            }
                   

        } while (opcio != 0);

    }

}
