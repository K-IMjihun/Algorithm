import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int getNumber[] = new int[sc.nextInt()];
    int needNumber = sc.nextInt();
    long max = 0;
    for(int i = 0; i < getNumber.length; i++){
      getNumber[i] = sc.nextInt();
      if(max < getNumber[i]){
        max = getNumber[i];
      }
    }
    max++;

    long min = 0;
    long mid = 0;
    while(min < max){
      mid = (max + min) / 2;
      long count = 0;
      for(int i = 0; i < getNumber.length; i++){
        count += (getNumber[i] / mid);
      }
      if(count < needNumber){
        max = mid;
      }
      else{
        min = mid + 1;
      }
    }
    System.out.println(min - 1);
  }
}
