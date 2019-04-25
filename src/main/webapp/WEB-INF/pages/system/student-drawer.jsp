<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 侧边栏 -->
<div class="mdui-drawer" id="content-drawer">

    <ul class="mdui-list" mdui-collapse="{accordion: true}">

        <li class="mdui-list-item mdui-ripple">

            <i class="mdui-list-item-icon mdui-icon material-icons">&#xe0d8;</i>
            <div class="mdui-list-item-content" onclick="view('main')">系统公告</div>
        </li>

        <li class="mdui-collapse-item mdui-collapse-item-open">
            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <i class="mdui-list-item-icon mdui-icon material-icons">&#xe853;</i>
                <div class="mdui-list-item-content">我的账户</div>
                <i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>
            </div>
            <ul class="mdui-collapse-item-body mdui-list mdui-list-dense">
                <li class="mdui-list-item mdui-ripple" onclick="view('key');">缺勤记录</li>
                <li class="mdui-list-item mdui-ripple" onclick="view('topup');">上报工单</li>
                <li class="mdui-list-item mdui-ripple" onclick="view('OSPwd');">修改密码</li>
            </ul>
        </li>

      

        <li class="mdui-list-item mdui-ripple">
            <i class="mdui-list-item-icon mdui-icon material-icons">dashboard</i>
            <div class="mdui-list-item-content" onclick="view('about');">关于本系统</div>
        </li>

    </ul>

</div>