#konkordans
from hash import hash
import math
import sys

aIndex = []
with open("A.txt", "r", encoding = "latin-1") as A:
    while(True):
        nextVar = A.readline()
        if(nextVar == ""):
            break
        aIndex.append(nextVar)


def findAmount(lower, userInput):
    if lower is None:
        return 0
    count = 0
    with open("rawindex.txt", "r", encoding = "latin-1") as I:
        I.seek(lower)
        lineWord = I.readline().split()
        while lineWord and lineWord[0] == userInput:
            lineWord = I.readline().split()
            count += 1
            if not lineWord:
                break
    return count


def searchAlg(userInput, aIndex, rawindex_size):
    posA = hash(userInput) % len(aIndex)  # Ändra här för att använda hash-funktionen korrekt
    posI = aIndex[posA]
    if posI == "-1":
        return None  # Ord finns inte i indexet.
    posI = int(posI)  # Konvertera till heltal

    if posA == len(aIndex) - 1:
        posINext = rawindex_size
    else:
        i = 1
        while (posA + i < len(aIndex)) and (aIndex[posA + i] == "-1"):
            i += 1
        posINext = int(aIndex[posA + i]) if (posA + i < len(aIndex)) else rawindex_size

    with open("rawindex.txt", "r", encoding="latin-1") as I:
        lower = posI
        higher = posINext
        while higher - lower > 1000:
            mid = (lower + higher) // 2
            I.seek(mid)
            I.readline()  # Skip till the start of next line
            mid_start = I.tell()
            lineList = I.readline().split()
            if not lineList or lineList[0] < userInput:
                lower = mid_start
            else:
                higher = mid

        I.seek(lower)
        while lower < higher:
            current_pos = I.tell()
            lineList = I.readline().split()
            if not lineList:
                break
            if lineList[0] == userInput:
                return current_pos
            elif lineList[0] > userInput:
                break

        return None


def addchars(lineList, korpus_path):

    with open(korpus_path, "r", encoding="latin-1") as L:
        for item in lineList:
            position = int(item[1])
            word = item[0]
            buffer_size = 30  # Antal tecken att läsa före och efter ordet

            start_position = max(position - buffer_size, 0)
            L.seek(start_position)

            read_length = min(buffer_size * 2 + len(word), position + buffer_size + len(word) - start_position)

            surrounding_text = L.read(read_length)

            pre_context_index = buffer_size if position > buffer_size else position - start_position
            post_context_index = pre_context_index + len(word)

            pre_context = surrounding_text[:pre_context_index].replace('\n', ' ')
            match_word = surrounding_text[pre_context_index:post_context_index]
            post_context = surrounding_text[post_context_index:].replace('\n', ' ')

            result_line = f"{pre_context}{match_word.upper()}{post_context}"
            print(result_line)

alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w','x', 'y', 'z', 'å', 'ä', 'ö']
if(len(sys.argv) > 1):
    userInput = sys.argv[1].lower()
else:
    print("Your word is not valid, try again: ")
    userInput = input().lower()
    if(userInput == ""):
        sys.exit()
validWord = False
while (validWord == False):
    validChar = True
    for letter in userInput:
        if(letter not in alphabet):
            validChar = False
    if(validChar == True):
        validWord = True
    else:
        print("Your word is not valid, try again!")
        userInput = input().lower()
        if(userInput == ""):
            sys.exit()

def printWords(lower, amount):
    with open("rawindex.txt", "r", encoding = "latin-1") as I:
        I.seek(lower)
        count = 0
        while(True):
            if(count == 25 and amount > 25):
                #et= time.time()
                print("Det finns fler förekomster att visa, vill du se dem? Yes/ No")
                userI = input().lower()
                if(userI != "yes"):
                    break
            lineWord = I.readline()
            if(lineWord == ""):
                break
            lineWord = lineWord.split()
            if(lineWord[0] == userInput):
                addchars([lineWord])
                count += 1
            else:
                break

lower = searchAlg(userInput)
amount = findAmount(lower, userInput)

if(amount == 0):
    print("Not found")
else:
    print("Det finns " + str(amount) + " förkomster av ordet.")
    printWords(lower, amount)
