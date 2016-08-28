import org.joda.time.DateTime;

public class Meetup {

	private int month;
	private int year;

	public Meetup(int month, int year) {
		this.month = month;
		this.year = year;
	}

	private int getReferenceDay(MeetupSchedule weekName) {
		if (weekName == MeetupSchedule.LAST) {
			DateTime referenceDate;
			if (month == 12) {
				referenceDate = new DateTime(year + 1, 1, 1, 0, 0);  
			} else {
				referenceDate = new DateTime(year, month + 1, 1, 0, 0);
			}
			return referenceDate.minusDays(1).dayOfMonth().get();
		} else if (weekName == MeetupSchedule.TEENTH) {
			return 13;
		} else {
			return 1;
		}
	}
	
	private int getSearchDirection (MeetupSchedule weekName) {
		if (weekName == MeetupSchedule.LAST) {
			return -1;
		} else {
			return +1;
		}
	}

	public DateTime day(int dayNameInt, MeetupSchedule weekName) {
		int referenceDay = getReferenceDay(weekName);
		int searchDirection = getSearchDirection(weekName);;
		DateTime checkDate = new DateTime(year, month, referenceDay, 0, 0);
		while (checkDate.dayOfWeek().get() != dayNameInt) {
			referenceDay += searchDirection;
			checkDate = new DateTime(year, month, referenceDay, 0, 0);
		}
		switch (weekName) {
		case FIRST:
			return new DateTime(year, month, referenceDay, 0, 0);
		case SECOND:
			return new DateTime(year, month, referenceDay + 7, 0, 0);
		case THIRD:
			return new DateTime(year, month, referenceDay + 14, 0, 0);
		case FOURTH:
			return new DateTime(year, month, referenceDay + 21, 0, 0);
		case LAST:
			return new DateTime(year, month, referenceDay, 0, 0);
		case TEENTH:
			return new DateTime(year, month, referenceDay, 0, 0);
		default:
			throw new AssertionError();
		}
	}

}
