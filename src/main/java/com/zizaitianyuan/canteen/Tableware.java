package com.zizaitianyuan.canteen;

public interface Tableware {
	public String getType();
}
class MinPlate implements Tableware{
	public String getType(){
		return Portal.MIN_PLATE;		
	}
}

class MaxPlate implements Tableware{
	public String getType(){
		return Portal.MAX_PLATE;		
	}
}

class MinBowl implements Tableware{
	public String getType(){
		return Portal.MIN_BOWL;		
	}
}

class MaxBowl implements Tableware{
	public String getType(){
		return Portal.MAX_BOWL;		
	}	
}