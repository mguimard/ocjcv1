package com.liba;

import com.example.kebab.IKebabService;

public class KebabServiceImpl implements IKebabService {
	@Override
	public void achete() {
		System.out.println("MERCI !!!");
	}
	
	@Override
	public String horaires() {
		return "08:00 -> 14:30";
	}
}
