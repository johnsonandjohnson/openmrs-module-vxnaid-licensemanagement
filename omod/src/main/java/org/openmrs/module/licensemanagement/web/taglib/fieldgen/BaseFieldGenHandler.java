package org.openmrs.module.licensemanagement.web.taglib.fieldgen;

import org.openmrs.OpenmrsObject;
import org.openmrs.web.taglib.fieldgen.AbstractFieldGenHandler;
import org.openmrs.web.taglib.fieldgen.FieldGenHandler;

public abstract class BaseFieldGenHandler extends AbstractFieldGenHandler implements FieldGenHandler {
    private final String defaultUrl;

    BaseFieldGenHandler(final String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

    @Override
    public void run() {
        setUrl(defaultUrl);

        if (fieldGenTag == null) {
            return;
        }

        checkEmptyVal(null);

        setInitialValue();
        setOptionHeader();
        loadAdditionalData();
    }

    private void setInitialValue() {
        String initialValue = "";
        final OpenmrsObject object = (OpenmrsObject) this.fieldGenTag.getVal(); // get the initial value
        if (object != null && object.getId() != null) {
            initialValue = object.getId().toString();
        }
        setParameter("initialValue", initialValue);
    }

    private void setOptionHeader() {
        String optionHeader = "";
        if (this.fieldGenTag.getParameterMap() != null) {
            optionHeader = (String) this.fieldGenTag.getParameterMap().get("optionHeader");
        }
        if (optionHeader == null) {
            optionHeader = "[blank]";
        }
        setParameter("optionHeader", optionHeader);
    }

    abstract void loadAdditionalData();
}
