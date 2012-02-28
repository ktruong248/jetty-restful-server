package org.jettyrest.api.employee;

import org.jettyrest.api.EmployeeService;
import org.jettyrest.api.employee.entities.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeResourceTest {

    private EmployeeResource employeeResource;
    private Employee employee;

    @Mock
    private EmployeeService<Employee, String> service;

    @Before
    public void setup() {
        employeeResource = new EmployeeResource();
        employeeResource.setEmployeeService(service);
        employee = new Employee();
    }


    @Test
    public void shouldSaveAndReturnCreatedStatusCode() {
        given(service.save(employee)).willReturn("a uuid");
        Response response = employeeResource.save(employee);
        assertNotNull(response);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }


    @Test
    public void shouldSaveAndReturnCreateResponseAsBody() {
        given(service.save(employee)).willReturn("a uuid");
        Response response = employeeResource.save(employee);
        CreatedResponse createdId = (CreatedResponse) response.getEntity();
        assertNotNull(createdId);
        assertEquals("a uuid", createdId.getId());
    }


    @Test
    public void shouldCallDAOWhenSaving() {
        employeeResource.save(employee);
        verify(service).save(employee);
    }


    @Test
    public void shouldHaveFindByUUID() {
        given(service.findById("my uuid")).willReturn(employee);
        Employee foundEmployee = employeeResource.findById("my uuid");
        assertNotNull(foundEmployee);
        assertThat(foundEmployee, is(equalTo(employee)));
    }


    @Test
    public void shouldCallFindByUUID() {
        employeeResource.findById("my c uuid");
        verify(service).findById("my c uuid");
    }


    @Test
    public void shouldCallDelete() {
        employeeResource.deleteById("my uuid to delete");
        verify(service).delete("my uuid to delete");
    }
}