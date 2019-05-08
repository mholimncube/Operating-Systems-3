
public class Hydrogen extends Thread {

	private static int carbonCounter =0;
	private int id;
	private Methane sharedMethane;
	
	
	public Hydrogen(Methane methane_obj) {
		Hydrogen.carbonCounter+=1;
		id=carbonCounter;
		this.sharedMethane = methane_obj;
		
	}
	
	public void run() {
	    try {
	    	 // you will need to fix below
	    	sharedMethane.mutex.acquire(); //the number 1 thread to gain access, blocks others
	    	sharedMethane.addHydrogen(); //add hydrogen if there is no other hydrogen bond already there on condtion there is carbon bond existing or wait
	    	
	    	//condition to form a Methane has to be CH4 (1 carbon, 4 hydrogen atoms must be bonded)
	    	//check if carbon atoms in methane is = 1 or more && check if hydrogen atoms in methane is = 4 or mor
	    	if(sharedMethane.getCarbon() >= 1 && sharedMethane.getHydrogen() >= 4){
	    		sharedMethane.carbonQ.release();
	    		sharedMethane.removeCarbon(1);
	    		sharedMethane.hydrogensQ.release(4);
	    		sharedMethane.removeHydrogen(4);
	    	}
	    	else{
	    		sharedMethane.mutex.release();
	    	}
	    	sharedMethane.hydrogensQ.acquire();
	    	System.out.println("---Group ready for bonding---");			 
	    	sharedMethane.bond("H"+ this.id); //the bonding stage
	    	sharedMethane.barrier.b_wait(); //threads wait at the barrier

	    }
	   catch (InterruptedException ex) { /* not handling this  */}
	    //System.out.println(" ");
	}

}
