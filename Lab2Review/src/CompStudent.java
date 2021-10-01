import java.util.*;

public class CompStudent implements Comparator<Student>
{
    private static int i; 
    private int id; 
    private String firstName;
    private String lastName;
    private String program;
    private int owl;

    
    public CompStudent()
    {
        id = i++;
        firstName = "";
        lastName = "";
        program = "";
        owl = 0;
    }
    
    public int getID() { return id;}
    public void setFirstName( String fn) { firstName = fn;}
    public void setLastName( String ln) { lastName = ln;}
    public void setOWL( int g) { owl = g;}
    public String getFirstName( ) { return firstName;}
    public String getLastName( ) { return lastName;}
    public int getOWL( ) { return owl;}
    public void setProgram( String p) { program = p;}
    public String getProgram() { return program ;}
    
    @Override
    public int compare(Student s1, Student s2)
    {
    	int prog = s1.getProgram().compareTo(s2.getProgram());
    	int owl = s1.getOWL() - s2.getOWL();
    	int id = s1.getID() - s2.getID();
    	
    	if(prog == 0)
    	{
    		if(owl == 0)
    		{
    			return id;
    		}
    		else
    		{
    			return owl;
    		}
    	}
    	else
    	{
    		return prog;
    	}
    }
}