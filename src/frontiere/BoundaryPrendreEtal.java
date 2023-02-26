package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {

		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean vendeurConnue = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!vendeurConnue){
			System.out.println(
				"Je suis désolée "+nomVendeur+ " mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println(
				"Bonjour  " +nomVendeur +" je vais regarder si je peux vous trouver un étal" );
			if (!controlPrendreEtal.resteEtals()){
				System.out.println(
					"Désoler "+ nomVendeur +"je n'ai plus d'étal qui ne sont pas déja occupé");
			}
			else{
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println(
			"C'est parfait, il me reste un étal pour vous !\n");
		System.out.println(
			"Il me faut quelque renseignenments  : \n"
		);
		System.out.println("Quel Produit souhaitez-vous vendre ?\n");
		String nomProduit = scan.nextLine();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, nomProduit, nbProduit);
		if (numEtal != -1){
			System.out.println(
				"Le vendeur "+ nomVendeur +"s'est bien installé à l'etal n°"+numEtal+".");
		}
	}
}
