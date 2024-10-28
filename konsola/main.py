#!/bin/python
WAGES = [1, 3, 7, 9, 1, 3, 7, 9, 1, 3]

# Fun
def sex(pesel: str) -> chr:
    num = int(pesel[9])
    if num % 2 == 0:
        return 'K'
    return 'M' 

# **********************************************
# nazwa funkcji: isValid
# opis funkcji: Sprawdza zgodność sumy kontrolnej podanego numeru PESEL
# parametry: pesel (string) - numer PESEL do sprawdzenia
# zwracany typ i opis: (bool) - zwraca True w przypadku zgodnej sumy kontrolnej oraz False, kiedy suma kontrolna się nie zgadza
# autor: XYZ
# ***********************************************
def isValid(pesel: str) -> bool:
    s = 0
    for i in range(10):
        s += int(pesel[i]) * WAGES[i]
    m = s % 10
    r = 0
    if m != 0:
        r = 10 - m
    return r == int(pesel[10])

# Start
pesel = "55030101193"
while True:
    inp = input("PESEL: ")
    if inp == "":
        break
    try:
        int(inp)
        if len(inp) != 11:
            raise Exception()
    except:
        print("Podano nieprawidłową wartość")
        continue
    pesel = inp 
    break
# ---
print(f"Wczytany PESEL: {pesel}")
# ---
if sex(pesel) == 'K':
    print("Kobieta")
else:
    print("Mężczyzna")
# ---
if isValid(pesel):
    print("Zgodna suma kontrolna")
else: 
    print("Niezgodna suma kontrolna")