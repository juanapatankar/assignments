#include <stdio.h>
#include <stdlib.h>

int main(void) {
	// Declare variables here (C syntax)
	char input[] = "Enter a number: ";
	char posCount[] = "Number of positive integers: %d";
	char negCount[] = "Number of negative integers: %d";
	char zeroCount[] = "Number of zeroes: %d";
	int n = 0;
	_asm {
		// Put assembly code here
		
		lea eax, input
		push eax
		call printf
		add esp, 4
		lea eax, n
		push eax
		call scanf
		add esp, 4
	}
	return 0;
}