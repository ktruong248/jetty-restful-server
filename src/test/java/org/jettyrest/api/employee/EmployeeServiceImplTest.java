package org.jettyrest.api.employee;

import org.jettyrest.api.employee.entities.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    private EmployeeServiceImpl service;

    @Mock
    private EmployeeRespository repository;

    private Employee employee;

    @Before
    public void setup() {
        service = new EmployeeServiceImpl();
        service.setRepository(repository);

        employee = new Employee();
    }


    @Test
    public void shouldCallSave() {
        employee.setId("some id");
        given(repository.save(employee)).willReturn(employee);

        String id = service.save(employee);
        assertEquals("some id", id);
    }


    @Test
    public void shouldCallFindById() {
        service.findById("some id");

        verify(repository).findOne("some id");
    }


    @Test
    public void shouldReturnTheFound() {
        given(repository.findOne("some id")).willReturn(employee);

        Employee found = service.findById("some id");
        assertEquals(employee, found);
    }


    @Test
    public void shouldDelete() {
        service.delete("some id");

        verify(repository).delete("some id");
    }
}