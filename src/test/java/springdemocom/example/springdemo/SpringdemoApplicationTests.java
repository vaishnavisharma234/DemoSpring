package springdemocom.example.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.sre.DemoModel.DemoModel;
import com.demo.sre.Repository.DemoRepository;
import com.demo.sre.Service.DemoService;
import com.demo.sre.exception.DemoException;

@SpringBootTest
class SpringdemoApplicationTests {

	
	@Mock 
	private DemoRepository demoRepository;
	
	@InjectMocks
	private DemoService  demoService=new DemoService();
	

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getUserInvalidTest() throws DemoException{
		List<DemoModel> userList=new ArrayList<DemoModel>();
		userList.clear();
		Mockito.when(demoRepository.getUsers()).thenReturn(userList);
		DemoException exception=Assertions.assertThrows(DemoException.class,()->demoService.getUser());
		Assertions.assertEquals("User Not Found!", exception.getMessage());	
		
		 
	}	
	
	@Test
	public void addUserValidTest() throws DemoException{
		DemoModel user=new DemoModel("Bad",23,121);
	//	Mockito.when(demoRepository.getById(Mockito.anyInt())).thenReturn(mock);
		Assertions.assertEquals("User added successfully", demoService.addUser(user));	
	}	

	
	@Test
	public void modifyUserInvalidTest() throws DemoException{
		DemoModel user=new DemoModel();
		user.setId(121);
		Mockito.when(demoRepository.getById(Mockito.anyInt())).thenReturn(null);
		DemoException exception=Assertions.assertThrows(DemoException.class,()->demoService.modifyUser(user));
		Assertions.assertEquals("User Not Found!", exception.getMessage());	
		
		 
	}
	@Test
	public void deleteUserInvalidTest() throws DemoException{
		int userId=121;
		Mockito.when(demoRepository.getById(Mockito.anyInt())).thenReturn(null);
		DemoException exception=Assertions.assertThrows(DemoException.class,()->demoService.deleteUser(userId));
		Assertions.assertEquals("User Not Found!", exception.getMessage());	
		
		 
	}

	@Test
	public void getUserValidTest() throws DemoException{
		DemoModel demo=new DemoModel("Good",21,111);
		List<DemoModel> userList=new ArrayList<DemoModel>();
		userList.add(demo);
		Mockito.when(demoRepository.getUsers()).thenReturn(userList);
		Assertions.assertDoesNotThrow(()->demoService.getUser());	
		
		 
	}	
	

	@Test
	public void modifyUserValidTest() throws DemoException{
		DemoModel user=new DemoModel("Good",21,111);
		DemoModel mock=new DemoModel();
		mock.setId(111);
		mock.setAge(21);
		mock.setName("Good");
		Mockito.when(demoRepository.getById(Mockito.any())).thenReturn(mock);
		Assertions.assertEquals("User updated successfully", demoService.modifyUser(user));
		
	}	
	
	@Test
	public void deleteUserValidTest() throws DemoException{
		DemoModel mock=new DemoModel();
		mock.setId(111);
		mock.setAge(21);
		mock.setName("Good");
		int id=111;
		Mockito.when(demoRepository.getById(Mockito.anyInt())).thenReturn(mock);

		Assertions.assertEquals("User deleted successfully",demoService.deleteUser(id));			
		 
	}	

}
