package commandes;

public class Client {
	private int id;
	private String nom;
	private String adresse;
	private int tel;
	
	public Client() {
		this.id = 0;
		this.nom = "";
		this.adresse = "";
		this.tel = 0;
	}
	
	public Client(int id ,String nom ,String adresse ,int tel) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
	}
	
	public int getId() {	return id;	}
	
	public String getNom() {	return nom; }
	
	public String getAdresse() {	return adresse;	}
	
	public int getTel() {	return tel;	}
	
	public void setId(int id) {	this.id = id;	}
	
	public void setNom(String nom) {	this.nom = nom;	}
	
	public void setAdresse(String adresse) {	this.adresse = adresse; }
	
	public void setTel(int tel) {	this.tel = tel;	}
	
	public String toString()
	{
		return "L'identifiant du client : "+id+"\nNom et prénom du client : "+nom+"\nLe numéro de téléphone du client: "+tel+"\nL'adresse du client : "+adresse;
	}
	
	
}
