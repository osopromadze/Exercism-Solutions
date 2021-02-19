class Matrix:
    matrix_string = ""

    def __init__(self, matrix_string):
        self.matrix_string = matrix_string

    def row(self, index):
        matrix_row = self.matrix_string.split("\n")[index - 1]
        result = []
        for num in matrix_row.split(" "):
            result.append(int(num))
        return result

    def column(self, index):
        result = []
        for row in self.matrix_string.split("\n"):
            for idx, val in enumerate(row.split(" "), start=1):
                if idx == index:
                    result.append(int(val))

        return result
