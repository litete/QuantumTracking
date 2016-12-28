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
import app.home.model.FindCookOrder;
import app.home.model.Veg;
import app.home.service.VegService;

@Controller
@RequestMapping("/veg")
public class VegController extends BaseController{
	
	private VegService thisService;
	private ExecuteResult executeResult = new ExecuteResult();
	private String viewPath = "App/Admin/Veg/";
	private String appWebPath = "AppWeb/";
	private String appPath = "Phone/";
	
	public VegService getThisService() {
		return thisService;
	}
	@Autowired
	public void setThisService(VegService thisService) {
		this.thisService = thisService;
	}
	
	@RequestMapping("/allAppWeb")
	public String showAllList_m(HttpServletRequest request){
		try {
			List<Veg> list = thisService.select();
			request.setAttribute("list", list);
			return appWebPath + "food";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("/all")
	public String showAllList(HttpServletRequest request){
		try {
			List<Veg> list = thisService.select();
			request.setAttribute("list", list);
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("/add")
	public String addVeg(HttpServletRequest request){
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
	public Object addVegInfo(@RequestParam("imageFile")MultipartFile imageFile,
			Veg vegMany,HttpServletRequest request){
		try {
			String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"images\\";
			String filename = imageFile.getOriginalFilename();
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
			vegMany.setImg(imgUrl);
			if(thisService.addVegInfo(vegMany) == 1)
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
			List<Veg> list = thisService.selectUrl(id);
			Veg vegInfo = list.get(0);
			String urls = vegInfo.getImg();
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
			Veg info = thisService.find(id);
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
	public Object update(@RequestParam("imageFile")MultipartFile imageFile,Veg info,
			HttpServletRequest request){
		try {
			String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"images\\";
			String filename = imageFile.getOriginalFilename();
			if(filename != "") {
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
	public String VegInfo_m(String id, HttpServletRequest request) {
		try {
			Veg info = thisService.find(id);
			request.setAttribute("info", info);
			return appWebPath + "food-post";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage",
					"信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	//地址：http://地址/FiveA/veg/allVeg.do?format=json
		@RequestMapping("/allVeg")
		public String showAllList_app(HttpServletRequest request,HttpServletResponse response){
			try {
				List<Veg> list = thisService.select();
				String format = request.getParameter("format");
				if ("json".equals(format)) {
					JsonArray array = new JsonArray();
					for (int i = 0; i < list.size(); i++) {
						JsonObject jo = new JsonObject();
						Veg veg = (Veg) list.get(i);
						int id = veg.getId();
						String veg_name = (String)veg.getName();
						String info = (String)veg.getInfo();
						int price = (int)veg.getPrice();
						String img = (String)veg.getImg();
						jo.addProperty("Id", id);
						jo.addProperty("Name", veg_name);
						jo.addProperty("Info", info);
						jo.addProperty("Price", price);
						jo.addProperty("Img", img);
						array.add(jo);
					}
					request.setAttribute("json", array.toString());
				}			
				return appPath + "json_veg";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
				return viewPath + "result";
			}
		}
}
