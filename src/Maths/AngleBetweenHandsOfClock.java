package Maths;
//1344. Angle Between Hands of a Clock
/*
Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
Answers within 10-5 of the actual value will be accepted as correct.
 */
public class AngleBetweenHandsOfClock {
    public static double angleClock(int hour, int minutes) {
        double first = hour*30+ minutes*0.5;
        double second = minutes*6;
        double res = Math.abs(second-first);
        return res>180?360-res:res;
    }

    public static void main(String[] args) {
        int hour=12;
        int minutes=45;
        System.out.println("Acute angle between the hands is: "+angleClock(hour,minutes));
    }
}
