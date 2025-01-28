
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
public class BoutonImage extends JButton {
    
    //Attributs
    private Image img;
    //Accesseur
    public Image getImage()
    {
        return img;
    }

    
    public void setImage(Image img) {
        this.img = img;
    }

    //Constructeur
    public BoutonImage() {
        super();
        this.img=null;
    }
        
    public BoutonImage(Image img)
    {
        super();
        this.img=img;
    }
    
    
    //Surchage de la methode paint 
    public void paint(Graphics g)
    {
        super.paint(g);
        if(this.img!=null)
        {
            Image imgB = this.img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
            this.setIcon(new ImageIcon(imgB));
        }
    }
        
}
