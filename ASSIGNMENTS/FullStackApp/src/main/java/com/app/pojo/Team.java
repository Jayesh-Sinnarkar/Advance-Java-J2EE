package com.app.pojo;

public class Team {
	int team_id;
	String name;
	String abbrevation;
	String owner;
	int max_age;
	double batting_avg;
	int wickets_taken;
	
	
	public Team(int team_id, String name, String abbrevation, String owner, int max_age, double batting_avg,
			int wickets_taken) {
		super();
		this.team_id = team_id;
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.max_age = max_age;
		this.batting_avg = batting_avg;
		this.wickets_taken = wickets_taken;
	}

	public Team(String name, String abbrevation, String owner, int max_age, double batting_avg, int wickets_taken) {
		super();
		this.name = name;
		this.abbrevation = abbrevation;
		this.owner = owner;
		this.max_age = max_age;
		this.batting_avg = batting_avg;
		this.wickets_taken = wickets_taken;
	}

	public int getTeam_id() {
		return team_id;
	}

	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMax_age() {
		return max_age;
	}

	public void setMax_age(int max_age) {
		this.max_age = max_age;
	}

	public double getBatting_avg() {
		return batting_avg;
	}

	public void setBatting_avg(double batting_avg) {
		this.batting_avg = batting_avg;
	}

	public int getWickets_taken() {
		return wickets_taken;
	}

	public void setWickets_taken(int wickets_taken) {
		this.wickets_taken = wickets_taken;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", name=" + name + ", abbrevation=" + abbrevation + ", owner=" + owner
				+ ", max_age=" + max_age + ", batting_avg=" + batting_avg + ", wickets_taken=" + wickets_taken + "]";
	}

	
	
	

}
