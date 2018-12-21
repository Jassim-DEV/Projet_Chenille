package ufrim2ag.m2pcci.pl2.chenille;

/**
 * Chenille dont la tête est définie par une image.
 * @author genoud
 */
public class ChenilleImage extends Chenille {

    /**
     * @param d la feuille de dessin où se situe la chenille
     * @param r rayon des anneaux de la chenille
     * @param nbAnneaux nombre d'anneaux de la chenille
     * @param fileName nom du fichier contenant l'image de la tête
     */
    public ChenilleImage(Dessin d, int r , int nbAnneaux, String fileName) {
        super(d, new TeteImage(d.getLargeur() /2 , d.getHauteur() /2, r, 0, fileName), r, nbAnneaux);
    }
}
