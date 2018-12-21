package ufrim2ag.m2pcci.pl2.chenille;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Ouvre une fenêtre et affiche plusieurs chenilles, intialement toutes
 * positionnées au centre de la fenêtre et qui ensuite se déplacent de manière
 * aléatoire. Le nombre de chenille peut être fixé par la ligne de commande; par
 * exemple pour avoir 6 chenilles :<BR>
 * <code>java AppliChenille2 6</code>
 *
 * @author Philippe Genoud
 */
public class AppliChenilleVador2 {

    /**
     * nombre de chenilles par defaut
     */
    public static final int NBCH = 5;

    public static String[] tetesFileNames = {
        "images/darthVador.png",
        "images/leila.png",
        "images/c3po.png", 
        "images/starTrooper.png"
    };

    public static void main(String[] args) {

        int nbChenilles; // nombre de chenille a afficher

        if (args.length == 0) {
            nbChenilles = NBCH;
        } else {
            nbChenilles = Integer.parseInt(args[0]);
        }

        // création de la fenêtre de l'application
        JFrame laFenetre = new JFrame("Chenilles");
        laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        laFenetre.setSize(1280, 720);

        // création de la zône de dessin dans la fenêtre
        Dessin d = new Dessin();
        laFenetre.add(d);
        // affiche la fenêtre
        laFenetre.setVisible(true);
        // creation des chenilles. elles sont stockées dans un tableau et
        // ajoutées
        // à la zône de dessin
        Chenille[] chen = new Chenille[nbChenilles];
        for (int i = 0; i < nbChenilles; i++) {

            chen[i] = new ChenilleImage(d, 32, 10, (i < 3) ? tetesFileNames[i] : tetesFileNames[3]);

            d.ajouterObjet(chen[i]);
        }


        // la boucle d'animation
        while (true) {

            // fait réaliser aux chenilles un déplacement élémentaire
            for (Chenille ch : chen) {
                ch.deplacer();
            }

            // la zone de dessin se réaffiche
            d.repaint();

            // un temps de pause pour avoir le temps de voir le nouveau dessin
            d.pause(50);

        }

    }

} // AppliChenille2

