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
	char ifmt[] = "%s";
	char fmt[] = "%d";
	int remaining = 0;
	int zerocount = 0;
	int poscount = 0;
	int negcount = 0;
	int current = 0;

	_asm {
		// Put assembly code here
		lea eax, msg
		push eax
		call printf
		pop eax
		lea ebx, remaining
		push ebx
		lea eax, fmt
		push eax
		call scanf
		pop eax
		pop ebx
		mov ebx, remaining
		jmp newnumber

	incpos:
		add [poscount], 1
		jmp outornew

	incneg:
		add [negcount], 1
		jmp outornew

	inczero:
		add [zerocount], 1
		jmp outornew

	newnumber:
		lea eax, getInput
		push eax
		call printf
		pop eax
		lea eax, current
		push eax
		lea eax, fmt
		push eax
		call scanf
		pop eax
		pop eax
		mov eax, current
		sub ebx, 1				; restart loop to get next number, or print output
		mov eax, ebx
		cmp current, 0
		jg incpos
		jl incneg
		je inczero

	outornew:
		cmp ebx, 0
		jz output
		jmp newnumber
	
	
	

	

	output: 
		lea eax, zeromsg
		push eax
		call printf
		pop eax
		lea eax, ifmt
		push eax
		lea ebx, zerocount
		push ebx
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
		lea eax, poscount
		push eax
		lea eax, ifmt
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
		lea eax, negcount
		push eax
		lea eax, ifmt
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