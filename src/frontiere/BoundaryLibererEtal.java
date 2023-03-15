package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)){
			System.out.println("Mais vous n'êtes pas un vendeur sur notre marché aujourd'hui !\n");
		}
		else{
			String donnnesEtal[] =controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.parseBoolean(donnnesEtal[0]);
			if (etalOccupe){
				String produit = donnnesEtal[2];
				int quantiteInitial = Integer.parseInt(donnnesEtal[3]);
				int quantiteVendu = Integer.parseInt(donnnesEtal[4]);
				System.out.println("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitial + " " + produit + ".\n");
				System.out.println("Au revoir "+nomVendeur + "passez une bonne journée");
			}
		}

	}

}
