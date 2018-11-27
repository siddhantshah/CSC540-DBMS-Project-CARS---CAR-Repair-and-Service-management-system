package view;

import java.util.HashMap;

public class Appointment {
	public boolean canSchedule;
	public String errorReport;
	public double hoursReqd;
	public int assignedMechanicId;
	public String assignedMechanic;
	public String[] proposedDates = new String[2];
	public String[] proposedSlots=new String[2];
	public String assignedDate;
	public String licensePlate;
	public String diagnosticReport;
	public int diagnosticFee;
	public int customerId;
	public int maintenanceType;
	public int serviceId;
	public HashMap<Integer, Integer> partsRequired=new HashMap<Integer,Integer>();
}
