#include <stdio.h>
#include <stdlib.h>
// Student ID: 201471422
// Name: Juana Patankar

int main(void) {
	// Declare variables here (C syntax)
	char msg[] = "How many numbers: ";
	char getInput[] = "Enter a number: ";
	char zeromsg[] = "Number of 0s: ";
	char posmsg[] = "Number of +ves: ";
	char negmsg[] = "Number of -ves: ";
	char newln[] = "\n";
	char fmt[] = "%d";
	int remaining = 0;
	int zero = 1;
	int pos = 0;
	int neg = 0;
	int current = 0;

	_asm {
		// Put assembly code here
		lea eax, msg
		push eax
		call printf
		add esp, 8
		lea eax, remaining
		push eax
		lea eax, fmt
		push eax
		call scanf
		lea ecx, remaining
		add esp, 8
		push ecx
		jmp newnumber
		jz output
		

	newnumber:
		lea eax, getInput
		push eax
		call printf
		lea eax, current
		push eax
		lea eax, fmt
		push eax
		call scanf
		pop eax
		pop eax
		mov ecx, eax
		sub [ecx], 1
		mov ecx, eax
		push eax
		jmp newnumber
		jz output

	output: 
		lea eax, zeromsg
		push eax
		call printf
		pop eax
		lea eax, zero
		push eax
		lea eax, fmt
		push eax
		call printf
		pop eax
		pop eax
		lea eax, newln
		push eax
		call printf
		pop eax
		lea eax, posmsg
		push eax
		call printf
		pop eax
		lea eax, pos
		push eax
		lea eax, fmt
		push eax
		call printf
		pop eax
		pop eax
		lea eax, newln
		push eax
		call printf
		pop eax
		lea eax, negmsg
		push eax
		call printf
		pop eax
		lea eax, neg
		push eax
		lea eax, fmt
		call printf
		pop eax
		pop eax
		lea eax, newln
		push eax
		call printf
		pop eax


	


	}
return 0;
}