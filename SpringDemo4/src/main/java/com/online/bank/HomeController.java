package com.online.bank;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
public class HomeController extends JDBC{
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("Login");
		return mav;
	}
	
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public ModelAndView Logout() {
		ModelAndView mav = new ModelAndView("Login");
		return mav;
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView Login() {
		ModelAndView mav = new ModelAndView("Login");
		return mav;
	}
	
	@RequestMapping(value = "/Index", method = RequestMethod.POST)
	public ModelAndView Index(@RequestParam Map<String, String> reqPar, HttpServletRequest request) {
		System.out.println("in Index");
		String userid = reqPar.get("userid");
		String pass = reqPar.get("pass");
		boolean val = JDBC.loginvali(userid, pass, request);
		
     	if (val == true) {
     	    ModelAndView mav = new ModelAndView("Index");
     	    return mav;
        } else {
        	ModelAndView mav = new ModelAndView("Login");
        	mav.addObject("message", "The ID & Password combination is invalid, please reenter");
        	return mav;
        }
	}

	@RequestMapping(value = "/TOC", method = RequestMethod.GET)
	public ModelAndView TOC() {
	    ModelAndView mav = new ModelAndView("TOC");
 	    return mav;
	}
	
	@RequestMapping(value = "/Welc", method = RequestMethod.GET)
	public ModelAndView Welc(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView("Welc");
 	    return mav;
	}

	@RequestMapping(value = "/SecQ", method = RequestMethod.GET)
	public ModelAndView SecQ() {
	    ModelAndView mav = new ModelAndView("SecQ");
 	    return mav;
	}

	@RequestMapping(value = "/Acct", method = RequestMethod.GET)
	public ModelAndView Acct() {
	    ModelAndView mav = new ModelAndView("Acct");
 	    return mav;
	}

	@RequestMapping(value = "/Balin", method = RequestMethod.POST)
	public ModelAndView Balin(@RequestParam Map<String, String> reqPar, HttpServletRequest request) {
		System.out.println("in Balin");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		String Accttype = reqPar.get("Accttype");
		String [] Val = JDBC.Balin(userid, Accttype);
		ModelAndView mav = new ModelAndView("Balin");
		mav.addObject("Bal", Val[1]);
 	    return mav;
	}

	@RequestMapping(value = "/Depo", method = RequestMethod.GET)
	public ModelAndView Depo() {
	    ModelAndView mav = new ModelAndView("Depo");
 	    return mav;
	}
	@RequestMapping(value = "/Depo", method = RequestMethod.POST)
	public ModelAndView Depo(@RequestParam Map<String, String> reqPar, HttpServletRequest request) {
		System.out.println("in Depo");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		String Accttype = reqPar.get("Accttype");
		int Depo = Integer.parseInt(reqPar.get("depo"));
		boolean val = JDBC.depo(userid, Accttype, Depo);
		ModelAndView mav = new ModelAndView("Depo");
     	if (val == true) {
     	    mav.addObject("message", "Amount Deposited Successfully.");
        } else {
        	mav.addObject("message", "Error encountered while deposit, please try again later.");
        }
    	return mav;

	}

	@RequestMapping(value = "/Reg", method = RequestMethod.GET)
	public ModelAndView Reg() {
	    ModelAndView mav = new ModelAndView("Reg");
 	    return mav;
	}

	@RequestMapping(value = "/Reg", method = RequestMethod.POST)
	public ModelAndView Reg(String userid, String Accttype) {
	    ModelAndView mav = new ModelAndView("Reg");
	    mav.addObject("userid", userid);
	    mav.addObject("Accttype", Accttype);
	    return mav;
	}
	
	@RequestMapping(value = "/ShowPass", method = RequestMethod.POST)
	public ModelAndView ShowPass() {
	    ModelAndView mav = new ModelAndView("ShowPass");
 	    return mav;
	}

	@RequestMapping(value = "/Txn", method = RequestMethod.GET)
	public ModelAndView Txn() {
	    ModelAndView mav = new ModelAndView("Txn");
 	    return mav;
	}

	@RequestMapping(value = "/Withd", method = RequestMethod.GET)
	public ModelAndView Withd(HttpServletRequest request) {
		System.out.println("in Withd");
		//HttpSession session = request.getSession();
		//String userid = (String) session.getAttribute("userid");
	    ModelAndView mav = new ModelAndView("Withd");
 	    return mav;
	}
	@RequestMapping(value = "/Withd", method = RequestMethod.POST)
	public ModelAndView Withd(@RequestParam Map<String, String> reqPar, HttpServletRequest request) {
		System.out.println("in Withd");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		String Accttype = reqPar.get("Accttype");
		int withdamt = Integer.parseInt(reqPar.get("withdamt"));
		boolean val = JDBC.withd(userid, Accttype, withdamt);
	    ModelAndView mav = new ModelAndView("Withd");
     	if (val == true) {
     	    mav.addObject("message", "Amount Withdrawn Successfully.");
        } else {
        	mav.addObject("message", "Error encountered while withdraw, please check the withdraw amount.");
        }
    	return mav;
	}

	@RequestMapping(value = "/Xfr", method = RequestMethod.GET)
	public ModelAndView Xfr() {
	    ModelAndView mav = new ModelAndView("Xfr");
 	    return mav;
	}

	@RequestMapping(value = "/RegComp", method = RequestMethod.POST)
	public ModelAndView RegComp(@RequestParam Map<String, String> reqPar, HttpServletRequest request) {
		System.out.println("in RegComp");
		String userid = reqPar.get("userid");
		String dob = reqPar.get("dob");
		String fname = reqPar.get("fname");
		String lname = reqPar.get("lname");
		String mmname = reqPar.get("mmname");
		String pass = reqPar.get("pass");
		String email = reqPar.get("email");
		String ssn = reqPar.get("ssn");
		String sex = reqPar.get("sex");
		String add = reqPar.get("add");
		String accttype = reqPar.get("accttype");
		boolean val = JDBC.register(userid, pass, dob, fname, lname, mmname, email, add, ssn, sex, accttype);
		
     	if (val == true) {
    	    ModelAndView mav = new ModelAndView("RegComp");
     	    return mav;
        } else {
    	    ModelAndView mav = new ModelAndView("Reg");
    	    mav.addObject("message", "Unable to add your account now, please try again later");
     	    return mav;
        }
	}

	@RequestMapping(value = "/Admin", method = RequestMethod.GET)
	public ModelAndView AdLogin() {
	    ModelAndView mav = new ModelAndView("AdLogin");
 	    return mav;
	}

	@RequestMapping(value = "/Adws", method = RequestMethod.POST)
	public ModelAndView Adws(@RequestParam Map<String, String> reqPar, HttpServletRequest request) {
		System.out.println("in Admin WS");
		String userid = reqPar.get("aduserid");
		String pass = reqPar.get("adpass");
		if ((userid.equals("d")) && pass.equals("d")) {
			boolean val = JDBC.Admin();
			ModelAndView mav = new ModelAndView("Adws");
	 	    //mav.addObject("Entry", Entry);
			return mav;
		} else {
	 		ModelAndView mav = new ModelAndView("AdLogin");
	 		mav.addObject("message", "Invalid credential Admin!! come on!!");
 	    return mav;
		}
	}


}
