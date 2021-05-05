package SuperSimpleFactoryExample;

/**
 * The type Text field factory.
 */
public class TextFieldFactory {

    /**
     * Simple switch-case method created for the factory
     * In the case of String type, the textfield type will be referred to as a string type of textfield
     * Same goes for the case of Integer, will instantiate integer type.
     *
     * @param type the type
     * @return the tex field example
     */
    public TexFieldTypes createTextFieldType(String type) {
        TexFieldTypes typeOfTextField;
        switch (type.toLowerCase()) {
            case "StringType":
                typeOfTextField = new TextFieldType1();
                break;
            case "IntegerType":
                typeOfTextField = new TextFieldType2();
                break;
            default:
                throw new IllegalArgumentException("Exception thrown for not getting any cases");
        }
        return typeOfTextField;
    }
}