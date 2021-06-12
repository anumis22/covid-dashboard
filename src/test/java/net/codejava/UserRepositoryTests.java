package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;

import net.codejava.controller.AppController;
import net.codejava.model.User;
import net.codejava.repository.UserRepository;
import net.codejava.service.CovidDashboardService;
import net.codejava.service.CovidDashboardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@WebMvcTest(value = AppController.class)
@WithMockUser
public class UserRepositoryTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TestEntityManager entityManager;

	@InjectMocks
	CovidDashboardService service = new CovidDashboardServiceImpl();
	
	@Mock
	private UserRepository repository;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("ravikumar@gmail.com");
		user.setPassword("ravi2020");
		user.setFirstName("Ravi");
		user.setLastName("Kumar");

//		Mockito.when(repository.save(user)).thenReturn(user);

		User savedUser = service.saveUser(user);
//		User savedUser = userRepository.save(user);

		User existUser = entityManager.find(User.class, savedUser.getEmail());
		
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
		
	}
	
	/*@Test
	public void testFindByEmail() {
		String email = "nam@codejava.net";
		User user = repo.findByEmail(email);
		
		assertThat(user.getEmail()).isEqualTo(email);
	}*/
}
