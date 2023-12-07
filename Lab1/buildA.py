# ABuilder
# -*- coding: utf-8 -*-
from hash import hash

aIndex = [-1]*27000

def makeWord(line):
    word = ""
    i = 0
    if(line == ""):
        return ""
    #while i < len(line) and line[i].isalpha() and i < 3:
    while (line[i].isalpha() and i < 3):
        word += line[i]
        i += 1

    if(len(word) == 1):
        word = "  " + word
    elif(len(word) == 2):
        word = " " + word

    return word  # Rätt indentering här

with open("rawindex.txt", "r", encoding = "latin-1") as f:
    sameWord = False
    byteStart = 0
    line = f.readline()
    word = makeWord(line)

    while True:  # Förändrat från True för att hantera den sista raden korrekt
        if(word == ""):
            break
        if(sameWord == False):
            indexPos = hash(word)
            if(aIndex[indexPos] == -1):
                aIndex[indexPos] = byteStart
        byteStart += len(line)
        line = f.readline()
        newWord = makeWord(line)
        if(word == newWord):
            sameWord = True
        else:
            word = newWord
            sameWord = False

with open("A.txt", "w") as A:  # Ändrade "a" till "w" här
    for line in aIndex:
        A.write(str(line) + "\n")
