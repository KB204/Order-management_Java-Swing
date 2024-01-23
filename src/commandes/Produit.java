package commandes;

public class Produit {
	private int id;
	private String designation;
	private double prixUnitaire;
	private int qteStock;
	
	public Produit() {
		this.id = 0;
		this.designation = "";
		this.prixUnitaire = 0.0;
		this.qteStock = 0;
	}
	
	public Produit(int id ,String designation ,double prixUnitaire ,int qteStock) {
		this.id = id;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}
	
	public int getId() {	return id;	}
	
	public String getDes() {	return designation; }
	
	public double getPrix() {	return prixUnitaire;	}
	
	public int getQte() {	return qteStock;	}
	
	public void setId(int id) {	this.id = id;	}
	
	public void setDes(String designation) {	this.designation = designation;	}
	
	public void setPrix(double prixUnitaire) {	this.prixUnitaire = prixUnitaire; }
	
	public void setQte(int qteStock) {	this.qteStock = qteStock;	}
	
}
