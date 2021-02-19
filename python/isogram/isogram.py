def is_isogram(string):
    string = string.replace(" ", "")\
        .replace("-", "")\
        .lower()
    string = ''.join(sorted(string))

    for index, value in enumerate(string):
        if value in string[index + 1:]:
            return False
    return True
