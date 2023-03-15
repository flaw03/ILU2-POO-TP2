package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;



	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public  Gaulois[] trouveVendeurs (String nomProduit){
		return village.rechercherVendeursProduit(nomProduit);
	}

	public int nbrProduitDisponible(Gaulois vendeur){
		Etal etal =village.rechercherEtal(vendeur);
		return etal.getQuantite();
	}

	public void acheterProduit(int nbrProduit,Gaulois vendeur){
		Etal etal =village.rechercherEtal(vendeur);
		etal.acheterProduit(nbrProduit);
	}
	//TODO a completer
}
