class Solution {
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1; 
        }

        return a;
    }
}

/**
et a = 13 and b = 10. Then we want to add them, a+b
In binary, it would look as follows -
a      =  1 1 0 1
b      =  1 0 1 0
--------------------
a+b = (1) 0 1 1 1
Now we can break the addition into two parts, one is simple addition without taking care of carry, and other is taking the carry.
With that strategy in mind, we have the following -
simpleAddition(a, b):
a      =  1 1 0 1
b      =  1 0 1 0
--------------------
a+b    =  0 1 1 1  

carry(a, b):
carry = 1 0 0 0 0
*shift left by one, because we add the carry next left step :P
Now if we can add the carry to our simpleAddition result, we can get our final answer. So add them using the simpleAddition method, and take care of the new carry again, unless carry becomes zero.
This simpleAddition is performed by XOR ^operator, and the carry is performed by AND &operator.
So our final answer would look as -
(a^b) =    0 1 1 1 
+carry = 1 0 0 0 0 
-----------------------------
ans =    1 0 1 1 1
-----------------------------
which is 23
 */