package paquet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class Deck {

    private static List<SkyjoCard> pioche;
    private static final int nbMoinsDeux = 5;
    private static final int nbZero = 15;
    private static final int nbCarteClassique = 10;
    private static SkyjoCard poubelle;
    
    public Deck(){
        this.pioche=makePioche();
        Collections.shuffle(pioche);
        this.poubelle=piocher();
    }

    public List<SkyjoCard> makePioche(){
        List<SkyjoCard> pioche = new ArrayList<>();
        for (Valeur val : Valeur.values()){
            if (val.getValeur()==-2){
                for (int i=0; i<nbMoinsDeux; i++){
                    pioche.add(new SkyjoCard(val));
                }
            }
            else if (val.getValeur()==0){
                for (int i=0; i<nbZero; i++){
                    pioche.add(new SkyjoCard(val));
                }
            }
            else{
                for (int i=0; i<nbCarteClassique; i++){
                    pioche.add(new SkyjoCard(val));
                }
            }
        }
        return pioche;

    }

    public SkyjoCard piocher(){
        SkyjoCard card=pioche.get(0);
        pioche.remove(0);
        return  card ; 
    }

    

    


}
