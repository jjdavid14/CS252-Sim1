/* Simulates a physical AND gate.
 *
 * Author: Jamie David
 */

public class Sim1_AND
{
	public void execute()
	{
		// TODO: fill this in!
		this.out = a && b;
	}



	public RussWire a,b;   // inputs
	public RussWire out;   // output

	public Sim1_AND()
	{
		// TODO: fill this in!
		a   = new RussWire();
		b   = new RussWire();
		out = new RussWire();
	}
}

