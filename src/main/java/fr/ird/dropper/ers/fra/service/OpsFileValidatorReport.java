package fr.ird.dropper.ers.fra.service;

import java.io.PrintWriter;
import java.util.*;

/**
 * Rapport d'erreurs utilisé lors de la vérification du format de fichiers xml
 * par OpsFileValidator.
 *
 * @author christelle.jeanberne
 *
 */
public class OpsFileValidatorReport {

    private List<String> entrees = new ArrayList<String>();

    public List<String> getEntrees() {
        Set<String> entreesSet = new HashSet<String>();
        for (String entree : entrees) {
            entreesSet.add(entree);
        }
        entrees.clear();

        for (String entree : entreesSet) {
            entrees.add(entree);
        }
        Collections.sort(entrees);
        return entrees;
    }

    public void setEntrees(List<String> entrees) {
        this.entrees = entrees;
    }

    /**
     * Ajoute une erreur dans le rapport d'erreurs.
     *
     * @param entree
     * @param location est une information permettant de situer où s'est
     * produite l'erreur.
     */
    public void addEntree(String entree, String location) {
        entrees.add("[" + location + "] " + entree);
    }

    /**
     * Ajoute une erreur dans le rapport d'erreurs.
     *
     * @param entree
     */
    public void addEntree(String entree) {
        entrees.add(entree);
    }

    public int size() {
        return entrees.size();
    }

    /**
     * Retourne le message d'erreur
     */
    public String get(int i) {
        return entrees.get(i);
    }

    /**
     * Retourne si la liste d'erreurs est vide
     *
     * @return true s'il y a des erreurs
     * @return false s'il n'y en a pas
     */
    public boolean isEmpty() {
        return entrees.isEmpty();
    }

    @Override
    public String toString() {
        String str = "";
        for (String entree : entrees) {
            str += entree + "\n";
        }
        return str;
    }

    /**
     * Imprime les erreurs dans le fichier d'erreur.
     *
     * @param writer
     */
    public void printJournal(PrintWriter writer) {
        for (String entree : getEntrees()) {
            writer.println(entree);
        }
    }

    /**
     * Supprime toutes les erreurs de la liste.
     */
    public void clean() {
        entrees.clear();
    }
}
