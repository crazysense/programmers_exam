package stack_queue;

import java.util.ArrayList;
import java.util.List;

public class TruckOnTheBridge {
    public static void main(String[] args) {
        TruckOnTheBridge sol = new TruckOnTheBridge();
        int len = 100;
        int weight = 100;
        int[] truckWeights = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(sol.solution(len, weight, truckWeights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTrucks = truck_weights.length;

        List<Truck> waitingTrucks = new ArrayList<>();
        for (int truck_weight : truck_weights) {
            Truck t = new Truck(truck_weight, bridge_length);
            waitingTrucks.add(t);
        }

        List<Truck> crossingTrucks = new ArrayList<>();
        List<Truck> crossedTrucks = new ArrayList<>();

        int durationTime = 0;
        int remainBridgeWeight = weight;

        while (crossedTrucks.size() < totalTrucks) {
            durationTime++;

            for (int i = crossingTrucks.size() - 1; i >= 0; i--) {
                crossingTrucks.get(i).setDistance(crossingTrucks.get(i).getDistance() - 1);
                if (crossingTrucks.get(i).getDistance() == 0) {
                    Truck ct = crossingTrucks.remove(i);
                    crossedTrucks.add(ct);
                    remainBridgeWeight += ct.getKg();
                }
            }

            if (waitingTrucks.size() > 0) {
                Truck t = waitingTrucks.get(0);
                if (remainBridgeWeight >= t.getKg()) {
                    waitingTrucks.remove(t);
                    crossingTrucks.add(t);
                    remainBridgeWeight -= t.getKg();
                }
            }
        }

        return durationTime;
    }

    class Truck {
        int kg;
        int distance;

        public Truck(int kg, int distance) {
            this.kg = kg;
            this.distance = distance;
        }

        public int getKg() {
            return kg;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
