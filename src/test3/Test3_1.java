package test3;

import java.util.Calendar;

public class Test3_1 {

	private int hour;
	
	private int minute;
	
	private int second;
	
	Calendar c = Calendar.getInstance();
	
	public Test3_1(){
		this.setPro();
	}
	
	public Test3_1(long time){
		c = Calendar.getInstance();
		c.setTimeInMillis(time);
		this.setPro();
	}
	
	public Test3_1(int hour, int minute, int second){
		c = Calendar.getInstance();
		c.set(Calendar.HOUR, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
		this.setPro();
	}
	
	public void setTime(long time){
		c = Calendar.getInstance();
		c.setTimeInMillis(time);
		this.setPro();
	}
	
	private void setPro(){
		hour = c.get(Calendar.HOUR);
		minute = c.get(Calendar.MINUTE);
		second = c.get(Calendar.SECOND);
	}
	

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return getHour()+"时"+getMinute()+"分"+getSecond()+"秒";
	}
	@Override
	public boolean equals(Object obj) {
		try {
			Test3_1 time=(Test3_1)obj;
			if (time.getHour()==hour&&time.getMinute()==minute&&time.getSecond()==second){
				return true;
			}else{
				return false;
			}
		}catch (ClassCastException e){
			return false;
		}
	}

	public static void main(String[] args) {
		Test3_1 t1 = new Test3_1();
		Test3_1 t2 = new Test3_1(555550000);

		System.out.println(t1.getHour()+":"+t1.getMinute()+":"+t1.getSecond());
		System.out.println(t2.getHour()+":"+t2.getMinute()+":"+t2.getSecond());
		System.out.println(t1.toString());
		System.out.println(t1.equals("hhhhhh"));
		System.out.println(t1.equals(t2));
		System.out.println(t1.equals(t1));
	}

}