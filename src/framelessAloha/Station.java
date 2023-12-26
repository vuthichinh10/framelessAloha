package framelessAloha;

public class Station {
	  	private int id;
	  	private packet pk = new packet();
	    private boolean isPacketSent;
	    private int packetsSent;
	    private int packetsReceived;

	    public Station(int id) {
	        this.id = id;
	        this.isPacketSent = false;
	        this.packetsSent = 0;
	        this.packetsReceived = 0;
	    }

	    public void sendPacket(boolean check) {
	    	if(check) {
	    		this.isPacketSent = true;
	  	        this.packetsSent++;
	    	}else {
	    		this.isPacketSent = false ;
	    	}
	    }

	    public void receivePacket(boolean success) {
	        if (success) {
	        	this.packetsReceived++;
	            System.out.println("Station " + this.id + " receives packet successfully");
	        } else {
	            System.out.println("Station " + this.id + " receives packet with collision");
	        }
	 
	    }
	    public int fNumberOfRetrans () {
	    	return pk.numberOfRetrans();
	    }
	    public int getnumberOfRetrans() {
	    	return pk.getCount();
	    }
	    public int getPacketsReceived() {
	    	 return this.packetsReceived ;
	    	 
	    }

	    public int getId() {
	        return this.id;
	    }

	    public boolean isPacketSent() {
	        return this.isPacketSent;
	    }

	    public int getPacketsSent() {
	        return packetsSent ;
	    }
}
