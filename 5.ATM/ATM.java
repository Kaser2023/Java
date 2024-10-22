

package ATM_5;

import java.io.IOException;

public class ATM {

    public static void main(String[] args) throws IOException {

        OptionMenu optionMenu = new OptionMenu();
        introduction();
        optionMenu.mainMenu();

    }

//# ----------------------------------------------------------------
//# Coded by: Abdullah Alqurashi.
//# ----------------------------
//# Git-Hub: https://github.com/Kaser2023
//# Linked-In: https://www.linkedin.com/in/abdullah-alqurashi-a3777a224/
//# Date: 18.Rabi'a Alakhir. 1446 -  2024.Oct.21
//	Time: 5:01 AM
//# ----------------------------------------------------------------
//

    public static void introduction(){
        System.out.println("WELCOME TO THE ATM PROJECT! ");
    }

}

