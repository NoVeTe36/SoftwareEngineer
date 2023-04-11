package a1_bi12480;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;


/**
 * @overview PostgradStudent is a student who has been graduated
 * @attributes
 * id Integer
 * name String
 * phoneNumber String
 * address String
 * gpa Float
 * @object A typical PostgradStudent is <pre> <i, n, p, a, g> where id(i), name(n), phoneNumber(p), address(a), gpa(g) </pre>
 * where <pre> id(i), name(n), phoneNumber(p), address(a) </pre> are inherited from Student and gpa(g) is the GPA of the student
 * @abstract_properties
 * mutable(id)=false /\ optional(id)=false /\ min(id)=pow(10, 5) /\ max(id)= pow(10, 9)
 * mutable(name)=true /\ optional(name)=false /\ length(name)= 50
 * mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)= 10
 * mutable(address)=true /\ optional(address)=false /\ length(address)= 100
 * mutable(gpa)=true /\ optional(gpa)=false /\ min(gpa)=0.0 /\ max(gpa)=4.0
 * @author NoVeTe36
 */

public class PostgradStudent extends Student {
    @DomainConstraint(type = "Float", mutable = true, optional = false, min = 0.0, max = 4.0)
    private float gpa;

    // constructor
    public PostgradStudent(@AttrRef("id") int i, @AttrRef("name") String n, @AttrRef("phoneNumber") String p, @AttrRef("address") String a, @AttrRef("gpa") float g) throws NotPossibleException
    {
        super(i, n, p, a);
        if(!validateGpa(g)){
            throw new NotPossibleException("PostgradStudent.init: invalid gpa: " + g);
        }
        this.gpa = g;
    }

    // methods
    /**
     * @effects <pre>
     * if g is valid
     * set this.gpa = g
     * return true
     * else
     * return false </pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("gpa")
    public boolean setGpa(float g) {
        if (!validateGpa(g)) {
            return false;
        }
        this.gpa = g;
        return true;
    }

    /**
     * @effects return <tt>this.gpa</tt>
     */

    @DOpt(type = OptType.Observer)
    @AttrRef("gpa")
    public float getGpa() {
        return this.gpa;
    }        

    /**
     * @effects <pre>
     * if g is valid
     * return true
     * else
     * return false </pre>
     */
    @DOpt(type = OptType.Mutator) @AttrRef("gpa")
    private boolean validateGpa(float g) {
        return g >= 0.0 && g <= 4.0;
    }
}
