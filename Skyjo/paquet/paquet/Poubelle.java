package paquet;

import java.util.Deque;
import java.util.LinkedList;

public class Poubelle {
    Deque<SkyjoCard> poubelle;
     
    public Poubelle(Deck d){
        this.poubelle=new LinkedList<SkyjoCard>();
        poubelle.push(d.piocher());
    }

    public SkyjoCard getDerniereCarte(){
        return poubelle.pop();
    }

    public void ajouterCarte(SkyjoCard carte){
        poubelle.push(carte);
    }

}
