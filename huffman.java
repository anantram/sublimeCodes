/*
The best example for lossless compression is Huffman coding. 
Implement the Huffman coding algorithm using greedy method.

Refer to the program given in the following link.
https://en.wikipedia.org/wiki/Huffman_coding

Input:

The first line contains the number of characters.

From the second line onwards there will be a character along with the frequency.
They are separated by spaces.

Output:

Output of each line should contains the character along with the codes.
(Sort the codes based on the length, if tie, follow the lexicographic order for characters)
The last line of the output contains the total number of bits required.

Sample Input:

6
a 12
b 2
c 7
d 13
e 14
f 85

Sample Output:

f: 1
a: 001
d: 010
e: 011
b: 0000
c: 0001
238
*/
