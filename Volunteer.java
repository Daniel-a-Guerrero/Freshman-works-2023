//******************************************************************
// Volunteer.java Author: Lewis/Loftus
//
// Represents a staff member that works as a volunteer.
//******************************************************************
public class Volunteer extends StaffMember implements Payable
{
//---------------------------------------------------------------
// Sets up a volunteer using the specified information.
//---------------------------------------------------------------
public Volunteer (String eName, String eAddress, String ePhone)
{
super (eName, eAddress, ePhone);
}
//---------------------------------------------------------------
// Returns a zero pay value for this volunteer.
//---------------------------------------------------------------
public double pay()
{
return 0.0;
}
}