/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

import java.io.Serializable;

/**
 *
 * @author alumne
 * 
 * 
 */
public class Jugador implements Serializable {
        private int pes = 0;
        private double mida = 0;
        private double salari = 0;
        private String nom = null;
        private String nacionalitat = null;
        private String equip = null;
        private boolean titular = false;
        private boolean omplert = false;
        private char veure;
        private char titularChar;
        private char mostrar;
        //
        @Override
    public String toString() {
        return "\nNom: " + nom +
               "\nNacionalitat: " + nacionalitat +
               "\nEquip: " + equip +
               "\nPes: " + pes +
               "\nAlçada: " + mida +
               "\nSalari " + salari +
               (titular?"\nTitular":"\nNo Titular");
    }

    public int getPes() {
        return pes;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }

    public double getMida() {
        return mida;
    }

    public void setMida(double mida) {
        this.mida = mida;
    }

    public double getSalari() {
        return salari;
    }

    public void setSalari(double salari) {
        this.salari = salari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public boolean isTitular() {
        return titular;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }

    public boolean isOmplert() {
        return omplert;
    }

    public void setOmplert(boolean omplert) {
        this.omplert = omplert;
    }

    public char getVeure() {
        return veure;
    }

    public void setVeure(char veure) {
        this.veure = veure;
    }

    public char getTitularChar() {
        return titularChar;
    }

    public void setTitularChar(char titularChar) {
        this.titularChar = titularChar;
    }

    public char getMostrar() {
        return mostrar;
    }

    public void setMostrar(char mostrar) {
        this.mostrar = mostrar;
    }
}
