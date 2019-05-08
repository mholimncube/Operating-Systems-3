
public class Carbon extends Thread {
	
	private static int carbonCounter =0;
	private int id;
	private Methane sharedMethane;
	
	public Carbon(Methane methane_obj) {
		Carbon.carbonCounter+=1;
		id=carbonCounter;
		this.sharedMethane = methane_obj;
	}
	
	public void run() {
	    try {	 
	    	 // you will need to fix below
	    	
	    	sharedMethane.mutex.acquire(); //first carbon thread to methane blocks other threads to bond
	    	sharedMethane.addCarbon(); //makes a bond C if C thread gets there before 4 H threads
	    	//conditions for group to bond
	    	if(sharedMethane.getHydrogen() >=4){
	    		sharedMethane.carbonQ.release();
	    		sharedMethane.removeCarbon(1);
	    		sharedMethane.hydrogensQ.release();
	    		sharedMethane.removeHydrogen(4);
	    	}
	    	else{
	    		sharedMethane.mutex.release();
	    	}
	    	sharedMethane.carbonQ.acquire();
	    	System.out.println("---Group ready for bonding---");	
	    	sharedMethane.bond("C"+ this.id);  //bond
	    	sharedMethane.barrier.b_wait(); //threads wait at the barriere
	    	sharedMethane.mutex.release();

	    	 
	    	   	 
	    }
	    catch (InterruptedException ex) { /* not handling this  */}
	   // System.out.println(" ");
	}

}
