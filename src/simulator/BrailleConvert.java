package simulator;

/**
 * Enum that maps characters to braille.
 * Simulator gets the pin states boolean array for any letter by calling
 * BrailleConvert.CHAR_HERE.getPinStates(); where 'CHAR_HERE' is the character
 * that needs to be converted.
 *
 * USED INTERNALLY BY SIMULATOR, public for testing purposes.
 * @author Team 6, EECS 2031
 */
public enum BrailleConvert {

    A(new boolean[] {true, false, false, false, false, false, false, false}),
    B(new boolean[] {true, true, false, false, false, false, false, false}),
    C(new boolean[] {true, false, false, false, true, false, false, false}),
    D(new boolean[] {true, false, false, false, true, true, false, false}),
    E(new boolean[] {true, false, false, false, false, true, false, false}),
    F(new boolean[] {true, true, false, false, true, false, false, false}),
    G(new boolean[] {true, true, false, false, true, true, false, false}),
    H(new boolean[] {true, true, false, false, false, true, false, false}),
    I(new boolean[] {false, true, false, false, true, false, false, false}),
    J(new boolean[] {false, true, false, false, true, true, false, false}),

    K(new boolean[] {true, false, true, false, false, false, false, false}),
    L(new boolean[] {true, true, true, false, false, false, false, false}),
    M(new boolean[] {true, false, true, false, true, false, false, false}),
    N(new boolean[] {true, false, true, false, true, true, false, false}),
    O(new boolean[] {true, false, true, false, false, true, false, false}),
    P(new boolean[] {true, true, true, false, true, false, false, false}),
    Q(new boolean[] {true, true, true, false, true, true, false, false}),
    R(new boolean[] {true, true, true, false, false, true, false, false}),
    S(new boolean[] {false, true, true, false, true, false, false, false}),
    T(new boolean[] {false, true, true, false, true, true, false, false}),

    U(new boolean[] {true, false, true, false, false, false, true, false}),
    V(new boolean[] {true, true, true, false, false, false, true, false}),
    W(new boolean[] {false, true, false, false, true, true, true, false}),
    X(new boolean[] {true, false, true, false, true, false, true, false}),
    Y(new boolean[] {true, false, true, false, true, true, true, false}),
    Z(new boolean[] {true, false, true, false, true, true, false, false}),

    RESET(new boolean[] {false, false, false, false, false, false, false, false});

    private boolean[] pinStates;

    /**
     * Constructor of enum that takes a boolean array of
     * pin states as a parameter.
     * @param pinStates Boolean array containing pin states.
     */
    BrailleConvert(boolean[] pinStates) {
        this.pinStates = pinStates;
    }

    /**
     * Returns the boolean array containing the
     * pin states.
     * @return Boolean array containing pin states.
     */
    public boolean[] getPinStates() {
        return pinStates;
    }
}
