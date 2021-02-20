def score(word):
    letter_values = {}

    for letter in "A", "E", "I", "O", "U", "L", "N", "R", "S", "T":
        letter_values.update({letter: 1})

    for letter in "D", "G":
        letter_values.update({letter: 2})

    for letter in "B", "C", "M", "P":
        letter_values.update({letter: 3})

    for letter in "F", "H", "V", "W", "Y":
        letter_values.update({letter: 4})

    letter_values.update({"K": 5})

    for letter in "J", "X":
        letter_values.update({letter: 8})

    for letter in "Q", "Z":
        letter_values.update({letter: 10})

    return sum(letter_values.get(letter.upper()) for letter in word)
