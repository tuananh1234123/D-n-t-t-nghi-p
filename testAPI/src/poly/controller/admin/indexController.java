package poly.controller.admin;

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
@RequestMapping("admin")
public class indexController {
	
	String message = "<p> Anh đep zap</p>";
	@Autowired
	SessionFactory factory;
	@RequestMapping(value = "index123", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = " From NhanVien";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		model.addAttribute("index", list);
		model.addAttribute("sinhvien", new Product());
		model.addAttribute("message", "index");
		ModelAndView viewDasbroad = new ModelAndView("dasbroad");
		return viewDasbroad;
	}
	@RequestMapping(params = "btnInsert")
	public String insert(ModelMap model, @ModelAttribute("sinhvien") Product nhanvien) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(nhanvien);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Trung ma");
		} finally {
			session.close();
		}
		// dua len combobox

		model.addAttribute("sinhvien", new Product());
		model.addAttribute("index", getNhanVien());
		return "dasbroad";
	}

	@RequestMapping(params = "edit") // tu trang qlnhan vien sang trang update
	public String actionDelete_UpdateGet(ModelMap model, @RequestParam("masv") int manv) {
		Session session = factory.getCurrentSession();
		Product nhanvien = (Product) session.get(Product.class, manv);

		
		model.addAttribute("index", getNhanVien());
		model.addAttribute("sinhvien", nhanvien);
		model.addAttribute("message", "Đang Edit nè !");
		return "dasbroad";

	}

	public List<Product> getNhanVien() {

		Session session = factory.getCurrentSession();
		String hql = "FROM NhanVien";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		return list;
	}

	@RequestMapping(params = "btnUpdate")
	public String actionDelete_Update(ModelMap model, @ModelAttribute("SinhVien") Product nhanvien) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(nhanvien);
			t.commit();
			model.addAttribute("message", "Cap nhap thanh cong !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Cap nhap that bai !");
		} finally {
			session.close();
		}
		model.addAttribute("sinhvien", new Product());
		model.addAttribute("index", getNhanVien());
		return "dasbroad";

	}

	@RequestMapping(params = "btnDelete")
	public String actionDelete(ModelMap model, @RequestParam("masv") int manv, Product nhanvien) {
		Session session = factory.openSession();
		nhanvien = (Product) session.get(Product.class, manv);
		Transaction t = session.beginTransaction();
		try {
			session.delete(nhanvien);
			t.commit();
			model.addAttribute("message", "Cap nhap thanh cong !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Delete that bai !");
		} finally {
			session.close();
		}
		model.addAttribute("sinhvien", new Product());
		model.addAttribute("index", getNhanVien());
		return "dasbroad";

	}

	
}
