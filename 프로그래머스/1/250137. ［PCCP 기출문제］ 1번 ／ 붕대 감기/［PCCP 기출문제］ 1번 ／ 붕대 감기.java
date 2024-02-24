import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
int maxHP = health;
    int healTime = 0;
    int attacksMaxTime = attacks[attacks.length - 1][0];
    for (int i = 0; i <= attacksMaxTime; i++) {
      boolean attackCount = false;
      for (int j = 0; j < attacks.length; j++) {
        if (i == attacks[j][0]) {
          health -= attacks[j][1];
          healTime = 0;
          attackCount = true;
          break;
        }
      }
      if(health <= 0){
        health = -1;
        break;
      }
      if(!attackCount){
          healTime++;
          if (health < maxHP) {
            health += bandage[1];
            if (healTime == bandage[0]) {
              health += bandage[2];
              healTime = 0;
            }
            if (health > maxHP) {
              health = maxHP;
            }
          }
      }
    }
        return health;
  }
}