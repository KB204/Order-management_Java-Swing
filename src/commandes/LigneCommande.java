package commandes;

public class LigneCommande {
	Commande commande;
	Produit produit;
	private int qteCommandee;
	private double reduction;
	
	public LigneCommande() {
		this.qteCommandee = 0;
		this.reduction = 0.0;
	}
	
	public LigneCommande(Commande commande,Produit produit,int qteCommandee,double reduction) {
		this.commande  = commande;
		this.produit = produit;
		this.qteCommandee = qteCommandee;
		this.reduction= reduction;
	}
	
	
	public int getQtecmd() {	return qteCommandee;	}
	
	public double getReduction() {	return reduction;	}
	
	
	public void setQtecmd(int qteCommandee) {	this.qteCommandee = qteCommandee; }
	
	public void setReduction(double reduction) {	this.reduction = reduction;	}
	
	public double calculTotalProduit() {
	   
	    double prixTotalAvantReduction = produit.getPrix() * qteCommandee;

	    double montantReduction = (prixTotalAvantReduction * reduction) / 100.0;

	    double prixTotalApresReduction = prixTotalAvantReduction - montantReduction;

	    return prixTotalApresReduction;
	}

}
