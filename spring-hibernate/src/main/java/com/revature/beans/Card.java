package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HIBERNATE_SPRING_CARD")
public class Card {

	@Id
	@Column(name="HIBERNATE_SPRING_CARD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="HIBERNATE_SPRING_CARD_SUIT")
	private String suit;
	@Column(name="HIBERNATE_SPRING_CARD_VALUE")
	private int value;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Card(String suit, int value) {
		super();
		this.suit = suit;
		this.value = value;
	}
	public Card() {
		super();
	}
	
	
	
}
