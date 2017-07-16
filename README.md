# Quicken_Loans_Assigments
Quicken_Loans_Assigments

Write a MapReduce program(Preferably in Java) to find common friends between two friends in a social network. Input to this program is the a person with list of their friends:
A -> B C D
B -> A C D E
C -> A B D E
D -> A B C E
E -> B C D

The Input file for the mapper is /* The input for the mapper are 
A : B C D
B : A C D E
C : A B D E
D : A B C E
E : B C D
*/

The each mapper output is below

A B     B C D
A C     B C D
A D     B C D
A B     A C D E
B C     A C D E
B D     A C D E
B E     A C D E
A C     A B D E
B C     A B D E
C D     A B D E
C E     A B D E
A D     A B C E
B D     A B C E
C D     A B C E
D E     A B C E
B E     B C D
C E     B C D
D E     B C D

The reducer output is 
A B     C D
A C     B D
A D     B C
B C     A D E
B D     A C E
B E     C D
C D     A B E
C E     B D
D E     B C


Write a program to sort a list of strings. Calculate the time complexity of the program.

I wrote the Quicksort logic to sort the list of string. The time complexity for the best case is O(nlogn) and the worst is O(n^2). I wrote in the python script.


