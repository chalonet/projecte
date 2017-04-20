/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author alumne
 */
public class Projecte {

    // Número màxim de caselles de l'array
    public static final int MAX_JUGADORS = 5;
    // Array on guardarem la informació
    private static Jugador[] array = new Jugador[MAX_JUGADORS];

    private static int opcio, i;
    //Fitxer usat per persistir la informació
    static File f = new File("jugadors.db");

    /**
     * @param args the command line arguments
     */
    public static Jugador[] getArray() {
        return array;
    }

    public static void main(String[] args) {

        inicialitzarVariables();
        do {
            demanarOpcio();
            tractarOpcio();
        } while (!opcioFinal());

    }

    public static int inicialitzarVariables() {
        Jugador p= null;
        int i=0;
        
        if(f.exists()){
            
            boolean acabar=false;
            

            ObjectInputStream lectura=null;
            try{
                lectura=new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
                
                while(true){
                    array[i]=(Jugador) lectura.readObject();
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
               
                System.err.println("Atenció, no caben tots els objectes. Si continues pots perdre dades. Vols continuar?(S/N):");
                Scanner ent = new Scanner(System.in);
                char siNo=' ';
                do {                    
                    siNo = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0); 
                    
                } while (siNo != 'S' && siNo != 'N');
                if(siNo=='N') acabar=true;
                
            } catch (IOException ex) {
                
            } catch (ClassNotFoundException ex) {
                
            }finally{
                try {
                    
                    if(lectura!=null) lectura.close();
                } catch (IOException ex) {
                    
                }
               
                if(acabar) System.exit(0);
            }
        
        }
        int resultat = i;
        for (; i < array.length; i++) {
            array[i] = new Jugador();
            array[i].setOmplert(false);
        }
        return resultat;
    }


    //Menu de l'aplicació 
    public static void demanarOpcio() {
        Scanner ent = new Scanner(System.in);
        do {
            System.out.println("-------- Menú jugadors de futbol--------");
            System.out.println("0. Sortir.");
            System.out.println("1. Introduïr jugador.");
            System.out.println("2. Borrar jugador.");
            System.out.println("3. Modificar jugador.");
            System.out.println("4. Llistar jugador.");
            System.out.println("----------------------------------------");
            try {
                opcio = ent.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opcio incorrecta!!");
                ent.next();
                continue;
            }
        } while (true);
    }

    public static void tractarOpcio() {

        switch (opcio) {
            case 0:
                finalitzar();
                break;
            case 1:
                introduirJugador();
                break;
            case 2:
                borrarJugador();
                break;
            case 3:
                modificarJugador();
                break;
            case 4:
                llistarJugador();
                break;
            default:
                System.out.println("\nOpció incorrecta!!");
        }

    }

    public static boolean opcioFinal() {
        return opcio == 0;
    }
    public static void finalitzar(){
      
        ObjectOutputStream escriptura=null;
        try{
            escriptura=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));

            for(int i=0;i<array.length;i++){
                if(array[i].isOmplert())escriptura.writeObject(array[i]);
            }
        } catch (IOException ex) {
            System.err.println("Error en guardar les dades!!");
        } finally{
            try {
                if(escriptura!=null) escriptura.close();
            } catch (IOException ex) {
            }
        }
        System.out.println("Adéu!!");
    }

    public static void introduirJugador() {
        Scanner ent = new Scanner(System.in);
        // Buscar una casella buida al vector
        for (i = 0; i < array.length && array[i].isOmplert(); i++);

        if (i != array.length) { //omplert = false
            System.out.println("Introdueix el nom del jugador");
            array[i].setNom(ent.skip("[\r\n]*").nextLine());
            System.out.println("Introdueix la nacionalitat");
            array[i].setNacionalitat(ent.skip("[\r\n]*").nextLine());
            System.out.println("Introdueix l'equip");
            array[i].setEquip(ent.skip("[\r\n]*").nextLine());

            do {
                System.out.println("Introdueix el pes");
                try {
                    array[i].setPes(Integer.valueOf(ent.skip("[\r\n]*").nextLine()));
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Te que ser un numero enter.");
                    array[i].setPes(-1);
                }
            } while (array[i].getPes() < 0);

            do {
                System.out.println("Introdueix l'alçada");
                try {
                    array[i].setMida(Double.valueOf(ent.skip("[\r\n]*").nextLine()));
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Te que ser  un numero enter.");
                    array[i].setMida(-1);
                }

            } while (array[i].getMida() < 0);

            do {
                System.out.println("Introdueix Salari");
                try {
                    array[i].setSalari(Double.valueOf(ent.skip("[\r\n]*").nextLine()));
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Te que ser  un numero enter.");
                    array[i].setSalari(-1);
                }

            } while (array[i].getSalari() < 0);

            System.out.println("Digues si es titular ( S / N )");
            array[i].setTitularChar(ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0));
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
                        array[i].setTitularChar(ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0));
                        break;
                }
            } while (array[i].getTitularChar() != 'S' && array[i].getTitularChar() != 'N');
            array[i].setOmplert(true);
        } else {
            System.out.println("Ja has introduït totes les dades.");
        }
    }

    public static void borrarJugador() {
        Jugador p = null;
        Scanner ent = new Scanner(System.in);
        char veure = 'N';
        int i;
        for (i = 0; i < array.length && veure != 'F'; i++) {
            p = array[i];
            if (array[i].isOmplert()) {
                System.out.println(array[i]);
                if (array[i].isTitular()) {
                    System.out.println("Es titular");
                } else {
                    System.out.println("No és titular");
                }

                do {
                    System.out.println("\nVols borrar les dades? S/N");
                    veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (veure != 'S' && veure != 'N' && veure != 'F');
            }
            if (veure == 'S') {
                break;
            }
        }

        if (veure == 'S') {
            p.setOmplert(false);
            System.out.println("Jugador borrat correctament.");

        } else {
            System.out.println("\nNo s'ha borrat cap jugador.");
        }
    }
//                    

    public static void modificarJugador() {

        Scanner ent = new Scanner(System.in);
        char veure = 'N';
        int cont = 1;
        for (i = 0; i < array.length && veure != 'F'; i++) {
            if (array[i].isOmplert()) {
                System.out.format("\nJugador %d:\n", cont++);
                System.out.println(array[i].toString());
                do {
                    System.out.println("\nVols modificar el jugador(S/N) o finalitzar la cerca (F)?:");
                    veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (veure != 'S' && veure != 'N' && veure != 'F');
            }
            if (veure == 'S') {
                break;
            }
        }
        if (veure == 'S') {
            System.out.println("\nNom: " + array[i].getNom());
            do {
                System.out.println("\nVols modificar el nom?(S/N):");
                veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (veure != 'S' && veure != 'N');
            if (veure == 'S') {
                System.out.print("Nou nom: ");
                array[i].setNom(ent.skip("[\r\n]*").nextLine());
            }

            System.out.println("\nNacionalitat: " + array[i].getNacionalitat());
            do {
                System.out.println("\nVols modificar la nacionalitat?(S/N):");
                veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (veure != 'S' && veure != 'N');
            if (veure == 'S') {
                System.out.print("Nova nacionalitat: ");
                array[i].setNacionalitat(ent.skip("[\r\n]*").nextLine());
            }

            System.out.println("\nEquip: " + array[i].getEquip());
            do {
                System.out.println("\nVols modificar l'equip?(S/N):");
                veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (veure != 'S' && veure != 'N');
            if (veure == 'S') {
                System.out.print("Nou equip: ");
                array[i].setEquip(ent.skip("[\r\n]*").nextLine());
            }

            System.out.println("\nPes: " + array[i].getPes());
            do {
                System.out.println("\nVols modificar el pes?(S/N):");
                veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (veure != 'S' && veure != 'N');
            if (veure == 'S') {
                do {
                    System.out.println("Nou pes:");
                    try {
                        array[i].setPes(Integer.valueOf(ent.skip("[\r\n]*").nextLine()));
                    } catch (java.lang.NumberFormatException e) {
                        System.out.println("Te que ser un numero enter.");
                        array[i].setPes(-1);
                    }
                } while (array[i].getPes() < 0);
            }

            System.out.println("\nMida: " + array[i].getMida());
            do {
                System.out.println("\nVols modificar la mida?(S/N):");
                veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (veure != 'S' && veure != 'N');
            if (veure == 'S') {
                do {
                    System.out.println("Nova mida:");
                    try {
                        array[i].setMida(Double.valueOf(ent.skip("[\r\n]*").nextLine()));
                    } catch (java.lang.NumberFormatException e) {
                        System.out.println("Te que ser  un numero enter.");
                        array[i].setMida(-1);
                    }
                } while (array[i].getMida() < 0);
            }
            System.out.println("\nSalari: " + array[i].getSalari());
            do {
                System.out.println("\nVols modificar el salari?(S/N):");
                veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (veure != 'S' && veure != 'N');
            if (veure == 'S') {
                do {
                    System.out.println("Nou salari:");
                    try {
                        array[i].setSalari(Double.valueOf(ent.skip("[\r\n]*").nextLine()));
                    } catch (java.lang.NumberFormatException e) {
                        System.out.println("Te que ser  un numero enter.");
                        array[i].setSalari(-1);
                    }
                } while (array[i].getSalari() < 0);
            }
            if (array[i].isTitular()) {
                System.out.println("\nÉs titular");
            } else {
                System.out.println("\nNo és titular");
            }
            do {
                System.out.println("\nVols modificar la titularitat?(S/N):");
                veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
            } while (veure != 'S' && veure != 'N');
            if (veure == 'S') {
                char esHome;
                do {
                    System.out.println("És titular? ( s / n )");
                    esHome = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (esHome != 'H' && esHome != 'D');
                array[i].setTitular(esHome == 'H');
                System.out.print("Titular: ");
                if (array[i].isTitular()) {
                    System.out.println("titular");
                } else {
                    System.out.println("No titular");
                }
            }
            System.out.println("Jugador modificat correctament.");

        } else {
            System.out.println("\nNo hi ha jugadors per modificar, o no n'has triat cap per modificar.");
        }
    }

    public static void llistarJugador() {
        Scanner ent = new Scanner(System.in);
        Jugador p = null;
        boolean algun = false;
        char veure = 'S';
        for (i = 0; i < array.length; i++) {
            p = array[i];
            if (p.isOmplert()) {
                algun = true;
                System.out.println(p);
                do {
                    System.out.println("\nVols vore més jugadors(S/N)?:");
                    veure = ent.skip("[\r\n]*").nextLine().toUpperCase().charAt(0);
                } while (veure != 'S' && veure != 'N');
            }
            if (veure == 'N') {
                break;
            }
        }
        if (!algun) {
            System.out.println("\nNo hi ha jugadors per mostrar, si vols, primer crea'n.");
        }

    }

}
