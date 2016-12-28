package app.home.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import app.common.base.ExecuteResult;
import app.home.model.Cook;
import app.home.service.CookService;

@Controller
@RequestMapping("/cook")
public class CookController extends BaseController {

	private CookService thisService;
	private ExecuteResult executeResult = new ExecuteResult();
	private String viewPath = "App/Admin/Cook/";
	private String appWebPath = "AppWeb/";
	private String appPath = "Phone/";

	public CookService getThisService() {
		return thisService;
	}
	
	@Autowired
	public void setThisService(CookService thisService) {
		this.thisService = thisService;
	}
	
	@RequestMapping("/all")
	public String showAllList(HttpServletRequest request){
		try {
			List<Cook> list = thisService.select();
			request.setAttribute("list", list);
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("/allAppWeb")
	public String showAllList_m(HttpServletRequest request){
		try {
			List<Cook> list = thisService.select();
			request.setAttribute("list", list);
			return appWebPath + "findcook";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	//地址：http://地址/FiveA/cook/allCook.do?format=json
	@RequestMapping("/allCook")
	public String showAllList_app(HttpServletRequest request,HttpServletResponse response){
		try {
			List<Cook> list = thisService.select();
			String format = request.getParameter("format");
			if ("json".equals(format)) {
				JsonArray array = new JsonArray();
				for (int i = 0; i < list.size(); i++) {
					JsonObject jo = new JsonObject();
					Cook cook = (Cook) list.get(i);
					int id = cook.getId();
					String cook_name = (String)cook.getCook_name();
					String info = (String)cook.getInfo();
					String from_gs = (String)cook.getFrom_gs();
					int price = (int)cook.getPrice();
					String img = (String)cook.getImg();
					jo.addProperty("Id", id);
					jo.addProperty("Cook_name", cook_name);
					jo.addProperty("Info", info);
					jo.addProperty("From_gs", from_gs);
					jo.addProperty("Price", price);
					jo.addProperty("From_gs", from_gs);
					jo.addProperty("Img", img);
					array.add(jo);
				}
				request.setAttribute("json", array.toString());
			}			
			return appPath + "json_cook";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("/add")
	public String addCook(HttpServletRequest request){
		try {
			return viewPath + "add";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}	
	
	@RequestMapping("/addinfo")
	@ResponseBody
	public Object addCookInfo(@RequestParam("imageFile")MultipartFile imageFile,
			Cook cookMany,HttpServletRequest request){
		try {
			String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"images\\";
			String filename = imageFile.getOriginalFilename();
			File dir = new File(uploadUrl);
			if(dir.exists()) {
				dir.mkdirs();
			}
			File targetFile = new File(uploadUrl+filename);
			if(!targetFile.exists()){
				targetFile.createNewFile();
			}
			imageFile.transferTo(targetFile);
			String imgUrl = filename;
			cookMany.setImg(imgUrl);
			if(thisService.addCookInfo(cookMany) == 1)
				return executeResult.jsonReturn(200);
			else
				return executeResult.jsonReturn(300);
		} catch (Exception e) {
			e.printStackTrace();
			return executeResult.jsonReturn(300, e.getMessage());
		}
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String remove(int id,HttpServletRequest request){
		try {			
			String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"images\\";
			List<Cook> list = thisService.selectUrl(id);
			Cook CookInfo = list.get(0);
			String urls = CookInfo.getImg();
			File file = new File(uploadUrl+urls);
			file.delete();		
			int judge = thisService.remove(id);
			if (judge == 1){
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping("/edit")
	public String modify(String id,HttpServletRequest request){
		try {
			Cook info = thisService.find(id);
			request.setAttribute("info", info);
			return viewPath + "edit";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(@RequestParam("imageFile")MultipartFile imageFile,Cook info,
			HttpServletRequest request){
		try {	
			String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"images\\";	
			String filename = imageFile.getOriginalFilename();
			if(filename != "") {
				System.out.println("删除了啊");
				//删除图片
				String urls = request.getParameter("imgold");
				File file = new File(uploadUrl+urls);
				file.delete();	
				//上传图片
				File dir = new File(uploadUrl);
				if(dir.exists()) {
					dir.mkdirs();
				}
				System.out.println("文件上传到："+uploadUrl+filename);
				File targetFile = new File(uploadUrl+filename);
				if(!targetFile.exists()){
					targetFile.createNewFile();
				}
				imageFile.transferTo(targetFile);
				String imgUrl = filename;				
				info.setImg(imgUrl);
				if(thisService.save(info) == 1)
					return executeResult.jsonReturn(200);
				else
					return executeResult.jsonReturn(300);
			} else {
				System.out.println("不删除");
				if(thisService.save(info) == 1)
					return executeResult.jsonReturn(200);
				else
					return executeResult.jsonReturn(300);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return executeResult.jsonReturn(300, e.getMessage());
		}
	}
	
	@RequestMapping("/info")
	public String CookInfo_m(String id, HttpServletRequest request) {
		try {
			Cook info = thisService.find(id);
			request.setAttribute("info", info);
			return appWebPath + "findcook-post";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
}
