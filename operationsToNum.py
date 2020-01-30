import itertools

'''
Your goal is to determine all of the possible equations that make a target number, given a string of numbers to work with.
This should be completed with only addition and subtraction.

For example, for a "number string" of "12345" and a "number to sum to" of 23:
Solutions found:
        23=-1+23-4+5
        23=1+23+4-5
        23=1-23+45

Good luck!
'''

def add_to(s, num):
	solutions = []
	# --------------------
	# Your code goes here!
	# --------------------
	return solutions

if __name__ == "__main__":
	s = input("Enter the number string: ")
	while not s.isdigit():
		s = input("This isn't a number! Try again: ")

	num = input("Enter a number to sum to: ")
	while not num.isdigit():
		s = input("This isn't a number! Try again: ")

	num = int(num)
	solutions = add_to(s, num)

	print("")
	if len(solutions) > 0:
		print("Solutions found:")
		for solution in solutions:
			print("\t" + solution)
	else:
		print("No solutions found")
