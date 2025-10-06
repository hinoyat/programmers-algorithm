import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> phoneSet = new HashSet<>();
        
        for (String p : phone_book) {
            phoneSet.add(p);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (phoneSet.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}