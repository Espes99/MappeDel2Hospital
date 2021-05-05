package SuperSimpleFactoryExample;

import javafx.scene.control.TextField;

/**
 * Abstract class for the types the factory should produce
 */
public abstract class TexFieldTypes {

    /**
     * Create text field text field.
     *
     * @return the text field
     */
    public abstract TextField createTextField();
}
