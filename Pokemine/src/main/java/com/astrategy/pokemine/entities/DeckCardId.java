package com.astrategy.pokemine.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class DeckCardId implements Serializable {
    @Serial
    private static final long serialVersionUID = 820457611589241517L;
    @Column(name = "deck_id", nullable = false)
    private Integer deckId;

    @Nationalized
    @Column(name = "card_id", nullable = false, length = 50)
    private String cardId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DeckCardId entity = (DeckCardId) o;
        return Objects.equals(this.deckId, entity.deckId) &&
                Objects.equals(this.cardId, entity.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deckId, cardId);
    }

}