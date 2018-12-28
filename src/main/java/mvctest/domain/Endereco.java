package mvctest.domain;

import java.util.List;

public class Endereco {

	private List<Endereco> consolidated_weather;

	private String ip;
	private String city;
	private String loc;
	private String max_temp;
	private String min_temp;
	private String woeid;
	private String subdivision_1_name;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(String max_temp) {
		this.max_temp = max_temp;
	}

	public String getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(String min_temp) {
		this.min_temp = min_temp;
	}

	public String getWoeid() {
		return woeid;
	}

	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}

	public List<Endereco> getConsolidated_weather() {
		return consolidated_weather;
	}

	public void setConsolidated_weather(List<Endereco> consolidated_weather) {
		this.consolidated_weather = consolidated_weather;
	}

	public String getSubdivision_1_name() {
		return subdivision_1_name;
	}

	public void setSubdivision_1_name(String subdivision_1_name) {
		this.subdivision_1_name = subdivision_1_name;
	}

	@Override
	public String toString() {
		return "Endereco [consolidated_weather=" + consolidated_weather + ", ip=" + ip + ", city=" + city + ", loc="
				+ loc + ", max_temp=" + max_temp + ", min_temp=" + min_temp + ", woeid=" + woeid
				+ ", subdivision_1_name=" + subdivision_1_name + "]";
	}
	
	

}