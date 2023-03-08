/**
 * 
 */
package springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nhasa
 *
 */
public class SpringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  @SuppressWarnings("resource")
		  ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	      obj.getMessage();
	      

	}

}
