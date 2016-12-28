<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="bjui-pageContent">
    <form action="<%=request.getContextPath()%>/vegorder/update.do" data-toggle="validate" data-reload-navtab="true">
        <input type="hidden" name="id" value="${info.id}">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">蔬菜名称：</label>
                            <input type="text" name="vegname" value="${info.vegname}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">蔬菜数量：</label>
                            <input type="text" name="vegnum" value="${info.vegnum}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">蔬菜单价：</label>
                            <input type="text" name="vegprice" value="${info.vegprice}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">客户姓名：</label>
                            <input type="text" name="shouname" value="${info.shouname}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">客户电话：</label>
                            <input type="text" name="shounumber" value="${info.shounumber}" size="60">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label class="control-label x100">客户地址：</label>
                            <input type="text" name="shouaddress" value="${info.shouaddress}" size="60">
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