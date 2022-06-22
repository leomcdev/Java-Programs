package lb223qk_assignment1;

public class Time {

	int hours;
	int minutes;
	double seconds;
	int totalSeconds;
	double secs;

	// initialize time to 0:0:0
	Time() {
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;

	}

	Time(int hours, int minutes, double seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	Time(int seconds) {

		this.hours = seconds / 3600;
		this.minutes = ((int) seconds % 3600) / 60;
		this.seconds = seconds % 60;
	}

	public int getHours() {

		return hours;
	}

	public int getMinutes() {

		return minutes;
	}

	public double getSeconds() {

		return seconds;
	}

	public void setHours(int hours) {
		if (this.minutes >= 60.0) {
			this.minutes -= 60.0;
			this.hours += 1;
		}
		this.hours = hours;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;

		if (this.minutes >= 60.0) {
			this.minutes -= 60.0;
			this.hours += 1;
		}
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
		if (this.seconds >= 60.0) {
			this.seconds -= 60.0;
			this.minutes += 1;
		}
	}

	// convert to normal time in hours,minutes and seconds
	public void setClock(int seconds) {

		this.hours = seconds / 3600;
		this.minutes = ((int) seconds % 3600) / 60;
		this.seconds = seconds % 60;
	}

	// increments time stored in a time objects by 1 second
	public void tick() {
		if (this.seconds >= 59.9) {
			this.seconds -= 60.0;
			this.minutes += 1;

			if (this.minutes >= 59)
				this.minutes -= 60.0;
			this.hours += 1;
		}
		this.seconds++;
	}

	// decrements time stored in a time obj ect by 1 second
	public void tickDown() {

		if (this.seconds > 59.9) {
			this.seconds -= 60.0;
			this.minutes += 1;
		}
		if (this.minutes > 59) {
			this.minutes -= 60;
			this.hours += 1;
		}
		this.seconds--;
	}

	// return the sum of the two times as a time object
	public Time addTime(Time time) {
		Time sum = new Time();

		sum.hours = this.hours + time.hours;
		sum.minutes = this.minutes + time.minutes;
		sum.seconds = this.seconds + time.seconds;

		if (hours >= 60) {
			if (sum.seconds >= 59.9) {
				sum.seconds -= 60.0;
				sum.minutes += 1;
			}
			if (sum.minutes >= 59) {
				sum.minutes -= 60;
				sum.hours += 1;
			}
		}
		return sum;
	}

	// takes in Time parameter and returns the difference in time as a Time object
	public Time subtractTime(Time time) {

		Time timeDifference = new Time();

		if (time != timeDifference) {
			timeDifference.seconds = this.seconds - time.seconds;
			if (timeDifference.seconds >= 59.9) {
				timeDifference.seconds -= 60.0;
				timeDifference.minutes += 1;
			}
			timeDifference.minutes = this.minutes - time.minutes;
			if (timeDifference.minutes >= 60) {
				timeDifference.minutes -= 60;
				timeDifference.hours += 1;
			}
			timeDifference.hours = this.hours - time.hours;

			if (timeDifference.seconds < 0) {
				timeDifference.seconds = 60.0 + timeDifference.seconds;
				timeDifference.minutes -= 1;
			}
			if (timeDifference.minutes < 0) {
				timeDifference.minutes = 60 + timeDifference.minutes;
				timeDifference.hours -= 1;
			}
			if (timeDifference.hours < 0) {
				timeDifference.hours = 24 + timeDifference.hours;
			}

			timeDifference.hours = timeDifference.hours % 24;
		}
		return timeDifference;
	}

	// returns a string representation of the clock object in "hh:mm:ss" form.
	public String toString() {
		return String.format("%02d:%02d:%04.1f\n", this.hours, this.minutes, this.seconds);
	}
}
