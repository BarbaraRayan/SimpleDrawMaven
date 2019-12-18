package simpledraw;

import Controller.MainFrameController;

//Il y a problème d affichage pour mon MVC, à côté du boutton Select 
//se trouve bien Line et Cercle mais ils sont invisibles. Ils apparaissent 
//une fois qu on clique sur le lieu où ils doivent se trouver.  De même pour 
//le texte qui compte le nombre de lignes et de cercles, il y a 
//besoin de re-cliquer sur l un des bouton afin de les mettre à jours.


public class Main {

    public Main() {
        MainFrameController frame = new MainFrameController();
        frame.getFrame().validate();
        frame.getFrame().setVisible(true);
        System.out.println(this.getClass().equals(super.getClass()));

    }

    public static void main(String[] args) {
        new Main();
    }
}
