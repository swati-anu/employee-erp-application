package com.employee.erp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.employee.erp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ContactsTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Contacts.class);
        Contacts contacts1 = new Contacts();
        contacts1.setId(1L);
        Contacts contacts2 = new Contacts();
        contacts2.setId(contacts1.getId());
        assertThat(contacts1).isEqualTo(contacts2);
        contacts2.setId(2L);
        assertThat(contacts1).isNotEqualTo(contacts2);
        contacts1.setId(null);
        assertThat(contacts1).isNotEqualTo(contacts2);
    }
}
