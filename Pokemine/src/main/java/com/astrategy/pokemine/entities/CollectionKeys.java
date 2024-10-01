package com.astrategy.pokemine.entities;

import java.io.Serializable;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CollectionKeys implements Serializable {

    private int userId;
    private String cardId;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionKeys that = (CollectionKeys) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, cardId);
    }

    
}
