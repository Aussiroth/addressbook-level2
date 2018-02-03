package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format BLOCK, STREET, UNIT, POSTAL CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private boolean isPrivate;

    private Block block;
    private Street street;
    private Unit unit;
    private Postal postal;
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] parsedAddress = address.split(",");
        if (parsedAddress.length != 4){
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        block = new Block(parsedAddress[0]);
        street = new Street(parsedAddress[1]);
        unit = new Unit(parsedAddress[2]);
        postal = new Postal(parsedAddress[3]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.toString() + ", " + street.toString() + ", " + unit.toString() + ", " + postal.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Address){
            //cheat a little since address are equal iff their string representation is equal
            return this.toString().equals(other.toString());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return block.hashCode() ^ street.hashCode() ^ unit.hashCode() ^ postal.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

class Block{
    public final String blockValue;

    public Block(String block){
        this.blockValue = block;
    }

    public String toString() {return blockValue;}

    public int hashCode() { return blockValue.hashCode();}
}

class Street{
    public final String streetValue;

    public Street(String street){
        this.streetValue = street;
    }

    public String toString() {return streetValue;}

    public int hashCode() { return streetValue.hashCode();}
}

class Unit{
    public final String unitValue;

    public Unit(String unit){
        this.unitValue = unit;
    }

    public String toString() {return unitValue;}

    public int hashCode() { return unitValue.hashCode();}
}

class Postal{
    public final String postalValue;

    public Postal(String postal){
        this.postalValue = postal;
    }

    public String toString() {return postalValue;}

    public int hashCode() { return postalValue.hashCode();}
}