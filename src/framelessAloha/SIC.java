package framelessAloha;

public class SIC {
	  public  boolean isCollision(Station[] stations) {
	        for (int i = 0; i < stations.length - 1; i++) {
	            for (int j = i + 1; j < stations.length; j++) {
	                if (stations[i].isPacketSent() && stations[j].isPacketSent()) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

}
