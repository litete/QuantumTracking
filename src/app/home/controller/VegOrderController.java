package app.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import app.common.base.ExecuteResult;
import app.home.model.VegOrder;
import app.home.service.VegOrderService;
import app.home.controller.BaseController;

@Controller
@RequestMapping("/vegorder")
public class VegOrderController extends BaseController {

	private VegOrderService thisService;
	private ExecuteResult executeResult = new ExecuteResult();
	private String viewPath = "App/Admin/Vegorder/";
	private String viewHtmlApp = "AppWeb/";
	private String appPath = "Phone/";

	public VegOrderService getThisService() {
		return thisService;
	}

	@Autowired
	public void setThisService(VegOrderService thisService) {
		this.thisService = thisService;
	}

	@RequestMapping("/all")
	public String showAllList(HttpServletRequest request) {
		try {
			List<VegOrder> list = thisService.select();
			request.setAttribute("list", list);
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}

	@RequestMapping("/notfinish")
	public String showListNotFinish(HttpServletRequest request) {
		try {
			List<VegOrder> list = thisService.selectNotFinish();
			request.setAttribute("list", list);
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}

	@RequestMapping("/notsure")
	public String showNotSure(HttpServletRequest request) {
		try {
			List<VegOrder> list = thisService.selectNotSure();
			request.setAttribute("list", list);
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}

	@RequestMapping("/yesfinish")
	public String showYesFinish(HttpServletRequest request) {
		try {
			List<VegOrder> list = thisService.selectYesFinish();
			request.setAttribute("list", list);
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}

	@ResponseBody
	@RequestMapping("/process")
	public Object Process(String id, HttpServletRequest request) {
		try {
			VegOrder info = thisService.selectId(id);
			if (info.getBuy_zhuangtai().equals("未确认")) {
				if (thisService.updateZhuangtaiNSure(id) == 1)
					return executeResult.jsonReturn(200,false);
				else
					return executeResult.jsonReturn(300);
			} else if (info.getBuy_zhuangtai().equals("未完成")) {

				if (thisService.updateZhuangtaiNFinish(id) == 1)
					return executeResult.jsonReturn(200,false);
				else
					return executeResult.jsonReturn(300);
			} else {
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}

	@ResponseBody
	@RequestMapping("/delete")
	public Object remove(int id, HttpServletRequest request) {
		try {
			int judge = thisService.remove(id);
			if (judge == 1) {
				return executeResult.jsonReturn(200, false);
			} else {
				return executeResult.jsonReturn(300);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return executeResult.jsonReturn(300, e.getMessage());
		}
	}

	@RequestMapping("/edit")
	public String modify(String id, HttpServletRequest request) {
		try {
			VegOrder info = thisService.find(id);
			request.setAttribute("info", info);
			return viewPath + "edit";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}

	@RequestMapping("update")
	@ResponseBody
	public Object update(VegOrder info) {
		try {
			if (thisService.save(info) == 1)
				return executeResult.jsonReturn(200);
			else
				return executeResult.jsonReturn(300);
		} catch (Exception e) {
			e.printStackTrace();
			return executeResult.jsonReturn(300, e.getMessage());
		}
	}
	
	@RequestMapping("/addinfo")
	public String addVegOrderInfo(VegOrder info,HttpServletRequest request){
		try {
			String city = request.getParameter("city");
			String street = request.getParameter("street");	
			String address = city+"/"+street;
			info.setShouaddress(address);		
			if(thisService.addVegOrederInfo(info) == 1)
				return "redirect:/findveg/go.do?type=success"; 
				//return viewHtmlApp + "success";
			else
				return viewHtmlApp + "result";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewHtmlApp + "result";
		}
	}
	
	@RequestMapping("/go")  
	public String go(@RequestParam String type) {  
	    return viewHtmlApp+type;  
	} 
	
	// App提交的数据
		@RequestMapping("/addapp")
		public String addVegOrderApp(VegOrder info,HttpServletRequest request,
				HttpServletResponse response) {
			try {
				int contentLength = request.getContentLength();
				if (contentLength < 0) {
					return null;
				}
				byte[] byts = new byte[contentLength];
				request.getInputStream().read(byts, 0, byts.length);
				String jsonString = new String(byts, "UTF-8");
				
				JSONObject jsonObject = JSON.parseObject(jsonString);
				String vegOrderNum = jsonObject.getString("VegOrderNum");
				String vegOrderTime = jsonObject.getString("VegOrderTime");
				String vegName = jsonObject.getString("VegName");
				int vegNumber = jsonObject.getInteger("VegNumber");
				String vegPrice = jsonObject.getString("VegPrice");
				String vegOrderName = jsonObject.getString("VegOrderName");
				String vegOrderPhone = jsonObject.getString("VegOrderPhone");
				String vegEatAddress = jsonObject.getString("VegOrderAddress");
				
				info.setOrdernum(vegOrderNum);
				info.setOrdertime(vegOrderTime);
				info.setVegname(vegName);
				info.setShouname(vegOrderName);
				info.setVegprice(vegPrice);
				info.setVegnum(vegNumber);
				info.setShounumber(vegOrderPhone);
				info.setBuy_zhuangtai("未确认");
				info.setShouaddress(vegEatAddress);
				
				if (thisService.addVegOrederInfo(info) == 1) {
					//response.getWriter().write("true");
					request.getSession(true).setAttribute("result", "success");
					return appPath + "result";
				}
				else {
					request.getSession(true).setAttribute("result", "error");
					return appPath + "result";
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("InfoMessage",
						"信息载入失败！具体异常信息：" + e.getMessage());
				return viewHtmlApp + "result";
			}
		}

}
