class Solution {
    public int solution(int[] bandage, int maxHealth, int[][] attacks) {
        int castTime = bandage[0];
        int healPerSecond = bandage[1];
        int bonusHeal = bandage[2];
        
        int attackIndex = 0;
        int currentTime = 0;
        int consecutiveHeal = 0;
        int currentHealth = maxHealth;
        boolean survived = true;
        
        while (true) {
            if (attackIndex >= attacks.length) break;
            
            if (currentTime == attacks[attackIndex][0]) {
                currentHealth -= attacks[attackIndex][1];
                consecutiveHeal = 0;
                if (currentHealth <= 0) {
                    survived = false;
                    break;
                }
                attackIndex++;
            } else {
                currentHealth += healPerSecond;
                consecutiveHeal++;
                
                if (consecutiveHeal == castTime) {
                    currentHealth += bonusHeal;
                    consecutiveHeal = 0;
                }
                currentHealth = (currentHealth > maxHealth) ? maxHealth : currentHealth;
            }
            currentTime++;
        }
        
        if (!survived) return -1;
        return currentHealth;
    }
}
