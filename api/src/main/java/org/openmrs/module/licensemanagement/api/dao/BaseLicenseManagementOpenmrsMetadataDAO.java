package org.openmrs.module.licensemanagement.api.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.openmrs.OpenmrsMetadata;

import java.util.List;

abstract class BaseLicenseManagementOpenmrsMetadataDAO<E extends OpenmrsMetadata>
    extends BaseLicenseManagementOpenmrsObjectDAO<E> {

  /**
   * @param openmrsObjectClass the Class of the main type handled by the Dao, not null
   */
  BaseLicenseManagementOpenmrsMetadataDAO(final Class<E> openmrsObjectClass) {
    super(openmrsObjectClass);
  }

  E internalReadByName(final String name) {
    final Criteria criteria = getSession().createCriteria(getOpenmrsObjectClass()).add(Restrictions.eq("name", name));
    return firstResult(criteria, getOpenmrsObjectClass());
  }

  List<E> internalReadAll(boolean includeRetired) {
    final Criteria criteria = getSession()
        .createCriteria(getOpenmrsObjectClass())
        .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

    if (!includeRetired) {
      criteria.add(Restrictions.eq("retired", false));
    }

    return criteria.list();
  }

  List<E> internalReadByNameFragment(final String nameFragment) {
    Criteria criteria = getSession()
        .createCriteria(getOpenmrsObjectClass())
        .setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
        .add(Restrictions.ilike("name", nameFragment, MatchMode.START));
    return criteria.list();
  }
}
