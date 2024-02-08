import java.util.*;

class Truck {
    int weight;
    int position;

    public Truck(int weight, int position) {
        this.weight = weight;
        this.position = position;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentPosition = 0;
        Queue<Truck> onBridge = new LinkedList<>();
        Queue<Truck> waiting = new LinkedList<>();

        for (int w : truck_weights) {
            waiting.add(new Truck(w, 0));
        }

        while (!onBridge.isEmpty() || !waiting.isEmpty()) {
            answer++;

            if (!onBridge.isEmpty()) {
                Truck t = onBridge.peek();
                if (answer - t.position >= bridge_length) {
                    onBridge.poll();
                    currentPosition -= t.weight;
                }
            }

            if (!waiting.isEmpty()) {
                if (currentPosition + waiting.peek().weight <= weight) {
                    Truck t = waiting.poll();
                    t.position = answer;
                    onBridge.add(t);
                    currentPosition += t.weight;
                }
            }
        }

        return answer;
    }
}