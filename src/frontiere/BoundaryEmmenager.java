package frontiere;

import java.util.Iterator;

import javax.sql.rowset.spi.SyncResolver;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;
	

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println(
							"Bienvenue Villageois");
					StringBuilder question2 = new StringBuilder();
					question2.append("Quelle est votre force ?\n");
					int force = Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Bienvenue druide ");
		chaine.append(nomVisiteur +"\n");
		chaine.append("Quellle est votre force ?\n");
		int forceDruide = Clavier.entrerEntier(chaine.toString());
		StringBuilder question1= new StringBuilder();
		question1.append(
				"Quelle est la force de potion la plus faible que vous produisez ? \n");
		StringBuilder question2 = new StringBuilder();
		question2.append(
			"Quelle est la force de potion la plus forte que vous produisez ?\n");
		int effetPotionMin = Clavier.entrerEntier(question1.toString());
		int effetPotionMax = Clavier.entrerEntier(question2.toString());
		while (effetPotionMin > effetPotionMax) {
			System.out.println(
					"Attention Druide, vous vous êtes trompé entre le minimun et le maximun \n");
			effetPotionMin = Clavier.entrerEntier(question1.toString());
			effetPotionMax = Clavier.entrerEntier(question2.toString());
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);

		
		
	}
}
