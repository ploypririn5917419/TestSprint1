package com.team22.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.team22.backend.Entity.*;
import com.team22.backend.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class BackendApplicationTests {

	@Autowired
    private StyleRepository stylerepository;
    private StaffRepository staffrepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testStaffNameCannotBeNull() {
        Staff st = new Staff();
        st.setStaffName(null);
               
        try {
            entityManager.persist(st);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

	// @Test
    // public void testFirstCharStyleIDsNotSy(){
    //     Style sy = new Style();
    //     sy.setStyleIDs("D2");
        
    //     try {
    //         entityManager.persist(sy);
    //         entityManager.flush();

    //         fail("Should not pass to this line");
    //     } catch(javax.validation.ConstraintViolationException e) {
    //         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    //         assertEquals(violations.isEmpty(), false);
    //         assertEquals(violations.size(), 1);
    //     }
    // }

    @Test
    public void testStyleNameSize(){
        Style sy = new Style();
        sy.setStyleName("lao");
        // sy.setStyleIDs("Sy1");
        // sy.setStylePrice(1000);
        try {
            entityManager.persist(sy);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}

