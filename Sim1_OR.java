/* Simulates a physical OR gate.
 *
 * Author: Jamie David
 */

public class Sim1_OR
{
	public void execute()
	{
		// TODO: fill this in!
		this.out.set(a.get() || b.get());
	}



	public RussWire a,b;   // inputs
	public RussWire out;   // output

	public Sim1_OR()
	{
		// TODO: fill this in!
		a   = new RussWire();
		b   = new RussWire();
		out = new RussWire();
	}
}

