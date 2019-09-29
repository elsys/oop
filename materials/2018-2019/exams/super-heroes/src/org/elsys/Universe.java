package org.elsys;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Universe {

	public Universe(String s)
	{
	}

	public String getName()
	{
		return null;
	}

	public boolean addCharacter(SpecialPowersCharacter character) {
		return false;
	}

	public void beat(SuperHero hero, SuperVillain villain) {

	}

	public Collection<SuperVillain> getDeadVillains() {
		return null;
	}

	public int getScore(SpecialPowersCharacter character) {
		return 0;
	}

	public void resurrectVillain(SuperVillain villain) {

	}

	public SpecialPowersCharacter getTopCharacter() {
		return null;
	}

	public void actNasty(SuperVillain villain) {

	}

	public Map<Integer, List<SuperHero>> getHeroesByScore() {
		return null;
	}

	public List<String> getHeroesNamesOrderedByScore() {
		return null;
	}

	public Universe mergeWith(Universe other) {
		return null;
	}
}
