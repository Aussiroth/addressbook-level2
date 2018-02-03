package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "Block 1, Computing Drive, 01-01, 313131";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format BLOCK, STREET, UNIT, POSTAL CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public static final String ADDRESS_SPLIT_REGEX = ",";

    public static final int ADDRESS_BLOCK_INDEX = 0;
    public static final int ADDRESS_STREET_INDEX = 1;
    public static final int ADDRESS_UNIT_INDEX = 2;
    public static final int ADDRESS_POSTAL_INDEX = 3;

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
        String[] parsedAddress = address.split(ADDRESS_SPLIT_REGEX);
        if (parsedAddress.length != 4) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        block = new Block(parsedAddress[ADDRESS_BLOCK_INDEX]);
        street = new Street(parsedAddress[ADDRESS_STREET_INDEX]);
        unit = new Unit(parsedAddress[ADDRESS_UNIT_INDEX]);
        postal = new Postal(parsedAddress[ADDRESS_POSTAL_INDEX]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", block.toString(), street.toString(), unit.toString(), postal.toString());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).block)
                && this.street.equals(((Address) other).street)
                && this.unit.equals(((Address) other).unit)
                && this.postal.equals(((Address) other).postal)); // state check
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
        this.blockValue = block.trim();
    }

    @Override
    public String toString() {return blockValue;}

    @Override
    public int hashCode() { return blockValue.hashCode();}

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Block
                && this.blockValue.equals(((Block) other).blockValue));
    }
}

class Street{
    public final String streetValue;

    public Street(String street){
        this.streetValue = street.trim();
    }

    @Override
    public String toString() {return streetValue;}

    @Override
    public int hashCode() { return streetValue.hashCode();}

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Street
                && this.streetValue.equals(((Street) other).streetValue));
    }
}

class Unit{
    public final String unitValue;

    public Unit(String unit){
        this.unitValue = unit.trim();
    }

    @Override
    public String toString() {return unitValue;}

    @Override
    public int hashCode() { return unitValue.hashCode();}

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Unit
                && this.unitValue.equals(((Unit) other).unitValue));
    }
}

class Postal{
    public final String postalValue;

    public Postal(String postal){
        this.postalValue = postal.trim();
    }

    @Override
    public String toString() {return postalValue;}

    @Override
    public int hashCode() { return postalValue.hashCode();}

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Postal
                && this.postalValue.equals(((Postal) other).postalValue));
    }
}