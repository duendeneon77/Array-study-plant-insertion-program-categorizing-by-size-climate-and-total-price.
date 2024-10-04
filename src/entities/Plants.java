package entities;

public class Plants {
	
	private String plantName;
	private String climate;
	private String size;
	private Double price;
	
	

	public Plants() {}

	public Plants(String plantName, String climate, String size, Double price) {
		super();
		this.plantName = plantName;
		this.climate = climate;
		this.size = size;
		this.price = price;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Plants [plantName=" + plantName + ", climate=" + climate + ", size=" + size + ", price=" + price + "]";
	}
	
}
