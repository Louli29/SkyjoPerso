package paquet;

public class Plateau {
    static SmartPlayer j1;
    static SmartPlayer j2;
    static Deck deck; 
    static Poubelle poubelle;

    public Plateau(){
        Plateau.deck=new Deck();
        Plateau.poubelle=new Poubelle(deck);
        Plateau.j1=new SmartPlayer(deck, poubelle);
        Plateau.j2=new SmartPlayer(deck, poubelle);

    }




    public static void main(String[] args){

        Plateau p=new Plateau();
        
    }

}
