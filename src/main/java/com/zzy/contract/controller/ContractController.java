package com.zzy.contract.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zzy.contract.dao.ContractDao;
import com.zzy.contract.entity.SGContract;

@Controller
//@ComponentScan("com.zzy.contract.service")
public class ContractController {
	
	@Autowired
	private ContractDao contractDao;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
	}
	
	@RequestMapping(value="/showContractHistory")
	public String showContractHistory(Model model) {
		List<SGContract> contractHistory = contractDao.selectAll();
		model.addAttribute("contractHistory", contractHistory);
		
		return "ContractHistory";
	}
	
	@RequestMapping(value="/main")
	public String getContractList(Model model) {
		SGContract sgContract = contractDao.selectLatestOne();
		model.addAttribute("contract", sgContract);
		
		return "ContractList";
	}
	
	@RequestMapping(value="/contract_insert")
	public String insertContract(Model model) {
		SGContract sgContract = new SGContract();
		model.addAttribute("sgContract", sgContract);
		
		return "ContractInsertForm";
	}
	
	@RequestMapping(value="/contract_save", method=RequestMethod.POST)
	public String saveContract(@ModelAttribute SGContract sgContract) {
		System.out.println("in contract save...");
		boolean result = contractDao.insert(sgContract);
		System.out.println(result);
		
		return "redirect:/main";
	}
	
	@RequestMapping(value="/contract_delete/{id}")
	public String deleteContract(@PathVariable int id) {
		System.out.println("in contract delete...");
		boolean result = contractDao.deleteById(id);
		System.out.println(result);
		
		return "redirect:/main";
		
	}
	
	@RequestMapping(value="/contract_edit/{id}")
	public String editContract(@PathVariable String id, Model model) {
		SGContract sgContract = contractDao.selectById(Integer.valueOf(id));
		model.addAttribute("sgContract", sgContract);
		
		return "ContractEditForm";
	}
	
	@RequestMapping(value="/contract_edit/contract_update", method=RequestMethod.POST)
	public String updateContract(@ModelAttribute SGContract sgContract) {
		System.out.println("in contract update...");
		sgContract.setUpdated_at(new Date());
		boolean result = contractDao.insert(sgContract);
		System.out.println(result);
		
		return "redirect:/main";
	}

}
