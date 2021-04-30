package org.openmrs.module.licensemanagement.propertyeditor;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public abstract class BasePropertyEditorSupport<Entity> extends PropertyEditorSupport {
    private final Log log = LogFactory.getLog(this.getClass());
    private final String entityName;

    BasePropertyEditorSupport(final String entityName) {
        this.entityName = entityName;
    }

    public String getAsText() {
        final Entity entity = (Entity) this.getValue();
        if (entity == null && Context.isAuthenticated()) {
            return null;
        } else {
            return ObjectUtils.toString(getEntityId(entity), null);
        }
    }

    public void setAsText(String text) throws IllegalArgumentException {
        Entity value = null;

        if (StringUtils.hasText(text)) {
            try {
                value = getEntityById(Integer.valueOf(text));
            } catch (Exception ex) {
                value = getEntityByName(text);

                if (value == null) {
                    this.log.error("Error setting text: " + text, ex);
                    throw new IllegalArgumentException(entityName + " not found.", ex);
                }
            }
        }

        setValue(value);
    }

    abstract Integer getEntityId(Entity entity);

    abstract Entity getEntityById(Integer id);

    abstract Entity getEntityByName(String text);
}
