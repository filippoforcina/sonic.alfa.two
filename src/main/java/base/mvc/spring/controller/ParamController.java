package base.mvc.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParamController {

	private static final Logger log = LoggerFactory.getLogger(ParamController.class);

	@Value("${admin.name}")
	private String admName;

	@Value("${admin.surname}")
	private String admSurname;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/touch.spr")
	public String loadParam(Model model) {
		log.info("loadParam");
		model.addAttribute("nome", admName);
		model.addAttribute("cognome", admSurname);
		log.info("get messages:"+ messageSource.getMessage("message.hello", null, null));
		return "touch";
	}

}
