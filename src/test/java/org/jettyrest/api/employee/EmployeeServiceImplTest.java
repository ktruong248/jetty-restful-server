package org.jettyrest.api.employee;

//@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

//    private EmployeeServiceImpl service;
//
//    @Mock
//    private EmployeeRepository repository;
//
//    private Employee employee;
//
//    @Before
//    public void setup() {
//        service = new EmployeeServiceImpl();
//        service.setRepository(repository);
//
//        employee = new Employee();
//    }
//
//
//    @Test
//    public void shouldCallSave() {
//        employee.setId("some id");
//        given(repository.save(employee)).willReturn(employee);
//
//        String id = service.save(employee);
//        assertEquals("some id", id);
//    }
//
//
//    @Test
//    public void shouldCallFindById() {
//        service.findByUUID("some id");
//
//        verify(repository).findOne("some id");
//    }
//
//
//    @Test
//    public void shouldReturnTheFound() {
//        given(repository.findOne("some id")).willReturn(employee);
//
//        Employee found = service.findByUUID("some id");
//        assertEquals(employee, found);
//    }
//
//
//    @Test
//    public void shouldDelete() {
//        service.deleteByUUID("some id");
//
//        verify(repository).delete("some id");
//    }
}