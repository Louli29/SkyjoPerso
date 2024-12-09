package paquet;

public class Plateau {
    static Joueur j1;
    static Joueur j2;
    static Deck deck; 
    static Poubelle poubelle;

    public Plateau(){
        this.deck=new Deck();
        this.poubelle=new Poubelle(deck);
        this.j1=new Joueur(deck, poubelle);
        this.j2=new Joueur(deck, poubelle);
        

    }




    public static void main(String[] args){

        Plateau p=new Plateau();
        
    }

}
