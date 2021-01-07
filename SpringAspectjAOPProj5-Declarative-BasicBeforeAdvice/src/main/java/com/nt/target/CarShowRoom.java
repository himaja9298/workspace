package com.nt.target;

public class CarShowRoom {
	public String sale(String model,float price,String executive) {
	  System.out.println("CarShowRoom.sale()");
	  if(model.equalsIgnoreCase("Briza")||model.equalsIgnoreCase("Baleno")) 
		  return model+"car is soldout having price"+price+"by executive"+executive;
	  else
	      return model+"Car is not available for sale";
	}

}
