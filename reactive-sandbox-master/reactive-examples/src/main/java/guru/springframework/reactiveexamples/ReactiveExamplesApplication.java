package guru.springframework.reactiveexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveExamplesApplication.class, args);
		/*...Person....*/
		Person objPerson = new Person();
		objPerson.setFirstName("Nasim");
		objPerson.setLastName("Hasan");
		/*...Person Command....*/
		PersonCommand objPersonCommand = new PersonCommand(objPerson);
		System.out.println(objPersonCommand.sayMyName());


	}
}
