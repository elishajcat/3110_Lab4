/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.*;

public class Prof {
	private String name;
	private Date midtermDate;
	private List<ProfListener> profListeners;

	public Prof(String aName) {
		this.name = aName;
		this.profListeners = new ArrayList<>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date, Prof prof) {
		this.midtermDate = date;
		ProfEvent e = new ProfEvent(date, prof);
		for(ProfListener s: this.profListeners){
			s.handleMidtermDate(e);
		}
	}

	public void postponeMidterm(Date date, Prof prof){
		this.midtermDate = date;
		ProfEvent e = new ProfEvent(date, prof);
		for(ProfListener s: this.profListeners){
			s.handlePostponedMidterm(e);
		}
	}
	
	public void addProfListener(ProfListener mh){
		this.profListeners.add(mh);
	}

	public void removeProfListener(ProfListener mh){
		this.profListeners.remove(mh);
	}

	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		p.addProfListener(s);
		p.addProfListener(s2);
		p.addProfListener(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm, p);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000), p);
	}

}
