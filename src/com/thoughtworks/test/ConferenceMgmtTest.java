package com.thoughtworks.test;

import com.thoughtworks.ConferenceMgmt;
import com.thoughtworks.Utils;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit测试类
 */
public class ConferenceMgmtTest {

    /**
     * 对如下结果做测试：对input和output的数量测试，保证所有input的session都被安排了.
     *
     * Test input:
     * Writing Fast Tests Against Enterprise Rails 60min
     * Overdoing it in Python 45min
     * Lua for the Masses 30min
     * Ruby Errors from Mismatched Gem Versions 45min
     * Common Ruby Errors 45min
     * Rails for Python Developers lightning
     * Communicating Over Distance 60min
     * Accounting-Driven Development 45min
     * Woah 30min
     * Sit Down and Write 30min
     * Pair Programming vs Noise 45min
     * Rails Magic 60min
     * Ruby on Rails: Why We Should Move On 60min
     * Clojure Ate Scala (on my project) 45min
     * Programming in the Boondocks of Seattle 30min
     * Ruby vs. Clojure for Back-End Development 30min
     * Ruby on Rails Legacy App Maintenance 60min
     * A World Without HackerNews 30min
     * User Interface CSS in Rails Apps 30min
     */
    @Test
    public void testTotal() {
        String output = ConferenceMgmt.executeOutput();
        int inputLines = 19; //input行数统计
        int outputLines = Utils.countStr(output, "\r\n")
                - Utils.countStr(output, "Track")
                - Utils.countStr(output, "Lunch")
                - Utils.countStr(output, "Networking Event"); //output行数统计
        Assert.assertEquals(inputLines, outputLines);
    }

    /**
     * 对如下结果做测试：
     * The conference has multiple tracks each of which has a morning and afternoon session.
     */
    @Test
    public void testTrack() {
        String output = ConferenceMgmt.executeOutput();
        System.out.println(output);
        int i = Utils.countStr(output, "Track");
        Assert.assertEquals(2, i);
    }

    /**
     * 对如下结果做测试：
     * Morning sessions begin at 9am and must finish before 12 noon, for lunch.
     */
    @Test
    public void testLunch() {
        String output = ConferenceMgmt.executeOutput();
        int i = Utils.countStr(output, "Lunch");
        Assert.assertEquals(2, i);
    }

    /**
     * 对如下结果做测试：
     * The networking event can start no earlier than 4:00 and no later than 5:00.
     */
    @Test
    public void testNetworkingEvent() {
        String output = ConferenceMgmt.executeOutput();
        int i = Utils.countStr(output, "Networking Event");
        Assert.assertEquals(2, i);
    }

}
