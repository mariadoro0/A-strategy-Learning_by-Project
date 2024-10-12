package com.astrategy.pokemine.entities;

import java.io.Serializable;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class UserCollectionId implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "user_id")
	private int userId;
    
    @Column(name ="card_id")
    private String cardId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCollectionId that = (UserCollectionId) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, cardId);
    }

    
}
