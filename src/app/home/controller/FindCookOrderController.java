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
import app.home.model.FindCookOrder;
import app.home.service.FindCookOrderService;

@Controller
@RequestMapping("/findcook")
public class FindCookOrderController extends BaseController {

	private FindCookOrderService thisService;
	private ExecuteResult executeResult = new ExecuteResult();
	private String viewPath = "App/Admin/FindCook/";
	private String viewHtmlApp = "AppWeb/";
	private String appPath = "Phone/";

	public FindCookOrderService getThisService() {
		return thisService;
	}

	@Autowired
	public void setThisService(FindCookOrderService thisService) {
		this.thisService = thisService;
	}

	@RequestMapping("/all")
	public String showAllList(HttpServletRequest request) {
		try {
			List<FindCookOrder> list = thisService.select();
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
			List<FindCookOrder> list = thisService.selectNotFinish();
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
	public String showListYesFinish(HttpServletRequest request) {
		try {
			List<FindCookOrder> list = thisService.selectYesFinish();
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
	public String showListNotSure(HttpServletRequest request) {
		try {
			List<FindCookOrder> list = thisService.selectNotSure();
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
			FindCookOrder info = thisService.selectId(id);
			if (info.getBuy_zhuangtai().equals("未确认")) {
				if (thisService.updateZhuangtaiNSure(id) == 1)
					return executeResult.jsonReturn(200, false);
				else
					return executeResult.jsonReturn(300);
			} else if (info.getBuy_zhuangtai().equals("未完成")) {

				if (thisService.updateZhuangtaiNFinish(id) == 1)
					return executeResult.jsonReturn(200, false);
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
			FindCookOrder info = thisService.find(id);
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
	public Object update(FindCookOrder info) {
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

	// App提交的数据
	@RequestMapping("/addapp")
	public String addCookOrderApp(FindCookOrder info,HttpServletRequest request,
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
			String cookOrderNum = jsonObject.getString("CookOrderNum");
			String cookOrderTime = jsonObject.getString("CookOrderTime");
			String cooKTaoCan = jsonObject.getString("CooKTaoCan");
			String cookOrderName = jsonObject.getString("CookOrderName");
			String cookOrderPhone = jsonObject.getString("CookOrderPhone");
			String cookOrderBeizhu = jsonObject.getString("CookOrderBeizhu");
			String cookEatTime = jsonObject.getString("CookEatTime");
			String cookEatAddress = jsonObject.getString("CookEatAddress");
			
			info.setOrdernum(cookOrderNum);
			info.setOrdertime(cookOrderTime);
			info.setTaocan(cooKTaoCan);
			info.setName(cookOrderName);
			info.setPhonenum(cookOrderPhone);
			info.setBeizhu(cookOrderBeizhu);
			info.setEattime(cookEatTime);
			info.setBuy_zhuangtai("未确认");
			info.setAddress(cookEatAddress);
			
			if (thisService.addCookOrederInfo(info) == 1) {
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

	@RequestMapping("/addinfo")
	public String addCookOrderInfo(FindCookOrder info,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			String city = request.getParameter("city");
			String street = request.getParameter("street");
			String address = city + "/" + street;
			info.setAddress(address);
			if (thisService.addCookOrederInfo(info) == 1)
				return "redirect:/findcook/go.do?type=success";
			// return viewHtmlApp + "success";
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
		return viewHtmlApp + type;
	}

}
