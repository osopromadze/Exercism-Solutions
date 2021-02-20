def abbreviate(words):
    words = words.replace("-", " ")
    words = words.replace("_", "")
    words_arr = words.split(" ")
    words_arr = list(filter(lambda word: len(word) > 0, words_arr))

    return ''.join([word[0].upper() for word in words_arr])
