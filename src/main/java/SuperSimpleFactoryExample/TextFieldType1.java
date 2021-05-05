package SuperSimpleFactoryExample;

import javafx.scene.control.TextField;

/**
 * The type Text field type string.
 * One of the types extending examples, this case textfields.
 */
public class TextFieldType1 extends TexFieldTypes {

    @Override
    public TextField createTextField() {
        return new TextField("StringType");
    }

}


