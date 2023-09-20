import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> songs = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            songs.put(genres[i], songs.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Map.Entry<String, Integer>> entryList = 
            new LinkedList<>(songs.entrySet());
        
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entryList){
            System.out.println(entry.getKey());
            int arr[] = {-1, -1};
            int firstMaxPlay = 0;
            int secondMaxPlay = 0;
            for(int i = 0; i < genres.length; i++){
                if(entry.getKey().equals(genres[i])){
                    if(plays[i] > firstMaxPlay){
                        secondMaxPlay = firstMaxPlay;
                        firstMaxPlay = plays[i];
                        arr[1] = arr[0];
                        arr[0] = i;
                    }
                    else if(plays[i] > secondMaxPlay){
                        secondMaxPlay = plays[i];
                        arr[1] = i;
                    }
                }
            }
            if(arr[0] != -1){
                list.add(arr[0]);
            }
            if(arr[1] != -1){
                list.add(arr[1]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}