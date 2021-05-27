package com.crud.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;     

import com.sample.vo.CompanyVO;
import com.sample.dao.CompanyDAO;

@Controller
public class CompanyController {
	@Autowired
	CompanyDAO dao; // xml에서 DAO 삽입
	
	@RequestMapping("/empform")
	public String showform(Model m) {
		m.addAttribute("command",new CompanyVO());
		return "empform";
	}
	 @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("co") CompanyVO co){    
	        dao.save(co);    
	        return "redirect:/viewemp"; // 저장된 값을 empform으로 반환한다.  
	    }    
	 @RequestMapping("/viewemp")    
	    public String viewemp(Model m){    
	        List<CompanyVO> list=dao.getEmployees();    
	        m.addAttribute("list",list);  
	        return "viewemp";    
	    }
	 @RequestMapping(value="/editemp/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        CompanyVO co=dao.getCompanyVOById(id);
	        m.addAttribute("command",co);  
	        return "empeditform";
	    }
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("co") CompanyVO co){    
	        dao.update(co);    
	        return "redirect:/viewemp";    
	    }
	 @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        dao.delete(id);    
	        return "redirect:/viewemp";
	    }     
}
