package fr.imie.data;

import java.io.Serializable;

import fr.imie.bankocash.soap.CompteEntity;


public class Virement implements Serializable {
    private CompteEntity from;
    private CompteEntity to;
    private Float montant;
        
    public Virement() {
        super();
    }

    /**
     * @return the from
     */
    public final CompteEntity getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public final void setFrom(CompteEntity from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public final CompteEntity getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public final void setTo(CompteEntity to) {
        this.to = to;
    }

    /**
     * @return the montant
     */
    public final Float getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public final void setMontant(Float montant) {
        this.montant = montant;
    }

}
