package week05.FixtureList;

public class Main {
    public static void main(String[] args) {
        Fixture fixture = new Fixture();
        fixture.inputTeams();
        fixture.generateAllPossibleMatches();
        fixture.printTeams();
        fixture.createFirstHalf();
        fixture.createSecondHalf();
    }
}
