/* RussWire class
 *
 * Reprements a "wire" in the simulation.  It can only be set once - which
 * represents connecting that wire to some sort of "driver".  It can be read
 * many times (though only after it has been set).
 *
 * (If you attempt to read the value before it is set, it throws
 * IllegalArgumentException.)
 *
 * Author: Russell Lewis
 */

public class RussWire
{
	public void set(boolean val)
	{
		if (this.isSet)
			throw new IllegalArgumentException("A RussWire was set multiple times.");

		this.val   = val;
		this.isSet = true;
	}

	public boolean get()
	{
		if (this.isSet == false)
			throw new IllegalArgumentException("A RussWire was read before it had been set.");
		return this.val;
	}


	public RussWire()
	{
		this.isSet = false;
	}

	public String toString()
	{
		if (this.get())
			return "true";
		else
			return "false";
	}


	private boolean isSet;
	private boolean val;
}

