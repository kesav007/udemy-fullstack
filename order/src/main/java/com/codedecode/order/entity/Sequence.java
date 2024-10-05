package com.codedecode.order.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class Sequence {

	private String id;
	private int sequence;

	public Sequence() {
	}

	public Sequence(String id, int sequence) {
		this.id = id;
		this.sequence = sequence;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

}
