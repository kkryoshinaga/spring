package jp_co.good_works.lesson;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */


@Scope("session")
@Controller 
public class ProductController {
	private List<ProductForm> productList = new ArrayList<ProductForm>();

	@RequestMapping

	(value = "/product", method = RequestMethod.GET)
	public String product(Model model) { 
		List<String> genders = new ArrayList<String>(); 
		genders.add("男"); 
		genders.add("女"); 
		model.addAttribute("genders", genders);
		List<String> birthplaces = new ArrayList<String>(); 
		birthplaces.add(""); birthplaces.add("北海道"); birthplaces.add("東北"); 
		birthplaces.add("関東"); birthplaces.add("甲信越"); 
		birthplaces.add("東海"); birthplaces.add("関西");
		birthplaces.add("四国"); birthplaces.add("中国"); 
		birthplaces.add("九州"); birthplaces.add("沖縄"); 
		model.addAttribute("birthplaces", birthplaces); 
		List<String> langs = new ArrayList<String>(); 
		langs.add("Java"); langs.add("PHP"); langs.add("Ruby"); 
		model.addAttribute("langs", langs);
		ProductForm form = new ProductForm(); 
		model.addAttribute("message", "商品情報を入力してください");
		model.addAttribute("productForm", form); 
		return "product"; 
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST) 
	public String product(Model model,@Validated @ModelAttribute ProductForm form,BindingResult result) 
	{  	
		if(result.hasErrors()) {
			model.addAttribute("message", "エラーがあります");
		}else {
			model.addAttribute("message", "商品情報が入力されました"); 
			productList.add(form);
		}
		List<String> genders = new ArrayList<String>();
		genders.add("男"); 
		genders.add("女");
		model.addAttribute("genders", genders);
		List<String> birthplaces = new ArrayList<String>(); 
		birthplaces.add(""); birthplaces.add("北海道"); birthplaces.add("東北"); 
		birthplaces.add("関東"); birthplaces.add("甲信越"); 
		birthplaces.add("東海"); birthplaces.add("関西");
		birthplaces.add("四国"); birthplaces.add("中国"); 
		birthplaces.add("九州"); birthplaces.add("沖縄"); 
		model.addAttribute("birthplaces", birthplaces); 
		List<String> langs = new ArrayList<String>(); 
		langs.add("Java"); langs.add("PHP"); langs.add("Ruby"); 
		model.addAttribute("langs", langs);
		model.addAttribute("productForm", form); 
		model.addAttribute("productList", productList);
		return "product"; 
	}

}
