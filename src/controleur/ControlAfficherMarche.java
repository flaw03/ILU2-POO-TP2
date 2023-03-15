package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;

	}
	public String[] donnerMarcher(){
		return village.donnerEtatMarche();
	}

	//TODO a completer
}
