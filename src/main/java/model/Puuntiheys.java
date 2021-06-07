package model;

public class Puuntiheys {
	
	private int id;
	private double tiheys, paksuus, leveys, paino, pituus;
	private String grain;
	
	public Puuntiheys(int id, double tiheys, double paksuus, double leveys, double paino, double pituus, String grain) {
		super();
		this.id = id;
		this.tiheys = tiheys;
		this.paksuus = paksuus;
		this.leveys = leveys;
		this.paino = paino;
		this.pituus = pituus;
		this.grain = grain;
	}

	public Puuntiheys() {
		
	}

	public Puuntiheys(double tiheys, double paksuus, double leveys, double paino, double pituus, String grain) {
		super();
		this.tiheys = tiheys;
		this.paksuus = paksuus;
		this.leveys = leveys;
		this.paino = paino;
		this.pituus = pituus;
		this.grain = grain;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTiheys() {
		return tiheys;
	}

	public void setTiheys(double tiheys) {
		this.tiheys = tiheys;
	}

	public double getPaksuus() {
		return paksuus;
	}

	public void setPaksuus(double paksuus) {
		this.paksuus = paksuus;
	}

	public double getLeveys() {
		return leveys;
	}

	public void setLeveys(double leveys) {
		this.leveys = leveys;
	}

	public double getPaino() {
		return paino;
	}

	public void setPaino(double paino) {
		this.paino = paino;
	}

	public double getPituus() {
		return pituus;
	}

	public void setPituus(double pituus) {
		this.pituus = pituus;
	}

	public String getGrain() {
		return grain;
	}

	public void setGrain(String grain) {
		this.grain = grain;
	}


	@Override
	public String toString() {
		return "Balsalevy [id=" + id + ", tiheys=" + tiheys + ", korkeus=" + paksuus + ", leveys=" + leveys + ", paino="
				+ paino + ", pituus=" + pituus + ", grain=" + grain + "]";
	}
	
	

}
