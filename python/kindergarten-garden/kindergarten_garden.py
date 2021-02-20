class Garden:
    def __init__(self, diagram, students=None):
        self.diagram = diagram

        if students is not None:
            self.students = sorted(students)
        else:
            self.students = [
                "Alice",
                "Bob",
                "Charlie",
                "David",
                "Eve",
                "Fret",
                "Ginny",
                "Harriet",
                "Ileana",
                "Joseph",
                "Kincaid",
                "Larry",
            ]

        self.plant_map = {
            "G": "Grass",
            "V": "Violets",
            "C": "Clover",
            "R": "Radishes"
        }

    def plants(self, name):
        diagram_arr = self.diagram.split("\n")
        index = self.students.index(name) * 2

        letters = diagram_arr[0][index: index + 2] + diagram_arr[1][index: index + 2]

        return [self.plant_map[letter] for letter in letters]
