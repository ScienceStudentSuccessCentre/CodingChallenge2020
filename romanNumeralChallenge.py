'''
YOUR GOAL is to add 2 Roman Numerals together
and return the sum in the same format (Roman Numerals).

If you don't know what Roman Numerals are see the link below:
-->(https://en.wikipedia.org/wiki/Roman_numerals)<--

For example:
I + I = II
V + I = VI
II + III = V

Hint: Use Helper Functions!

GOOD LUCK!
'''

nums = [1000,900,500,400,100,90,50,40,10,9,5,4,1]
symbols = ["M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
incorrect = 0

def testCase(val1, val2, result):
    global incorrect
    if addRomanNumerals(val1, val2) == result:
        print("PASSED TEST")
        return True
    else:
        print("--FAILED TEST")
        incorrect += 1
        return False

def main():
    falseFlag = True

    falseFlag = testCase("I","I","II")
    falseFlag = testCase("I","II","III")
    falseFlag = testCase("I","III","IV")
    falseFlag = testCase("V","V","X")
    falseFlag = testCase("V","IV","IX")
    falseFlag = testCase("CLXXIX","DCCCXXXII","MXI")
    falseFlag = testCase("CMXCIX","MCMXCIX","MMCMXCVIII")
    falseFlag = testCase("CDLXXXVII","MCCII","MDCLXXXIX")
    falseFlag = testCase("MDCCCLXXXVIII","MDCCCLXXXVIII","MMMDCCLXXVI")
    falseFlag = testCase("MCDXLIV","CDXLIV","MDCCCLXXXVIII")
    falseFlag = testCase("CXXV","CCCLXXV","D")
    falseFlag = testCase("CCCXXXIII","DCLXVII","M")
    falseFlag = testCase("CXL","X","CL")
    falseFlag = testCase("MXI","III","MXIV")
    falseFlag = testCase("MXI","II","MXIII")

    print("Incorrect cases: " + str(incorrect))
    if incorrect == 0:
        print("Proceed to next challenge")
    else:
        print("No good, try again.")


def addRomanNumerals(numeral1, numeral2):
    # --------------------
	# Your code goes here!
	# --------------------
    return ""

def numberToRomanNumeral(number):
    numeral = ""
    # --------------------
	# Your code goes here!
	# --------------------
    return numeral

def romanNumeralToNumber(numeral):
    number = 0
    # --------------------
	# Your code goes here!
	# --------------------
    return number

main()
