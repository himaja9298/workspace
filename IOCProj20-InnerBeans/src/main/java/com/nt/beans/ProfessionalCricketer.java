package com.nt.beans;

public class ProfessionalCricketer {
	private CricketBat bat;
    private String Name;
	//1-param constructor
	public ProfessionalCricketer( String Name,CricketBat bat) {
		System.out.println("ProfessionalCricketer:1-param constructor");
		this.Name=Name;
		this.bat = bat;
	}
	public String Batting() {
		int runs;
		runs=bat.runScored();
		return "Batasman" +Name+ " has scored" +runs+ "runs";
	}

}
