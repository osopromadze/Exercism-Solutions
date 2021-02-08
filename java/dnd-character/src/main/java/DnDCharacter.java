import java.util.Arrays;

class DnDCharacter {
    private final int ability;
    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    public DnDCharacter() {

        ability = getSumOfThreeMaxElementsInArray();
        strength = getSumOfThreeMaxElementsInArray();
        dexterity = getSumOfThreeMaxElementsInArray();
        constitution = getSumOfThreeMaxElementsInArray();
        intelligence = getSumOfThreeMaxElementsInArray();
        wisdom = getSumOfThreeMaxElementsInArray();
        charisma = getSumOfThreeMaxElementsInArray();
    }

    int[] getSixRandomNumsArray() {
        int max = 6;
        int min = 1;
        int[] nums = new int[6];

        for(int i = 0; i < nums.length; i++) {
            int random = (int)(Math.random() * (max - min) + 1) + min;
            nums[i] = random;
        }

        return nums;
    }

    int getSumOfThreeMaxElementsInArray() {
        int[] randomNums = getSixRandomNumsArray();
        Arrays.sort(randomNums);

        int result = 0;

        for(int i = randomNums.length - 3; i < randomNums.length; i++) {
            result += randomNums[i];
        }

        return result;
    }

    int ability() {
        return ability;
    }

    int modifier(int input) {
        double num = ((double)input - 10) / 2;

        return (int) Math.floor(num);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(constitution);
    }

}
