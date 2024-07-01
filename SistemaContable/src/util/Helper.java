/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;

/**
 *
 * @author gamert
 */
public class Helper {
    private Color bgColorButton = new Color(0,102,204); // Azul medio
    private Color fgColorButton = Color.WHITE;

    public Color getBgColorButton() {
        return bgColorButton;
    }

    public void setBgColorButton(Color bgColorButton) {
        this.bgColorButton = bgColorButton;
    }

    public Color getFgColorButton() {
        return fgColorButton;
    }

    public void setFgColorButton(Color fgColorButton) {
        this.fgColorButton = fgColorButton;
    }
    
    public String letraCapital(String texto){
        return texto.toUpperCase().charAt(0) + texto.substring(1, texto.length()).toLowerCase();
    }
}
