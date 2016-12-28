<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="bjui-pageContent">
    <form action="<%=request.getContextPath()%>/findcook/update.do" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="id" value="${info.id}">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">套&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp餐：</label>
                            <input type="text" name="taocan" value="${info.taocan}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">用餐时间：</label>
                            <input type="text" name="eattime" value="${info.eattime}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">服务地址：</label>
                            <input type="text" name="address" value="${info.address}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">客户姓名：</label>
                            <input type="text" name="name" value="${info.name}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">客户电话：</label>
                            <input type="text" name="username" value="${info.phonenum}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注：</label>
                            <input type="text" name="username" value="${info.beizhu}" size="60">
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