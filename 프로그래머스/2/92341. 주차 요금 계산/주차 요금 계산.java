import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalParkingTime = new HashMap<>();
        Map<String, String> inTimeMap = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];

            if (action.equals("IN")) {
                inTimeMap.put(carNumber, time);
            } else {
                String inTime = inTimeMap.remove(carNumber);
                int parkingDuration = calculateDuration(inTime, time, formatter);
                totalParkingTime.put(carNumber, totalParkingTime.getOrDefault(carNumber, 0) + parkingDuration);
            }
        }

        // 처리되지 않은 입차 기록을 23:59로 간주
        for (Map.Entry<String, String> entry : inTimeMap.entrySet()) {
            String carNumber = entry.getKey();
            String inTime = entry.getValue();
            int parkingDuration = calculateDuration(inTime, "23:59", formatter);
            totalParkingTime.put(carNumber, totalParkingTime.getOrDefault(carNumber, 0) + parkingDuration);
        }

        List<String> carNumbers = new ArrayList<>(totalParkingTime.keySet());
        Collections.sort(carNumbers);

        int[] result = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int parkingTime = totalParkingTime.get(carNumber);
            result[i] = calculateFee(parkingTime, fees);
        }

        return result;
    }

    private int calculateDuration(String inTime, String outTime, DateTimeFormatter formatter) {
        LocalTime in = LocalTime.parse(inTime, formatter);
        LocalTime out = LocalTime.parse(outTime, formatter);
        return (int) Duration.between(in, out).toMinutes();
    }

    private int calculateFee(int parkingTime, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (parkingTime <= basicTime) {
            return basicFee;
        } else {
            int extraTime = parkingTime - basicTime;
            int extraFee = (int) Math.ceil((double) extraTime / unitTime) * unitFee;
            return basicFee + extraFee;
        }
    }
}