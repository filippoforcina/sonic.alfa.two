package base.mvc.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		final AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
		annotationConfigWebApplicationContext.setServletContext(servletContext);
		annotationConfigWebApplicationContext.register(MyConfiguration.class);
		annotationConfigWebApplicationContext.refresh();

		/* Create and register the DispatcherServlet. */
		final DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("springDispatcher", dispatcherServlet);
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("*.spr");

	}

}
