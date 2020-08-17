package CollegeAssignments.Java.Activity1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindTheWinner {

    private int numberOfTeams;
    private Map<String, Integer> teamsWithRank;
    private Map<Integer, ArrayList<String>> results = new TreeMap<>();

    public FindTheWinner(final int numberOfTeams,
                         final Map<String, Integer> teamsWithRank) {
        this.numberOfTeams = numberOfTeams;
        this.teamsWithRank = teamsWithRank;
    }

    private String getWinner(String team1, String team2) {
        int i = team1.compareTo(team2);
        if (i < 0) return team1;
        else if (i > 0) return team2;
        return team1;
    }

    public Map<Integer, ArrayList<String>> findTheWinnerOfTournament() {
        int temp = 1;
        String winner = "";
        int round = 1;
        ArrayList<String> teamsAvailableForCurrentRound = new ArrayList<>(teamsWithRank.keySet());

        while (temp < numberOfTeams) {
            System.out.println("Current round is: " + temp);
            ArrayList<String> winnerTeamsOfThisRound = new ArrayList<>();
            for (int i = 0; i < teamsAvailableForCurrentRound.size() - 1; i = i + 2) {
                String team1 = teamsAvailableForCurrentRound.get(i);
                String team2 = teamsAvailableForCurrentRound.get(i + 1);
                winner = getWinner(team1, team2);
                System.out.println("Winner of match between: " + team1 + " and " + team2 + " is: " + winner);
                winnerTeamsOfThisRound.add(winner);
            }
            results.put(round, winnerTeamsOfThisRound);
            teamsAvailableForCurrentRound = new ArrayList<>(winnerTeamsOfThisRound);
            round++;
            temp <<= 1;
        }
        return results;
    }
}

class TournamentUtilTest {
    public static void main(String[] args) {
        Map<String, Integer> teamsWithRank = new LinkedHashMap<>();
        constructTeam(teamsWithRank);

        FindTheWinner findTheWinner = new FindTheWinner(8, teamsWithRank);
        Map<Integer, ArrayList<String>> tournamentResults = findTheWinner.findTheWinnerOfTournament();

        System.out.println("================================SUMMARY====================================");
        for (Map.Entry<Integer, ArrayList<String>> entry : tournamentResults.entrySet()) {
            System.out.print("Winner of round: " + entry.getKey() + " are: ");
            entry.getValue().forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    private static void constructTeam(Map<String, Integer> teamsWithRank) {
        teamsWithRank.put("E", 1);
        teamsWithRank.put("B", 2);
        teamsWithRank.put("C", 3);
        teamsWithRank.put("A", 4);

        teamsWithRank.put("D", 5);
        teamsWithRank.put("F", 6);
        teamsWithRank.put("H", 7);
        teamsWithRank.put("G", 8);
    }
}
