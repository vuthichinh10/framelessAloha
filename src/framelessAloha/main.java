package framelessAloha;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
public class main {
		public static void main(String[] args) throws InterruptedException {
			int numberOfStation = 10 ;
			int time = 60000 ;
			int count = 0  ;
	        // Khởi tạo các trạm phát và trạm nhận
	        Station[] stations = new Station[numberOfStation] ;
	        for (int i = 0; i < numberOfStation; i++) {
	            stations[i] = new Station(i);
	        }
	       SIC applicableObj = new SIC();
	        // Lặp lại cho đến khi tất cả các gói dữ liệu được truyền đi
	        for (int i = 0; i < time/500; i++) {
	        	Thread.sleep(500);
	        	count++;
	          // Mỗi trạm phát sẽ phát một gói dữ liệu với một xác suất nhất định
	        	for (Station station : stations) {
	                if (Math.random() < 0.1) {
	                    station.sendPacket(true);
	                }
	            }

	            // Xử lý xung đột
	            for (Station station : stations) {
	                if (station.isPacketSent()) {
	                    if (applicableObj.isCollision(stations)) {
	                    	if( station.getnumberOfRetrans() == 3)
	                    		station.receivePacket(false);
	                    	else
	                    		station.fNumberOfRetrans();
	                 
	                    } else {
	                        station.receivePacket(true);
	                    }
	                }
	            }
	            for (Station station : stations) {
	                    station.sendPacket(false);
	            }
	        }

	       // số gói phát đi 
	        int totalPacketsSent = 0;
	        for (Station station : stations) {
	            totalPacketsSent += station.getPacketsSent();
	        }
	       // số gói nhận được
	        int totalPacketsReceivedSuccessfully = 0;
	        for (Station station : stations) {
	            totalPacketsReceivedSuccessfully += station.getPacketsReceived();
	        }
	        // In kết quả
//	        for (Station station : stations) {
//	            System.out.println("Station " + station.getId() + ", " + station.getPacketsSent() + " packets sent, " + station.getPacketsReceived() + " packets received");
//	        }
	        System.out.println("Tổng số gói gửi đi là : "  + totalPacketsSent) ;
	        System.out.println("Tổng số gói nhận được là  : "  + totalPacketsReceivedSuccessfully);
	        System.out.println(count);
	    }
		
}
