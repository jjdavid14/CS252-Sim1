/* Implementation of a 32-bit adder in C.
 *
 * Author: Jamie David
 */


#include "sim1.h"



void execute_add(Sim1Data *obj)
{
	// TODO: implement me!
    
    // Initialize output to 0
    obj->sum = 0;
    
    // Check each bit and determine which bit must be on
    int i;
    int currentBitA, currentBitB, carryIn = 0;
    for(i = 0; i < 32; i++) {
        // Get current bit of A and B
        currentBitA = ((obj->a>>i) & 0x1);
        currentBitB = ((obj->b>>i) & 0x1);
        
        if (currentBitA == 0 && currentBitB == 0 && carryIn == 0)
        {
            carryIn = 0;
        }
        else if (currentBitA == 0 && currentBitB == 0 && carryIn == 1)
        {
            obj->sum = (obj->sum | (0x1<<i));
            carryIn = 0;
        }
        else if (currentBitA == 1 && currentBitB == 0 && carryIn == 0 )
        {
            obj->sum = (obj->sum | (0x1<<i));
            carryIn = 0;
        }
        else if(currentBitA == 0 && currentBitB == 1 && carryIn == 0)
        {
            obj->sum = (obj->sum | (0x1<<i));
            carryIn = 0;
        }
        else if(currentBitA == 1 && currentBitB == 1 && carryIn == 0)
        {
            carryIn = 1;
        }
        else if(currentBitA == 1 && currentBitB == 0 && carryIn == 1)
        {
            carryIn = 1;
        }
        else if(currentBitA == 0 && currentBitB == 1 && carryIn == 1)
        {
            carryIn = 1;
        }
        else if(currentBitA == 1 && currentBitB == 1 && carryIn == 1)
        {
            obj->sum = (obj->sum | (0x1<<i));
            carryIn = 1;
        }
        
        // Check for carry-out
        if(carryIn) {
            obj->carryOut = 1;
        } else {
            obj->carryOut = 0;
        }
        
        // Check for overflow
        int MSB_A = ((obj->a>>31) & 0x1);
        int MSB_B = ((obj->b>>31) & 0x1);
        int MSB_Sum = ((obj->sum>>31) & 0x1);
        
        if((MSB_A != MSB_B) && !carryIn) {
            obj->overflow = 0;
        } else {
            if(MSB_A == 1 && MSB_B == 1 && MSB_Sum == 1 && !carryIn) {
                obj->overflow = 1;
            } else if(MSB_A == 0 && MSB_B == 0 && MSB_Sum == 1 && !carryIn) {
                obj->overflow = 1;
            } else if(MSB_A == 1 && MSB_B == 0 && MSB_Sum == 1 && carryIn) {
                obj->overflow = 1;
            } else if(MSB_A == 0 && MSB_B == 1 && MSB_Sum == 1 && carryIn) {
                obj->overflow = 1;
            } else {
                obj->overflow = 0;
            }
        }
    } // END FOR-LOOP
} // END EXECUTE_ADD

