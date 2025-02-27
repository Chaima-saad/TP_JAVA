

class SAL_NEG extends Exception{
    SAL_NEG(){ super();}
}
abstract class Personnel {
    String nom;	 double salaireBase;

    // Constructeur
    public Personnel(String nom, double salaireBase)  {
        this.nom = nom;
        try {
            if (salaireBase<=0) throw new SAL_NEG();
            this.salaireBase = salaireBase;
        }
        catch (SAL_NEG a){
            System.out.println("valeur de salaire invalide!!");
        }
    }
    // Méthode abstraite à définir dans les sous-classes
    public abstract double calculSalaire();

}


class Directeur extends Personnel {
    double prime;

    public Directeur(String nom, double salaireBase, double prime) {
        super(nom, salaireBase);
        this.prime = prime;
    }

    @Override
    public double calculSalaire() {
        return salaireBase + prime;
    }
}


class CadreSuperieur extends Personnel {
    private double bonusPerformance;
    public CadreSuperieur(String nom, double salaireBase, double bonusPerformance) {
        super(nom, salaireBase);
        this.bonusPerformance = bonusPerformance;
    }
    @Override
    public double calculSalaire() {
        return salaireBase + (salaireBase * bonusPerformance / 100);
    }
}

class Employe extends Personnel {
    private int heuresSupp;
    private double tauxHoraire;

    public Employe(String nom, double salaireBase, int heuresSupp, double tauxHoraire) {
        super(nom, salaireBase);
        this.heuresSupp = heuresSupp;
        this.tauxHoraire = tauxHoraire;
    }

    @Override
    public double calculSalaire() {
        return salaireBase + (heuresSupp * tauxHoraire);
    }
}


public class TestAbstractPersonnel {
    public static void main(String[] args) {
        Personnel directeur = new Directeur("Amel", 5000, 2000);
        Personnel cadre = new CadreSuperieur("Jamel", 4000, 10);
        Personnel employe = new Employe("Mourad", 2500, 10, 15);

        // Affichage des salaires
        System.out.println("\tSALAIRES DES PERSONNELS");
        System.out.println("\t\t - "+directeur.nom
                + " : Salaire = " + directeur.calculSalaire() + "DT");
        System.out.println("\t\t - "+cadre.nom
                + " : Salaire = " + cadre.calculSalaire() + "DT");
        System.out.println("\t\t - "+employe.nom
                + " : Salaire = " + employe.calculSalaire() + "DT");
    }
}

