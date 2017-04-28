package com.library.book.domain;

public enum UserType {
	
	DONOR('D'),RECIEVER('R'),BOTH('B');
	
	private char type;
	
	UserType(char type){
		
		this.type = type;
		
	}

}
