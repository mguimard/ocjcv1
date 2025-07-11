package com.libb;

import com.example.kebab.IKebabService;

public class AutreKebabImpl implements IKebabService {
	@Override
	public void achete() {
		System.out.println("SUPER !!!");		
	}
	
	@Override
	public String horaires() {
		throw new RuntimeException("Fermé pour congés");	
	}
}
