package com.thoughtworks;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Conference Track Management:
 * planning a big programming conference
 */
public class ConferenceMgmt {

    public static void main(String[] args) {
        System.out.println(executeOutput());
    }

    public static String executeOutput() {
        String result = "";
        boolean flag = true;
        while(flag){
            String s = getString(); //获取抽样的会议输出
            int i = Utils.countStr(s, "Networking Event");
            if(i == 1) { // 如果会议能在2个Track安排完则结束
                result = s.concat("05:00PM Networking Event");
                flag = false;
            }
        }
        return result;
    }

    /**
     * 根据输入获取抽样的会议输出，可能会被多次调用
     * @return 整理好的会议输出文本
     */
    private static String getString() {
        // Test input
        List<Session> sessions = new ArrayList<>();
        sessions.add(new Session("Writing Fast Tests Against Enterprise Rails", 60));
        sessions.add(new Session("Overdoing it in Python", 45));
        sessions.add(new Session("Lua for the Masses", 30));
        sessions.add(new Session("Ruby Errors from Mismatched Gem Versions", 45));
        sessions.add(new Session("Common Ruby Errors", 45));
        sessions.add(new Session("Rails for Python Developers", 5));
        sessions.add(new Session("Communicating Over Distance", 60));
        sessions.add(new Session("Accounting-Driven Development", 45));
        sessions.add(new Session("Woah", 30));
        sessions.add(new Session("Sit Down and Write", 30));
        sessions.add(new Session("Pair Programming vs Noise", 45));
        sessions.add(new Session("Rails Magic", 60));
        sessions.add(new Session("Ruby on Rails: Why We Should Move On", 60));
        sessions.add(new Session("Clojure Ate Scala (on my project)", 45));
        sessions.add(new Session("Programming in the Boondocks of Seattle", 30));
        sessions.add(new Session("Ruby vs. Clojure for Back-End Development", 30));
        sessions.add(new Session("Ruby on Rails Legacy App Maintenance", 60));
        sessions.add(new Session("A World Without HackerNews", 30));
        sessions.add(new Session("User Interface CSS in Rails Apps", 30));

        LocalTime beginTime = LocalTime.of(9, 00);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<100; i++){
            int index = (int) (Math.random() * sessions.size());
            Session random = sessions.get(index); // 先随机挑一个
            String name = random.getName();
            int timeDuration = random.getTimeDuration();
            LocalTime endTime = beginTime.plusMinutes(timeDuration); //下课时间

            if(beginTime.equals(LocalTime.of(9, 00))){
                int j = 1;
                if(i != 0) j = 2;
                sb.append("Track " + j +":\r\n");
            }
            if(endTime.isAfter(LocalTime.NOON) && endTime.isBefore(LocalTime.of(13, 01))){
                sb.append("12:00PM Lunch\r\n");
                beginTime = LocalTime.of(13, 00);
            } else if(endTime.isAfter(LocalTime.of(16, 59))){ // 至少要留1分钟做Networking Event
                sb.append("05:00PM Networking Event\r\n\r\n");
                beginTime = LocalTime.of(9, 00);
            } else {
                sb.append(beginTime.format(DateTimeFormatter.ofPattern("hh:mma")) + " " + name + " " + timeDuration + "min\r\n");
                beginTime = endTime; //时间轴后移
                sessions.remove(random);
            }
            if(sessions.isEmpty()) break;
        }
        return sb.toString().replace("上午", "AM").replace("下午", "PM").replace(" 5min", " lightning");
    }
}
