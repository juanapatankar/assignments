#include <stdio.h>
#include <stdlib.h>

int main(void) {
	// Declare variables here (C syntax)
	int num = 15;
	_asm {
		// Put assembly code here
			mov	eax, num
			sub eax, 10
			jnz store
		store:
			mov num, eax
	}
	return 0;
}