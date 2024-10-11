package seedu.address.model.person.insurance.claim;

import seedu.address.logic.parser.exceptions.ParseException;

/**
 * An object that represents a claim that the client has made under an insurance plan.
 */
public class Claim {
    public static final String INVALID_CLAIM_ID = "Invalid Claim ID, must follow: "
            + "Letter + 4 digits only.";

    public static final String NEGATIVE_CLAIM_AMOUNT = "Claim Amount cannot be negative";
    public static final String INVALID_CLAIM_AMOUNT = "Claim Amount must be a positive integer";

    private final String claimId;
    private final boolean claimStatus;
    private final int claimAmount;

    /**
     * Constructs a claim object based on the input parameters.
     *
     * @param claimId     claim id obtained through official channels.
     * @param claimStatus current status of the claim, only takes a boolean value.
     * @param claimAmount claim amount recorded in cents, can only be a positive integer.
     */
    public Claim(String claimId, boolean claimStatus, int claimAmount) {
        this.claimId = claimId;
        this.claimStatus = claimStatus;
        this.claimAmount = claimAmount;
    }

    /**
     * Returns the {@code claimId} of this claim object.
     */
    public String getClaimId() {
        return this.claimId;
    }

    /**
     * Returns the {@code claimStatus} of this claim object.
     */
    public boolean getClaimStatus() {
        return this.claimStatus;
    }

    /**
     * Returns the {@code claimAmount} of this claim object.
     */
    public int getClaimAmount() {
        return this.claimAmount;
    }

    /**
     * Checks if the claim id is valid based on preset notations.
     * Regular expression pattern:
     * ^ - start of the string
     * [A-Za-z] - any uppercase or lowercase letter
     * \d{4} - exactly 4 digits
     * $ - end of the string
     * This method was created with the aid of ChatGPT.
     *
     * @param claimId the claimId string to be checked for validity.
     * @throws ParseException if the claimId is invalid.
     */
    public static void checkValidClaimId(String claimId) throws ParseException {
        String pattern = "^[A-Za-z]\\d{4}$";
        if (!claimId.matches(pattern)) {
            throw new ParseException(INVALID_CLAIM_ID);
        }
    }

    /**
     * Checks if the value of the claim amount is non-negative.
     */
    public static void checkValidClaimAmount(int claimAmount) throws ParseException {
        if (claimAmount < 0) {
            throw new ParseException(Claim.NEGATIVE_CLAIM_AMOUNT);
        }
    }
}
