package server;

public class History implements java.io.Serializable {
	private String history;
	
	public History () {
		history = null;
	}
	public History (String s) {
		history = s;		
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}

}
