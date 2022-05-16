package com.nbti.backEnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FILE")
public class NBTIFile extends NbtiEntity {

	private String name;

	private String type;

	private byte[] data;

	private final static List<String> IMG_TYPES = List.of("image/png", "image/jpg", "image/jpeg");

	public boolean isImage() {
		return IMG_TYPES.contains(type.toLowerCase());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
