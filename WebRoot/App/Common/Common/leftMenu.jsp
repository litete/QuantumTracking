<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="bjui-leftside">
    <div id="bjui-sidebar-s">
        <div class="collapse"></div>
    </div>
    <div id="bjui-sidebar">
        <div class="toggleCollapse"><h2><i class="fa fa-bars"></i> 导航栏 <i class="fa fa-bars"></i></h2><a href="javascript:;" class="lock"><i class="fa fa-lock"></i></a></div>
        <div class="panel-group panel-main" data-toggle="accordion" id="bjui-accordionmenu" data-heightbox="#bjui-sidebar" data-offsety="26">
            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse4" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;系统管理</a></h4>
                </div>
                <div id="bjui-collapse4" class="panel-collapse panelContent collapse">
                    <div class="panel-body" >
                        <ul id="bjui-tree4" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        	<li data-id="user" data-pid="0">权限管理</li>
                            <li data-id="user_0" data-pid="user" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="user_0" data-fresh="true" data-reloadWarn="true">用户列表</li>
                            <li data-id="user_1" data-pid="user" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="user_1" data-fresh="true" data-reloadWarn="true">角色管理</li>
                        	<li data-id="user_2" data-pid="user" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="user_2" data-fresh="true" data-reloadWarn="true">节点管理</li>
                        	<%-- <li data-id="system" data-pid="0">系统设置</li>
                            <li data-id="system_0" data-pid="system" data-url="<%=request.getContextPath()%>/Config/index.do" data-tabid="system_0" data-fresh="true" data-reloadWarn="true">基础配置</li>
                        	<li data-id="system_2" data-pid="system" data-url="<%=request.getContextPath()%>/user/index.do" data-tabid="system_2" data-fresh="true" data-reloadWarn="true">导航管理</li>
                        --%> </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse2" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;订单管理</a></h4>
                </div>
                <div id="bjui-collapse2" class="panel-collapse panelContent collapse">
                    <div class="panel-body" >
                        <ul id="bjui-tree2" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        	<li data-id="user" data-pid="0">厨师订单</li>
                            <li data-id="user_0" data-pid="user" data-url="<%=request.getContextPath()%>/findcook/all.do" data-tabid="user_0" data-fresh="true" data-reloadWarn="true">全部订单</li>
                            <li data-id="user_1" data-pid="user" data-url="<%=request.getContextPath()%>/findcook/notsure.do" data-tabid="user_1" data-fresh="true" data-reloadWarn="true">未确认订单</li>
                            <li data-id="user_1" data-pid="user" data-url="<%=request.getContextPath()%>/findcook/notfinish.do" data-tabid="user_2" data-fresh="true" data-reloadWarn="true">未完成订单</li>
                            <li data-id="user_1" data-pid="user" data-url="<%=request.getContextPath()%>/findcook/yesfinish.do" data-tabid="user_3" data-fresh="true" data-reloadWarn="true">已完成订单</li>
                        	<li data-id="archives" data-pid="0">蔬菜订单</li>
                            <li data-id="archives_0" data-pid="archives" data-url="<%=request.getContextPath()%>/vegorder/all.do" data-tabid="archives_0" data-fresh="true" data-reloadWarn="true">全部订单</li>
                            <li data-id="archives_1" data-pid="archives" data-url="<%=request.getContextPath()%>/vegorder/notsure.do" data-tabid="archives_1" data-fresh="true" data-reloadWarn="true">未确认订单</li>
                        	<li data-id="archives_2" data-pid="archives" data-url="<%=request.getContextPath()%>/vegorder/notfinish.do" data-tabid="archives_2" data-fresh="true" data-reloadWarn="true">未完成订单</li>
                        	<li data-id="archives_3" data-pid="archives" data-url="<%=request.getContextPath()%>/vegorder/yesfinish.do" data-tabid="archives_3" data-fresh="true" data-reloadWarn="true">已完成订单</li>
                        </ul>
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
            
             <div class="panel panel-default">
                <div class="panel-heading panelContent">
                    <h4 class="panel-title"><a data-toggle="collapse" data-parent="#bjui-accordionmenu" href="#bjui-collapse3" class=""><i class="fa fa-caret-square-o-down"></i>&nbsp;展示管理</a></h4>
                </div>
                <div id="bjui-collapse3" class="panel-collapse panelContent collapse">
                    <div class="panel-body" >
                        <ul id="bjui-tree3" class="ztree ztree_main" data-toggle="ztree" data-on-click="MainMenuClick" data-expand-all="true">
                        	<li data-id="notice" data-pid="0">蔬菜信息</li>
                        	<li data-id="notice_0" data-pid="notice" data-url="<%=request.getContextPath()%>/veg/all.do" data-tabid="notice_0" data-fresh="true" data-reloadWarn="true">全部蔬菜</li>
                            <li data-id="notice_1" data-pid="notice" data-url="<%=request.getContextPath()%>/veg/add.do" data-tabid="notice_1" data-fresh="true" data-reloadWarn="true">新增蔬菜</li>
                        	<li data-id="archives" data-pid="0">厨师信息</li>
                            <li data-id="archives_0" data-pid="archives" data-url="<%=request.getContextPath()%>/cook/all.do" data-tabid="archives_0" data-fresh="true" data-reloadWarn="true">全部厨师</li>
                            <li data-id="archives_1" data-pid="archives" data-url="<%=request.getContextPath()%>/cook/add.do" data-tabid="archives_1" data-fresh="true" data-reloadWarn="true">新增厨师</li>
                        </ul>     	
                    </div>
                </div>
                <div class="panelFooter"><div class="panelFooterContent"></div></div>
            </div>
        </div>
    </div>
</div>