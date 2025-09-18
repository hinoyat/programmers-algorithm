class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int videoLen = toSeconds(video_len);
        
        int opStart = toSeconds(op_start);
        
        int opEnd = toSeconds(op_end);
        
        int curTime = toSeconds(pos);
        
        if (opStart <= curTime && curTime <= opEnd) {
            curTime = opEnd;
        }
        
        for (int i = 0; i < commands.length; i ++) {
            
            if (commands[i].equals("next")) {
                curTime += 10;
            } else {
                curTime -= 10;
            }
            
            if (curTime < 0) curTime = 0;
            if (curTime > videoLen) curTime = videoLen;
            if (opStart <= curTime && curTime <= opEnd) {
                curTime = opEnd;
            }
        }
        
        answer = toString(curTime);
        

        return answer;
    }
    
    static int toSeconds(String time) {
        String[] t = time.split(":");
        
        int minutes = Integer.parseInt(t[0]);
        int seconds = Integer.parseInt(t[1]);
        
        return minutes * 60 + seconds;
    }
    
    static String toString(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}