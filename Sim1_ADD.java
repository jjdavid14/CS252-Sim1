/* Simulates a physical device that performs (signed) addition on
 * a 32-bit input.
 *
 * Author: Jamie David
 */

public class Sim1_ADD
{
	public void execute()
	{
		// TODO: fill this in!
		
		boolean currentA;
		boolean currentB;
		boolean carryIn = false;
			
		// Set the sum[32]
		for(int i = 0; i < 32; i++) {
			currentA = this.a[i].get();
			currentB = this.b[i].get();

			if (currentA == false && currentB == false && carryIn == false)
			{
				this.sum[i].set(false);
				carryIn = false;
			}
			else if (currentA == false && currentB == false && carryIn == true)
			{
				this.sum[i].set(true);
				carryIn = false;
			}
			else if (currentA == true && currentB == false && carryIn == false )
			{
				this.sum[i].set(true);
				carryIn = false;
			}
			else if(currentA == false && currentB == true && carryIn == false)
			{
				this.sum[i].set(true);
				carryIn = false;
			}
			else if(currentA == true && currentB == true && carryIn == false)
			{
				this.sum[i].set(false);
				carryIn = true;
			}
			else if(currentA == true && currentB == false && carryIn == true)
			{
				this.sum[i].set(false);
				carryIn = true;
			}
			else if(currentA == false && currentB == true && carryIn == true) 
			{
				this.sum[i].set(false);
				carryIn = true;
			}
			else if(currentA == true && currentB == true && carryIn == true)
			{
				this.sum[i].set(true);
				carryIn = true;
			}
		}
		
		// Check for carry-out
		if(carryIn) {
			carryOut.set(true);
		} else {
			carryOut.set(false);
		}
		
		// Check for overflow
		if((a[31].get() != b[31].get()) && !carryIn) {
			overflow.set(false);
		} else {
			if(a[31].get() == true && b[31].get() == true && sum[31].get() == true && !carryIn) {
				overflow.set(true);
			} else if(a[31].get() == false && b[31].get() == false && sum[31].get() == true && !carryIn) {
				overflow.set(true);
			} else if(a[31].get() == true && b[31].get() == false && sum[31].get() == true && carryIn) {
				overflow.set(true);
			} else if(a[31].get() == false && b[31].get() == true && sum[31].get() == true && carryIn) {
				overflow.set(true);
			} else {
				overflow.set(true);
			}
		}
	}



	// ------ DON'T CHANGE ANYTHING BELOW THIS LINE ------

	// inputs
	public RussWire[] a,b;

	// outputs
	public RussWire[] sum;
	public RussWire   carryOut, overflow;

	public Sim1_ADD()
	{
		/* Instructor's Note:
		 *
		 * In Java, to allocate an array of objects, you need two
		 * steps: you first allocate the array (which is full of null
		 * references), and then a loop which allocates a whole bunch
		 * of individual objects (one at a time), and stores those
		 * objects into the slots of the array.
		 */

		a   = new RussWire[32];
		b   = new RussWire[32];
		sum = new RussWire[32];
		
		carryOut = new RussWire();
		overflow = new RussWire();

		for (int i=0; i<32; i++)
		{
			a  [i] = new RussWire();
			b  [i] = new RussWire();
			sum[i] = new RussWire();
		}
	}
}

