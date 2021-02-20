import re


def count_words(sentence):
    sentence = re.sub(r'[.!&@$%^]', "", sentence)
    sentence = re.sub(r'[,_\n:\t]', " ", sentence)
    sentence = re.sub(r'[ ]+', " ", sentence)
    sentence_arr = sentence.split(" ")
    sentence_arr = [word.strip() for word in sentence_arr]
    sentence_arr = [word.strip("'") for word in sentence_arr]
    sentence_arr = list(filter(lambda word: len(word) > 0, sentence_arr))
    sentence_arr = list(map(str.lower, sentence_arr))
    sentence_arr = sorted(sentence_arr)

    result = {}

    for index, word in enumerate(sentence_arr):
        count = result.get(word) if result.get(word) is not None else 0
        if word in sentence_arr[index:]:
            result.update({word: count + 1})

    return result
