import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {
	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	      DriverManagerDataSource dataSource = context.getBean(DriverManagerDataSource.class);
	      System.out.println("Print");
	      
}
}