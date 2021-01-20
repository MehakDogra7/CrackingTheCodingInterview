package Question450.StacksAndQueues;

public class CircularTour {

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(new CircularTour().tour(petrol, distance));
    }

    int tour(int[] petrol, int[] distance) {
        // Your code here
        int totalPetrol = 0, totalDistance = 0, n = petrol.length;
        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
        }

        if (totalDistance > totalPetrol) return -1;

        int start = 0, end = 0, availablePetrol = 0;
        while (end < n) {
            availablePetrol += petrol[end] - distance[end];
            if (availablePetrol < 0) {
                start = end + 1;
                availablePetrol = 0;
            }
            end++;
        }
        return start;
    }
}
