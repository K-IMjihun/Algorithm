import java.util.*;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        for (String skillTree : skill_trees) {
            if (isValidSkillTree(skill, skillTree)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValidSkillTree(String skill, String skillTree) {
        int skillIndex = 0;

        for (char c : skillTree.toCharArray()) {
            int indexInSkill = skill.indexOf(c);
            
            if (indexInSkill == -1) continue; // 선행 스킬 순서에 없을 경우
            
            if (indexInSkill == skillIndex) {
                skillIndex++; // 올바른 순서의 스킬을 배웠을 경우 다음 스킬로 이동
            } else {
                return false; // 잘못된 순서의 스킬을 배웠을 경우
            }
        }

        return true; // 모든 스킬을 올바른 순서로 배운 경우
    }
}