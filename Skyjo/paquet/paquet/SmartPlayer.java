package paquet;


public class SmartPlayer extends Player{

    public SmartPlayer(Deck d,Poubelle p){
        super(d, p);
    }

    public void chooseTrashDeck(SkyjoCard card){//card récup de la poubelle donnée par le plateau attention bien l'enlever de la poubelle
        if (card.getValeur()<=0){
            //lancer une méthode qui joue correctement avec ces cartes
        }
        else if (isSameCard(card) != -1 ){
            if(cardOccurenceColumn(card, mainConnu.get(isSameCard(card))) == 2){
                //finir une colonne
            }
            else{
                tryMakeColumn(card);
            }
        }
        else if(card.getValeur()<5){
            //lance une méthode pour dans ce cas
        }
        else{
            //remettre card dans la poubelle
            chooseKeepTrash(d.piocher());
        }

    }

    public void chooseKeepTrash(SkyjoCard card){//card piocher
        if (card.getValeur()<=0){
            //lancer une méthode qui joue correctement avec ces cartes
        }
        else if (isSameCard(card) != -1 ){
            if(cardOccurenceColumn(card, mainConnu.get(isSameCard(card))) == 2){
                //finir une colonne
            }
            else{
                tryMakeColumn(card);
            }
        }
        else if(card.getValeur()<5){
            //lance une méthode pour dans ce cas qui remplace la carte la plus haute seule
        }
        else{
            //si je la jette choisir quelle carte retournée 
        }

    }

    public void makeColumn(){ 
        SkyjoCard card = p.getLastCard();
        int numColumn= isSameCard(card);
    }

    public void tryMakeColumn(SkyjoCard card){
        if (nbCarteConnue()<7 ){
            //remettre card dans la poubelle
            chooseKeepTrash(d.piocher());
        }
        else if(card.getValeur()<5){
            //remettre card dans la poubelle
            chooseKeepTrash(d.piocher());
        }

        else{ // si les 2 autres cartes je les connais et qu'elles sont = et inf à ma nvl carte alors non
            makeColumn();
        }
        
    }

    public int[] getIndexOtherCard(SkyjoCard card, SkyjoCard[] column){
        int[] index=new int[2];
        int element=0;
        for (int i =0; i<column.length;i++){
            if(column[i].equals(card)){
                break;
            }
            index[element]=i;
            element+=1;
        }
        return index;
    } 

    

}
