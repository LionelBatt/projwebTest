package model;


public class Article {

    private String ref;
    private String marque;
    private double prix;


    public Article() {
    }

    public Article(String ref, String marque, double prix) {
        this.ref = ref;
        this.marque = marque;
        this.prix = prix;
    }


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

	@Override
	public String toString() {
		return "Article [ref=" + ref + ", marque=" + marque + ", prix=" + prix + "]";
	}
    
}
