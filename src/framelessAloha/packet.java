package framelessAloha;

public class packet {
	private int count = 0 ;
	public int getCount() {
		return count;
	}
	public int numberOfRetrans() {
		return count++ ;
	}
}
