<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<script src="Public/Js/uploadPreview.js"></script>
</head>
<div class="bjui-pageContent">
	<form action="<%=request.getContextPath()%>/cook/update.do"
		data-toggle="validate" data-reload-navtab="true" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${info.id}">
		<div class="pageFormContent" data-layout-h="0">
			<table class="table table-condensed table-hover" width="100%">
				<tbody>
					<tr>
						<td colspan="2"><label class="control-label x100">名&nbsp&nbsp称：</label>
							<input type="text" name="cook_name" size="60" value="${info.cook_name}"/></td>
					</tr>
					<tr>
						<td colspan="2"><label class="control-label x100">说&nbsp&nbsp明：</label>
							<textarea rows="5" cols="60" name="info" placeholder="套餐相关说明" >${info.info}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2"><label class="control-label x100">价&nbsp&nbsp格：</label>
							<input type="number" name="price" size="60" value="${info.price}"/></td>
					</tr>
					<tr>
						<td colspan="2"><label class="control-label x100">提供酒店：</label>
							<input type="text" name="from_gs" size="60" value="${info.from_gs}"/></td>
					</tr>
					<tr>
						<td colspan="2"><label class="control-label x100">图&nbsp&nbsp片：</label>
							<div id="warp" style="display: inline-block; vertical-align: middle;">
								<div>
									<img id="imgShow_WU_FILE_0" width="100" height="100" src="${info.img}" />
									<input type="file" name="imageFile" id="up_img_WU_FILE_0" /> 
									<input type="hidden" name="imgold" value="${info.img}">
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</div>

<div class="bjui-pageFooter">
	<ul>
		<li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
		<li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
	</ul>
</div>