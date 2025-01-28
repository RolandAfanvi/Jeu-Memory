
import java.awt.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roland
 */
public class PanneauImage extends JPanel {
    
    // On specialise le JPanel pour qu'il gere une image
    private Image img ;  // l'image a afficher
    
    // Constructeur 
    public PanneauImage()
    {
        super();
        this.img=null;
    }
    
    // construceur avec parametre 
    public PanneauImage(Image img)
    {
        super();
        this.img=img;
    }
    // get , set
    public Image getImage()
    {
        return this.img;
    }
   
    public void setImage(Image img)
    {
        this.img=img;
    }
    //Surchage de la methode paint
    public void paint(Graphics g)
    {
        //Appel dela methode paint de la classe JPanel 
        super.paint(g);
        if(this.img!=null)
            g.drawImage(this.img, 0,0,this.getWidth(),this.getHeight() ,this);
    }
}
