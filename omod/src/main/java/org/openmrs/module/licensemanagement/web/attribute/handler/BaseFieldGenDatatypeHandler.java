package org.openmrs.module.licensemanagement.web.attribute.handler;

import org.apache.commons.lang.StringUtils;
import org.openmrs.OpenmrsObject;
import org.openmrs.customdatatype.CustomDatatype;
import org.openmrs.customdatatype.InvalidCustomValueException;
import org.openmrs.customdatatype.SerializingCustomDatatype;
import org.openmrs.web.attribute.handler.FieldGenDatatypeHandler;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditor;
import java.util.Map;

abstract class BaseFieldGenDatatypeHandler<TypeDatatype extends SerializingCustomDatatype<Type>, Type extends OpenmrsObject>
        implements FieldGenDatatypeHandler<TypeDatatype, Type> {

    private final PropertyEditor typeEditor;

    BaseFieldGenDatatypeHandler(final PropertyEditor typeEditor) {
        this.typeEditor = typeEditor;
    }

    @Override
    public Map<String, Object> getWidgetConfiguration() {
        // not used
        return null;
    }

    @Override
    public Type getValue(TypeDatatype datatype, HttpServletRequest request, String formFieldName)
            throws InvalidCustomValueException {
        String formFieldValue = request.getParameter(formFieldName);

        if (StringUtils.isBlank(formFieldValue)) {
            return null;
        }

        if (StringUtils.isNumeric(formFieldValue)) {
            typeEditor.setAsText(formFieldValue);

            final Type entity = (Type) typeEditor.getValue();

            if (entity != null) {
                formFieldValue = entity.getUuid();
            }
        }

        return datatype.deserialize(formFieldValue);
    }

    @Override
    public CustomDatatype.Summary toHtmlSummary(CustomDatatype<Type> datatype, String valueReference) {
        return datatype.getTextSummary(valueReference);
    }

    @Override
    public String toHtml(CustomDatatype<Type> datatype, String valueReference) {
        return toHtmlSummary(datatype, valueReference).getSummary();
    }

    @Override
    public void setHandlerConfiguration(String s) {
        // not used
    }
}
