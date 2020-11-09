package CompaniesInterviewExperience.Walmart;

public class VisibleClothes {

    public static void main(String[] args) {
        int len = 10;
        int numOfClothes = 5;
        int[][] order = {
                {0, 4}, {6, 3}, {1, 5}, {6, 4}, {7, 2}
        };
        System.out.println(new VisibleClothes().getVisibleCount(len, numOfClothes, order));
    }

    private int getVisibleCount(int len, int numOfClothes, int[][] order) {

        int count = 0;

        for (int i = 0; i < numOfClothes; i++) {
            int currClothStart = order[i][0];
            int currClothEnd = order[i][0] + order[i][1];

            boolean found = false;
            for (int j = i + 1; j < numOfClothes; j++) {
                int newClothStart = order[j][0];
                int newClothEnd = order[j][0] + order[j][1];

                if (newClothStart <= currClothStart && newClothEnd >= currClothEnd) {
                    found = true;
                    break;
                }
            }
            if (!found) count++;
        }

        return count;
    }
}
