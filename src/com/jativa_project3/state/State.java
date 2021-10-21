package com.jativa_project3.state;

import java.text.DecimalFormat;

/**
 * Section dedicated to encapsulation using class State and private values.
 * Object public State accepts strings, integers and doubles so that Project1
 * class can call variables.
 *
 * @author <Wilson Jativa>
 * @version <2/5/21>
 */

public class State {

	private String name;
	private String capitol;
	private String region;
	private int seats;
	private double population;
	private double covCases;
	private double covDeaths;
	private double medHouseIncome;
	private float violCrimeRate;

	public State(String name, String capitol, String region, int seats, double population, double covCases,
			double covDeaths, double medHouseIncome, float violCrimeRate) {

		this.name = name;
		this.capitol = capitol;
		this.region = region;
		this.seats = seats;
		this.population = population;
		this.covCases = covCases;
		this.covDeaths = covDeaths;
		this.medHouseIncome = medHouseIncome;
		this.violCrimeRate = violCrimeRate;

	}

	public State() {
		super();
	}

	

	

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public String getCapitol() {
		return capitol;
	}

	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public double getCovCases() {
		return covCases;
	}

	public void setCovCases(double covCases) {
		this.covCases = covCases;
	}

	public double getCovDeaths() {
		return covDeaths;
	}

	public void setCovDeaths(double covDeaths) {
		this.covDeaths = covDeaths;
	}

	public double getMedHouseIncome() {
		return medHouseIncome;
	}

	public void setMedHouseIncome(double medHouseIncome) {
		this.medHouseIncome = medHouseIncome;
	}

	public float getViolCrimeRate() {
		return violCrimeRate;
	}

	public void setViolCrimeRate(float violCrimeRate) {
		this.violCrimeRate = violCrimeRate;
	}
	public double deathRate() {
		// you can change death rate formula from here
		double dr=(double) ((getCovDeaths())/(getPopulation()));
		return dr*100000;
	}
	public double caseRate() {
		double caseRate = (double) (getCovCases() / (getPopulation()));
		caseRate = caseRate * 100000;
		return (int) caseRate;
	}
	public double cfr() {
		double cfr = (double) (getCovDeaths()/ getCovCases());
		cfr = cfr * 1000;
		return cfr;

	}
	

	// Prints out variables stored in an array in Project1 class.
	public void printState() {
		//Name MHI VCR CFR Case Rate Death Rate
		DecimalFormat roundoff = new DecimalFormat("#.####"); 
		
		
			System.out.printf("%20s %20s %20s %30s %20s %20s",getName(),getMedHouseIncome(),getViolCrimeRate(),roundoff.format(cfr()),caseRate(),roundoff.format(deathRate()));
			
		}

	

}
