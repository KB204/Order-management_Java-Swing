package commandes;
import java.time.LocalDate;


public class Commande {
	private int id;
	private LocalDate date;
	private String type;
	private int payee;
	Client client;
	
	public Commande() {
		this.id = 0;
		this.date = LocalDate.parse("");
		this.type = "";
		this.payee = 0;
	}
	
	public Commande(int id ,LocalDate date, String type, int payee, Client client) {
		this.id = id;
		this.date = date;
		this.type = type;
		this.payee = payee;
		this.client = client;
	}
	
    public int getId() {	return id;	}
	
    public LocalDate getDate() {	return this.date; }
	
	public String getType() {	return type;	}
	
	public int getPayee() {	return payee;	}
	
	public void setId(int id) {	this.id = id;	}
	
	public void setDate(LocalDate date) {	this.date = date;	}
	
	public void setType(String type) {	this.type = type; }
	
	public void setPayee(int  payee) {	this.payee = payee;	}
	
	public double calculTotalCommande(LigneCommande[] T,int n)
	{
		double S=0;
		int i;
		for(i=0;i<n;i++)
		{
			S=S+T[i].calculTotalProduit();
		}
		return S;
	}
	
	public String toString()
	{
		return "Client : "+client.getNom()+"\nNuméro de la commande : "+id+"\nStatus : "+payee+"\nDate de la commande : "
	+date+"\nType de la commande : "+type;
	}

}
