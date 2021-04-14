#include <stdio.h>
#include <stdlib.h>
// Student ID: 201471422
// Name: Juana Patankar

int main(void) {
	// Declare variables here (C syntax)
	// Declare prompt messages
	char msg[] = "How many numbers: ";
	char getInput[] = "Enter a number: ";

	// Declare messages for each count output
	char zeromsg[] = "\nNumber of 0s: %d";
	char posmsg[] = "\nNumber of +ves: %d";
	char negmsg[] = "\nNumber of -ves: %d";
	char fmt[] = "%d";
	
	// Declare variables to store counts, and the current number
	int zerocount = 0;
	int poscount = 0;
	int negcount = 0;
	int remaining = 0;
	int current = 0;

	_asm {
		// Put assembly code here
		lea eax, msg
		push eax
		call printf					; load a prompt for the number of numbers that will be inputted
		pop eax
		lea ebx, remaining
		push ebx
		lea eax, fmt
		push eax
		call scanf					; store the user's input as an integer, to the C variable remaining
		pop eax
		pop ebx
		mov ebx, remaining
		cmp ebx, 0
		jg newnumber
		jmp output					; receive the first number, or jump straight to output

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
		sub ebx, 1					; decrement the number of inputs remaining
		lea eax, getInput
		push eax
		call printf					; print a prompt for a number to be tested
		pop eax

		lea eax, current
		push eax
		lea eax, fmt
		push eax
		call scanf					; store the inputted number to current
		pop eax
		pop eax		

		cmp current, 0				; test if pos/neg/zero input
		jg incpos					; jumps to increment the approporiate count
		jl incneg
		je inczero

	outornew:
<<<<<<< HEAD
		cmp ebx, 0					; tests if more numbers to input
		jz output					; output counts if no more numbers
		jmp newnumber				; get the next input (loop)
=======
		cmp ebx, 0
		jz output
		jmp newnumber
	
	
	//gleepeeeeeeeeeeeeeeeeeey

>>>>>>> 8ef485ff48d90faacca31a9300a7563283e00120
	
	output: 
		mov eax, [zerocount]
		push eax
		lea eax, zeromsg			; print number of zeroes
		push eax
		call printf
		pop eax
		pop eax
		
		mov eax, [poscount]
		push eax
		lea eax, posmsg				; print labelled number of positive integers
		push eax
		call printf
		pop eax
		pop eax

		mov eax, [negcount]
		push eax
		lea eax, negmsg				; print labelled neg count
		push eax
		call printf
		pop eax
		pop eax
			
	}
return 0;
}
