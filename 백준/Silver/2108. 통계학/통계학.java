import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sum = 0;
    int min = 4001;
    int max = -4001;
    int n = sc.nextInt();
    int arr[] = new int[n];
    Map<Integer, Integer> modes = new HashMap<>(n); //최빈값을 찾기위해 입력값을 Map에 세팅
    int modenumber = 0;                             //최빈값이 사용된 횟수
    List<Integer> modecheck = new ArrayList<>();         //최빈값
    int mode = 0;
    for(int i = 0; i < n; i++) {    //최대값, 중앙값, 범위 구하기
      int num = sc.nextInt();
      sum += num;
      if (min > num) {
        min = num;
      }
      if (max < num) {
        max = num;
      }
      arr[i] = num;
    }
    for(int i = 0; i < n; i++){   //최빈값 구하기
      if(modes.containsKey(arr[i])){
        modes.put(arr[i], modes.get(arr[i])+1);
      }
      else {
        modes.put(arr[i], 1);
      }
      if(modenumber <= modes.get(arr[i])){
        modenumber = modes.get(arr[i]);     //최빈값은 총 몇번 호출되었는가
      }
    }
    for(int key : modes.keySet()){
      if(modes.get(key) == modenumber){
        modecheck.add(key);
      }
    }
    Collections.sort(modecheck);
    if(modecheck.size() == 1){
      mode = modecheck.get(0);
    }
    else{
      mode = modecheck.get(1);
    }
    Arrays.sort(arr);
    System.out.println(Math.round((double) sum/n));//최댓값
    System.out.println(arr[n/2]);//중앙값
    System.out.println(mode);//최빈값
    System.out.println(max - min);//범위
  }
}
