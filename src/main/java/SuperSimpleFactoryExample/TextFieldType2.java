package SuperSimpleFactoryExample;

import javafx.scene.control.TextField;

/**
 * The type Text field type Integer.
 * One of the types extending examples, this case textfields.
 */
public class TextFieldType2 extends TexFieldTypes {

    @Override
    public TextField createTextField() {
        return new TextField("IntegerType");
    }
}
