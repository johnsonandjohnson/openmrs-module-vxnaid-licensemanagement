package org.openmrs.module.licensemanagement.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.module.licensemanagement.DeviceError;
import org.openmrs.module.licensemanagement.api.dao.DeviceErrorDAO;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DeviceErrorDAOTest extends BaseModuleContextSensitiveTest {

    private static final String INITIAL_DATA_XML = "org/openmrs/module/licensemanagement/dao/DeviceErrorDAOTest.xml";

    @Autowired
    DeviceErrorDAO dao;

    @Before
    public void runBeforeEachTest() throws Exception {
        executeDataSet(INITIAL_DATA_XML);
        updateSearchIndex();
    }

    @After
    public void runAfterEachTest() throws Exception {
        deleteAllData();
    }

    @Test
    public void getDeviceError_shouldReturnCorrectDeviceError() throws ParseException {
        // Given
        // Data loaded from XML

        // When
        final DeviceError result = dao.getDeviceError(1);

        // Then
        assertThat(result, notNullValue());
        assertThat(result, hasProperty("uuid", is("f08ba64b-0000-0000-0000-000000000000")));
        assertThat(result, hasProperty("metaType", is("license")));
        assertThat(result, hasProperty("metaSubType", is("IRIS_CLIENT")));
        assertThat(result, hasProperty("metaValue", is("GET_LICENSE_CALL")));
        assertThat(result, hasProperty("key", is("license:IRIS_CLIENT,GET_LICENSE_CALL")));
        assertThat(result, hasProperty("meta",
                                       is("{type: \\\"license\\\",licenseType: \\\"IRIS_CLIENT\\\",action: \\\"GET_LICENSE_CALL\\\"}")));
    }
}
