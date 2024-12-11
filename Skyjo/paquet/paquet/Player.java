package paquet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public abstract class Player {
    Main main;
    List<SkyjoCard[]> mainConnu=new ArrayList<>();
    Random rd = new Random();
    Deck d;
    Poubelle p;
    int nbColumn;


    public Player(Deck d,Poubelle p){
        this.d=d;
        this.p=p;
        this.main=new Main(d);
        nbColumn=main.nbColumn;
        this.mainConnu=initialiserMainConnu();
    }

        
    private List<SkyjoCard[]> initialiserMainConnu() {
        List<SkyjoCard[]> mainConnu = new ArrayList<>();
        for (int i=0; i<nbColumn;i++){
            SkyjoCard[] colonne=new SkyjoCard[3];
            mainConnu.add(i,colonne);
        }
        for (int k=0;k<2;k++){
            int i= rd.nextInt(0,nbColumn);
            int j= rd.nextInt(0,3);
            mainConnu.get(i)[j]=this.main.getCard(i, j);
        }
        return mainConnu; 
    }

    public int nbCarteConnue(){
        int nb=0;
        for (SkyjoCard[] colonne : mainConnu){
            for (SkyjoCard carte : colonne){
                if (carte == null){
                    nb+=1;
                }
            }
        }
        return 12-nb;
    }
    
    
    public void rendreVisibleCarte(int i, int j){
        this.mainConnu.get(i)[j]=this.main.getCard(i, j);
    }

    public SkyjoCard remplacerCarte(int i, int j, SkyjoCard carteRemplacante){
        this.mainConnu.get(i)[j]=carteRemplacante;
        return this.main.remplacerCarte(i,j,carteRemplacante);
        
    }

    public int isSameCard(SkyjoCard card){
        int maxNb=0;
        int numColumnMax=-1;
        for (int i =0; i<mainConnu.size();i++){
            int nbCard = cardOccurenceColumn(card, mainConnu.get(i));
            if (nbCard>maxNb){
                numColumnMax= i;
            }
        }
        return numColumnMax;
    }

    public int cardOccurenceColumn(SkyjoCard card, SkyjoCard[] column){
        int nbSameCard=0;
        for (SkyjoCard c : column){
            if(c.equals(card)){
                nbSameCard+=1;
            }
        }
        return nbSameCard;
    }

    public void chooseTrashDeck(SkyjoCard card){

    }

    public void chooseKeepTrash(SkyjoCard card){

    }

    public void jeter(SkyjoCard cardAJeter){
        p.addCard(cardAJeter);
    }

    
}
