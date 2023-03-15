package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;
import personnages.Gaulois;

import static frontiere.Clavier.entrerEntier;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	private  ControlVerifierIdentite controlVerifierIdentite;

	public BoundaryAcheterProduit(
			ControlAcheterProduit controlAcheterProduit ,ControlVerifierIdentite controlVerifierIdentite) {
		this.controlAcheterProduit = controlAcheterProduit;
		this.controlVerifierIdentite = controlVerifierIdentite;
	}

	public void acheterProduit(String nomAcheteur) {
		Boolean villageois = controlVerifierIdentite.verifierIdentite(nomAcheteur);
		System.out.println("Quel produit voulez-vous acheter ?");
		String nomProduit = scan.nextLine();

		Gaulois vendeurs[] = controlAcheterProduit.trouveVendeurs(nomProduit);
		 if(!villageois){
			 System.out.println("Desolé mais on vend que au villageois et vous n'en faite pas partie.");
		 }
		 else if(vendeurs == null){
			 System.out.println("Désolé mais personne ne vend de " + nomProduit + " ici allez vois ailleur ");
		 }
		 else{
		 	StringBuilder question = new StringBuilder();
			question.append("Chez quel commercant voulez vous acheter des fleurs ?\n");

			for(int i = 0; i<vendeurs.length ; i++){
				question.append(i+1+" -"+vendeurs[i].getNom()+"\n");
			}
			int choix = entrerEntier(question.toString());
			while (choix  <= vendeurs.length && choix >0){
				choix = entrerEntier(question.toString());
			}

			Gaulois vendeur = vendeurs[choix-1];
			System.out.println(nomAcheteur+" se deplace jusqu'à l'étal du vendeur "+vendeur.getNom()+"\n" );
			StringBuilder question2 = new StringBuilder();

			int nbrProduitDisponible = controlAcheterProduit.nbrProduitDisponible(vendeur);

			if (nbrProduitDisponible == 0) {
				System.out.println("Désole mais " + vendeur.getNom() + " n'a plus de " + nomProduit + " a vendre\n");
			}
			else {
				question2.append("Combien de "+nomProduit + " voulez vous acheter ?\n");
				int nbrProduit = entrerEntier(question2.toString());

				while (nbrProduit > nbrProduitDisponible) {
					System.out.println(vendeur.getNom() +"n'a que "+nbrProduitDisponible +" de "+nomProduit+"\n");
					nbrProduit = entrerEntier(question2.toString());
				}

				controlAcheterProduit.acheterProduit(nbrProduit,vendeur);
				System.out.println(
						nomAcheteur + " a acheter "+ nbrProduit+ " de "+nomProduit+" a " + vendeur.getNom() +"\n");
			}
		}
	}
}
