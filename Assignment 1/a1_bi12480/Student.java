package a1_bi12480;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;
import static java.lang.Math.*;


/**
 * @overview Student is a person who is studying in a school
 * @attributes
 * id Integer 
 * name String
 * phoneNumber String
 * address String
 * @object A typical Student is <i, n, p, a> where id(i), name(n), phoneNumber(p), address(a)
 * @abstract_properties
 * mutable(id)=false /\ optional(id)=false /\ min(id)=1 /\ max(id)= pow(10, 9)
 * mutable(name)=true /\ optional(name)=false /\ length(name)= 50
 * mutable(phoneNumber)=true /\ optional(phoneNumber)=false /\ length(phoneNumber)= 10
 * mutable(address)=true /\ optional(address)=false /\ length(address)= 100
 * @author NoVeTe36
 */

public class Student implements Comparable<Student> {
    private static final int LENGTH_NAME = 50;
    private static final int LENGTH_PHONE_NUMBER = 10;
    private static final int LENGTH_ADDRESS = 100;
    private static final int MIN_ID = 1;
    private static final int MAX_ID = (int) pow(10, 9);
    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1, max = 1000000000)
    private int id;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 50)
    private String name;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 10)
    private String phoneNumber;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 100)
    private String address;

    // methods

    /**
     * @effects
     * if i, n, p, a are valid
     * initialize this as <i, n, p, a>
     * else
     * throws NotPossibleException
     */
     
    public Student(@AttrRef("id") int i, @AttrRef("name") String n, @AttrRef("phoneNumber") String p, @AttrRef("address") String a) throws NotPossibleException {        
        if (!validateId(i)) {
            throw new NotPossibleException("Student.Student: invalid id");
        }

        if (!validateName(n)) {
            throw new NotPossibleException("Student.Student: invalid name");
        }

        if (!validatePhoneNumber(p)) {
            throw new NotPossibleException("Student.Student: invalid phone number");
        }

        if (!validateAddress(a)) {
            throw new NotPossibleException("Student.Student: invalid address");
        }

        id = i;
        name = n;
        phoneNumber = p;
        address = a;
    }

       /**
     * @effects
     * return id
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("id")
    public int getId() {
        return id;
    }

    /**
     * @effects
     * return name
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("name")
    public String getName() {
        return name;
    }

    /**
     * @effects
     * return phoneNumber
     */

    @DOpt(type = OptType.Observer)
    @AttrRef("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * @effects
     * return address
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("address")
    public String getAddress() {
        return address;
    }

    /**
     * @effects
     * if id is valid
     * return true
     * else
     * return false
     */
    protected boolean validateId(int id) {
        if (id >= MIN_ID && id <= MAX_ID) {
            return true;
        }
        return false;
    }

    /**
     * @effects
     * if name is valid
     * return true
     * else
     * return false
     */
    protected boolean validateName(String name) {
        if (name!= null && name.length() <= LENGTH_NAME) {
            return true;
        }
        return false;
    }

    /**
     * @effects
     * if phoneNumber is valid
     * return true
     * else
     * return false
     */
    protected boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() <= LENGTH_PHONE_NUMBER) {
            return true;
        }
        return false;
    }
    
    /**
     * @effects
     * if address is valid
     * return true
     * else
     * return false
     */
    protected boolean validateAddress(String address) {
        if (address != null && address.length() <= LENGTH_ADDRESS) {
            return true;
        }
        return false;
    }



    /**
     * @effects
     * if i is valid
     * id = i
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Mutator)
    public boolean setId(@AttrRef("id") int i) {
        if (validateId(i)) {
            id = i;
            return true;
        }
        return false;
    }

    /**
     * @effects
     * if n is valid
     * name = n
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Mutator)
    public boolean setName(@AttrRef("name") String n) {
        if (validateName(n)) {
            name = n;
            return true;
        }
        return false;
    }

    /**
     * @effects
     * if p is valid
     * phoneNumber = p
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Mutator)
    public boolean setPhoneNumber(@AttrRef("phoneNumber") String p) {
        if (validatePhoneNumber(p)) {
            phoneNumber = p;
            return true;
        }
        return false;
    }

    /**
     * @effects
     * if a is valid
     * address = a
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Mutator)
    public boolean setAddress(@AttrRef("address") String a) {
        if (validateAddress(a)) {
            address = a;
            return true;
        }
        return false;
    }

    /**
     * @effects
     * if this Student.name == other Student.name
     * return true
     * else
     * return false
     */
    @Override
    public int compareTo(Student other) {
        if (this.name.equals(other.name)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }
    
}