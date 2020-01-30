import re

'''
🚀 YOUR GOAL 🚀 is to find as many substrings as possible that contain all five vowels
    a e i o u
and contain absolutely no consonants
    b c d f g h j k l m n p q r s t v w x y z

Here's an example:
Let the string a = "aaaeiouxuaei"

There will a total of 3 substrings:
1) aaaeiou
2) aaeiou
3) aeiou

GOOD LUCK!
'''

vowels = "aeiou"
consonants = "bcdfghjklmnpqrstvwxyz"

def main():
    s = "aaeiouuxaeiuxaeioouxaaaaaaeioaiueieooeaaiexaioueioaiaxaauuaouxaoieuaox"
    substrings = findSubstrings(s)
    print(substrings)
    print("\nNumber of valid substrings:", len(substrings))

def findSubstrings(s):
    validSubstrings = []
    s = s.lower()
    # --------------------
	# Your code goes here!
	# --------------------
    return validSubstrings

main()
