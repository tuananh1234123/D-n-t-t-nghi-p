
package poly.controller.customer;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Product;

@Transactional
@Controller

public class index {
	
	String message = "<p> Anh đep zap</p>";
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "/index.php", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = " From NhanVien";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		model.addAttribute("index", list);
		model.addAttribute("sinhvien", new Product());
		model.addAttribute("message", "indexCustomer");
		ModelAndView viewDasbroad = new ModelAndView("dasbroad");
		return viewDasbroad;
	}
	
	
}
