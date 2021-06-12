package covid.dashboard;

import static org.assertj.core.api.Assertions.assertThat;

import covid.dashboard.model.User;
import covid.dashboard.repository.UserRepository;
import covid.dashboard.service.CovidDashboardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@WebMvcTest(value = AppController.class)
//@WithMockUser
//@SpringBootTest(value = "AppController.class")
public class UserRepositoryTests {

	@MockBean
	private TestEntityManager entityManager;

	@Autowired
	CovidDashboardService service;
	
	@Autowired
	private UserRepository repository;
	
	@Test
	@Rollback(false)
	public void testCreateUser() {
		User user = new User();
		user.setEmail("ravikumar@gmail.com");
		user.setPassword("ravi2020");
		user.setFirstName("Ravi");
		user.setLastName("Kumar");

//		Mockito.when(repository.save(user)).thenReturn(user);

		User savedUser = service.saveUser(user);
//		User savedUser = userRepository.save(user);

		User existUser = repository.findByEmail(savedUser.getEmail());
		
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
		
	}
	
	/*@Test
	public void testFindByEmail() {
		String email = "nam@codejava.net";
		User user = repo.findByEmail(email);
		
		assertThat(user.getEmail()).isEqualTo(email);
	}*/
}
