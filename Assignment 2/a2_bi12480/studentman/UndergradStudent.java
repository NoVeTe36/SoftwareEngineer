package a2_bi12480.studentman;


import static java.lang.Math.pow;
import utils.*;

/**
 * @overview UndergradStudent is a student who has not been graduated
 * @attributes
 * id Integer
 * name String
 * phoneNumber String
 * address String
 * @object A typical UndergradStudent is <pre> <i, n, p, a> where id(i), name(n), phoneNumber(p), address(a) </pre>
 * where <pre> id(i), name(n), phoneNumber(p), address(a) </pre> are inherited from Student
 * @abstract_properties
 * mutable(id)=false /\ optional(id)=false /\ min(id)=pow(10, 5) /\ max(id)= pow(10, 9)
 * mutable(name)=true /\ optional(name)=false /\ length(name)= 50
 * mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)= 10
 * mutable(address)=true /\ optional(address)=false /\ length(address)= 100
 * @author NoVeTe36
 */

public class UndergradStudent extends Student {
    // constructor method
    public UndergradStudent(@AttrRef("id") int i, @AttrRef("name") String n, @AttrRef("phoneNumber") String p, @AttrRef("address") String a) throws NotPossibleException
    {
        super(i, n, p, a);
    }
    
    /**
     * @effects
     * if id is valid
     * return true
     * else
     * return false
     */
    @Override
    protected boolean validateId(int id)
    {
        if (id >= pow(10, 5) && id <= pow(10, 9))
            return true;
        else
            return false;
    }


    /**
     * @effects 
     * return UndergradStudent object
     */
    @Override
    public String toString(){
        return "UndergradStudent(" + getId() + ", " + getName() + ", " + getPhoneNumber() + ", " + getAddress() + ")";
    }

    /**
     * @effects
     * if name is valid
     *      return True
     * else 
     *      return false
     */
    @Override
    public String toHtmlDoc(){
        return "<html>\n" +
                "<head><title>Student: " + "</title></head>\n" 
                + "<body>\n" + getName() 
                + " " + getId() 
                + " " + getName() 
                + " " + getPhoneNumber() 
                + " " + getAddress() + "\n" +"</body></html>";
    }
}
