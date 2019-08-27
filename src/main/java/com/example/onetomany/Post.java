package com.example.onetomany;

import java.io.Serializable;

public class Post implements Serializable {
	private int id;
	private Guy guy;
	private String title;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Guy getGuy() {
		return guy;
	}

	public void setGuy(Guy guy) {
		this.guy = guy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
