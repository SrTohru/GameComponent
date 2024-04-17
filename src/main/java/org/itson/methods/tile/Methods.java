
package org.itson.methods.tile;

import org.itson.enums.PlayerNames;


public class Methods {
    
   public PlayerNames getSelectedAvatarEnum(String imagePath) {
        if (imagePath.contains("El_Gallo.jpg")) {
            return PlayerNames.El_Gallo;
        } else if (imagePath.contains("La_dama.jpg")) {
            return PlayerNames.La_dama;
        } else if (imagePath.contains("La_chalupa.jpg")) {
            return PlayerNames.La_chalupa;
        } else if (imagePath.contains("El_diablo.jpg")) {
            return PlayerNames.El_diablito;
        } else if (imagePath.contains("El_sol.jpg")) {
            return PlayerNames.El_sol;
        } else if (imagePath.contains("El_borracho.jpg")) {
            return PlayerNames.El_borracho;
        } else if (imagePath.contains("El_apache.jpg")) {
            return PlayerNames.El_apache;
        } else if (imagePath.contains("El_Valiente.jpg")) {
            return PlayerNames.El_Valiente;
        } else {
            return PlayerNames.El_Gallo; 
        }
    }
   
    
}
