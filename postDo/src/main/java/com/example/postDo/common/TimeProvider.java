package com.example.postDo.common;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TimeProvider implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Date now() {
		return new Date();
	}
}
