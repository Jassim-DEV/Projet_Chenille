package ufrim2ag.m2pcci.pl2.chenille;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Chenille avec une tête défine par un fichier image
 * @author genoud
 */
public class TeteImage extends Tete {

    /**
     * l'image a afficher pour la tête
     */
    private BufferedImage img;
    


    /**
     * 
     * @param xInit abscisse initial du centre de la tête  
     * @param yInit ordonnées intiial du centre de la tête
     * @param r le rayon de la tête
     * @param cap le cap intial de la tête
     * @param fileName  le nom du fichier contenant l'image de la tête.
     */
    public TeteImage(int xInit, int yInit ,int r, int cap, String fileName) {
        super(xInit, yInit, r, cap);
        try {
            img = ImageIO.read(new File(fileName));
            System.out.println("OK");
        } catch (IOException e) {
            System.out.println("image " + fileName + " not found");
            System.exit(0);
        }
    }

    // redéfinition de la méthode dessiner

    @Override
    public void dessiner(Graphics g) {
        g.drawImage(img, 
                this.x - r, this.y - r, this.x + r, this.y + r,
                0, 0, 63, 63, null);
    }
    
}
