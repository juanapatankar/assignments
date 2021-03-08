#include <stdio.h>
#include <stdlib.h>

int main(void) {
	// Declare variables here (C syntax)
	char fmt[] = "%d%";
	char msg[] = "How many numbers: ";
	int totalNum;

	char input[] = "Enter a number: ";
	int nextNum;

	int posCount = 0;
	int negCount = 0;
	int zeroCount = 0;


	_asm {
		// Put assembly code here
		lea ecx, msg
		push ecx
		call printf
		pop ecx
		lea ecx, totalNum
		push ecx
		lea ecx, fmt		;waas
		push ecx
		call scanf
		add esp, 8
		
	getInput: lea eax, input
		push eax
		call printf
		pop eax
		lea eax, nextNum
		push eax
		lea eax, fmt
		push eax
		call scanf
		add esp, 8
		lea eax, nextNum
		

		lea ebx
	zero: lea ebx, zeroCount
		push ebx
		inc ebx
		push ebx


		



	}
	return 0;
}