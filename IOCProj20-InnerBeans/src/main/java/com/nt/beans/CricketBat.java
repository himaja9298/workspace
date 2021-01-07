package com.nt.beans;

import java.util.Random;

public class CricketBat {
   public CricketBat() {
	 System.out.println("CricketeBat:0-param constructor");
   }
   public int runScored() {
	   return new Random().nextInt(200);
   }
}
