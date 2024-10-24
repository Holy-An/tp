package exceptions;

public class SEPIOException extends SEPException {
    public SEPIOException(String message) {
        super(message);
    }

    // Exception for missing "students" node or invalid array
    public static SEPIOException missingStudentsJSONArray() {
        return new SEPIOException("Invalid JSON format! The 'students' array is missing or not an array.");
    }

    // Exception for missing required fields in the student entry
    public static SEPIOException missingRequiredJSONFields() {
        return new SEPIOException("Invalid JSON format! Each student entry must contain 'ID', 'GPA', " +
                "and 'PREFERENCES'.");
    }

    // Exception for invalid data format after checking the values
    public static SEPIOException invalidDataJSONFormat() {
        return new SEPIOException("Invalid data! One or more fields contain invalid data. Please check ID, GPA, " +
                "and PREFERENCES.");
    }

    
    /**
     * Exception for wrong CSV format. The first row must contain the header "ID", "GPA", and "PREFERENCES".
     * Subsequent rows must contain the data separated by a comma. For example, "A1234567J, 4.5, \"{1,2,3}\""
     * 
     * @return A SEPIOException with a message indicating the wrong CSV format.
     */
    public static SEPIOException rejectCSVFile() {
        return new SEPIOException("Wrong CSV format! Please ensure first row is ID, GPA, PREFERENCES" +
                " and subsequent rows to be <ID>, <GPA>, \"<PREFERENCES>\"\nALL SEPARATED BY A COMMA! " +
                "For e.g. A1234567J, 4.5, \"{1,2,3}\"");
    }

    /**
     * Exception for incorrect CSV data format. This method constructs an error message
     * indicating that the provided line is not in the correct format. Each element in
     * the line should be separated by a comma.
     *
     * @param line The CSV line that is not in the correct format.
     * @return A SEPIOException with a message indicating the incorrect CSV data format.
     */
    public static SEPIOException rejectCSVDataFormat(String[] line) {
        return new SEPIOException(String.join(",", line) + "\" is not in correct format! " +
                "Please ensure that they are separated by a comma.");
    }

    /**
     * Exception for missing required fields in the student entry in the TXT file.
     * Each line must contain 'id/[ID]', 'gpa/[GPA]', and 'p/[PREFERENCES]'.
     * 
     * @return A SEPIOException with a message indicating the missing required fields.
     */
    public static SEPIOException missingTXTRequiredFields() {
        return new SEPIOException("Invalid TXT format! Each line must contain 'id/<ID>', 'gpa/<GPA>', " +
                "and 'p/<PREFERENCES>'.");
    }

    /**
     * Exception for invalid data in the student entry in the TXT file. This method
     * constructs an error message indicating that one or more fields contain invalid
     * data. The user is asked to check the ID, GPA, and PREFERENCES.
     * 
     * @return A SEPIOException with a message indicating the invalid data in the TXT file.
     */
    public static SEPIOException invalidTXTDataFormat() {
        return new SEPIOException("Invalid data in TXT file! One or more fields contain invalid data. " +
                "Please check ID, GPA, and PREFERENCES.");
    }

    /**
     * Exception for wrong TXT file format. This method constructs an error message
     * indicating that each row must be written as "id/[ID] gpa/[GPA] p/[PREFERENCES]".
     * The user is given an example of the correct format.
     * 
     * @return A SEPIOException with a message indicating the wrong TXT file format.
     */
    public static SEPIOException rejectTXTFile() {
        return new SEPIOException("Wrong TXT format! Please ensure each row is written as " +
                "id/<ID> gpa/<GPA> p/<PREFERENCES>. For e.g. id/A1234567J gpa/4.5 p/{1,2,3}");
    }
}