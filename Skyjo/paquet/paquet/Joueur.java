package paquet;

import java.util.ArrayList;
import java.util.List;
import paquet.Deck;
import java.util.Random;


public class Joueur {
    Main main;
    List<SkyjoCard[]> mainConnu=new ArrayList<>();
    Random rd = new Random();


    public Joueur(Deck d,Poubelle p){
        this.main=new Main(d);
        this.mainConnu=initialiserMainConnu();
    }

        
    private List<SkyjoCard[]> initialiserMainConnu() {
        List<SkyjoCard[]> mainConnu = new ArrayList<>();
        for (int i=0; i<4;i++){
            SkyjoCard[] colonne=new SkyjoCard[3];
            mainConnu.add(i,colonne);
        }
        for (int k=0;k<2;k++){
            int i= rd.nextInt(0,4);
            int j= rd.nextInt(0,3);
            mainConnu.get(i)[j]=this.main.getCard(i, j);
        }
        return mainConnu; 
    }

    public int nbCarteConnue(){
        int nb=0;
        for (SkyjoCard[] colonne : mainConnu){
            for (SkyjoCard carte : colonne){
                if (carte != null){
                    nb+=1;
                }
            }
        }
        return nb;
    }
    
    
    public void rendreVisibleCarte(int i, int j){
        this.mainConnu.get(i)[j]=this.main.getCard(i, j);
    }

    public SkyjoCard remplacerCarte(int i, int j, SkyjoCard carteRemplacante){
        this.mainConnu.get(i)[j]=carteRemplacante;
        return this.main.remplacerCarte(i,j,carteRemplacante);
        
    }
        
    public void choisirPoubelleOuPioche(){

    }

    public void choisirOuRemplacerCarte(){

    }

    public void choisirJeterOuGarder(){

    }

    public void choisirCarteATourner(){//random
        

    }


    
}
