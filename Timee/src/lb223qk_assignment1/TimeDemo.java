package lb223qk_assignment1;

import java.util.Scanner;

public class TimeDemo {

	public static void main(String[] args) {

		double secondsInput;
		int hours = 0, minutes = 0;
		double seconds = 0;

		Time test = new Time(11, 59, 59.9);
		System.out.println(test);
		test.tick();
		System.out.println(test);
		test.tick();
		System.out.println(test);

		Scanner sc = new Scanner(System.in);
		Time timeA = new Time();

		// seconds passed by midnight
		secondsInput = sc.nextInt();
		timeA.seconds = secondsInput;
		System.out.println(timeA.toString());

		// clicking clock 10 times
		for (int i = 0; i < 10; i++) {
			timeA.tick();
			System.out.println(timeA.toString());
		}

		Time timeB = new Time(hours, minutes, seconds);

		// read from keyboard
		hours = sc.nextInt();
		timeB.setHours(hours);

		minutes = sc.nextInt();
		timeB.setMinutes(minutes);

		seconds = sc.nextDouble();
		timeB.setSeconds(seconds);

		// clicking clock 10 times
		for (int i = 0; i < 10; i++) {
			timeB.tick();
			timeB.toString();
			System.out.println(timeB);
		}

		// add time
		timeA = timeA.addTime(timeB);
		timeA.toString();
		System.out.println(timeA);

		// test the time difference
		Time timeD = new Time(5, 0, 0);
		Time timeE = new Time(23, 0, 0);

		// subtract time
		Time timeC = timeD.subtractTime(timeE);
		timeC.toString();
		System.out.println("Time difference is: " + timeC);

	}

}
