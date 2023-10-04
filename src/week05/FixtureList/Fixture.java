package week05.FixtureList;

import java.util.*;

public class Fixture {
    List<String> teams = new ArrayList<>();
    List<List<int[]>> firstHalf = new ArrayList<>();
    List<List<int[]>> secondHalf = new ArrayList<>();
    List<int[]> allPossibleMatches = new LinkedList<>();
    List<int[]> backUp; // In case the shuffling of allPossibleMatches results in an unresolvable match ups of teams
    List<int[]> currentRound = new ArrayList<>();
    int numberOfRoundsInAHalf;

    public void inputTeams() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter names of teams (enter -1 to exit): ");

        while (true) {
            String team = input.nextLine();
            if (team.equals("-1")) {
                break;
            }
            teams.add(team);
        }

        if (teams.size() % 2 != 0) {
            teams.add("Filler");
        }

        this.numberOfRoundsInAHalf = calculateCombination(teams.size(), 2) / (teams.size() / 2);
    }

    public void generateAllPossibleMatches() { // Depending on the number of team names inputted, this method generates all possible match ups in the form of index combinations
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                int[] matchUp = new int[]{i, j};
                allPossibleMatches.add(matchUp);

                int[] reverseMatchUp = new int[]{j, i};
                allPossibleMatches.add(reverseMatchUp);
            }
        }
    }

    public void createFirstHalf() {
        int round = 0;
        int tries = 0; // Is in place so that the program does not enter an infinite loop

        Collections.shuffle(allPossibleMatches);
        backUp = new LinkedList<>(allPossibleMatches);

        while (round < numberOfRoundsInAHalf) {
            int[] matchUp = allPossibleMatches.remove(0); // The first index of the List contains an array with a match up
            tries++;
            int team1 = matchUp[0];
            int team2 = matchUp[1];

            if (!doesContain(team1, team2)) { // If it is not present in currentRound, then it is added
                tries = 0;
                currentRound.add(matchUp);
            } else { // It is returned to the end of the List for reconsideration
                allPossibleMatches.add(matchUp);
            }

            if (currentRound.size() == teams.size() / 2) { // The match ups in currentRound are added to firstHalf when there are enough of them
                firstHalf.add(new ArrayList<>(currentRound));
                currentRound.clear();
                round++;
            }

            if (tries == 20) { // Resets the entire program and lets it try again if the shuffled allPossibleMatches is impossible to resolve
                System.out.println("reset");
                currentRound.clear();
                firstHalf.clear();
                allPossibleMatches = new LinkedList<>(backUp);
                Collections.shuffle(allPossibleMatches);
                round = 0;
                tries = 0;
            }
        }
        System.out.println("First Half: ");
        printFixtures(firstHalf);
    }

    public void createSecondHalf() { // Creates the second half of the fixture by reversing firstHalf and the contents of its elements
        for (List<int[]> round : firstHalf) {
            List<int[]> mirroredRound = new ArrayList<>();
            for (int[] match : round) {
                mirroredRound.add(new int[]{match[1], match[0]});
            }
            secondHalf.add(mirroredRound);
        }

        System.out.println("Second Half: ");
        printFixtures(secondHalf);
    }

    public void printFixtures(List<List<int[]>> half) {
        for (List<int[]> round : half) {
            System.out.println("Round " + (half.indexOf(round) + 1) + "\n");
            for (int[] match : round) {
                System.out.print(teams.get(match[0]) + " vs " + teams.get(match[1]) + "\t");
            }
            System.out.println("\n");
        }
    }

    public void printTeams() {
        int lastIndexOfALine = 0;
        int increaseIndex = 2;
        for (String teamName : teams) {
            System.out.print(" - " + teamName);
            if (teams.indexOf(teamName) == lastIndexOfALine) {
                System.out.println();
                lastIndexOfALine += increaseIndex;
                increaseIndex++;
            }
        }
        System.out.println();
    }

    public boolean doesContain(int team1, int team2) { // Checks for duplicate teams in currentRound
        for (int i = 0; i < currentRound.size(); i++) {
            if(team1 == currentRound.get(i)[0] || team1 == currentRound.get(i)[1]) {
                return true;
            }
            if(team2 == currentRound.get(i)[0] || team2 == currentRound.get(i)[1]) {
                return true;
            }
        }
        return currentRound.contains(new int[]{team1, team2});
    }

    public int calculateCombination(int n, int r) { // Is used to calculate numberOfRoundsInAHalf
        return calculateFactorial(n) / (calculateFactorial(r) * calculateFactorial(n - r));
    }

    public int calculateFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
