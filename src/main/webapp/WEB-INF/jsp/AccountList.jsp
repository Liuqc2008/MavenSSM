<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" import="java.util.*"%>
 
<!DOCTYPE html>
<html>
<head>
  	<meta charset="utf-8">
  	<title>form</title>
  	<meta name="renderer" content="webkit">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
  	<script type="text/javascript" src="Resource/Script/jquery-3.3.1.min.js"></script>
  	<script type="text/javascript" src="Resource/Script/layui/layui.js"></script>
	<link href="Resource/Script/layui/css/layui.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="height:20px;"></div>
	<div class="demoTable">
  		用户名：
	  	<div class="layui-inline">
	    	<input class="layui-input" name="name" id="name" autocomplete="off">
	  	</div>
	  	密码：
	  	<div class="layui-inline">
	    	<input class="layui-input" name="password" id="password" autocomplete="off">
	  	</div>
	  	创建时间:
	  	<div class="layui-inline">
            <input type="text" class="layui-input" name="startTime" id="startTime" placeholder="yyyy-MM-dd">
        </div>
        <div class="layui-inline">
        	<input type="text" class="layui-input" name="endTime" id="endTime" placeholder="yyyy-MM-dd">
	  	</div>
  		<button class="layui-btn" data-type="reload">搜索</button>
	</div>

	<table class="layui-hide" id="test"></table>
                   
	<script>
	layui.use(['layer', 'element', 'form', 'table', 'laydate'], function(){
	  	var table = layui.table,
	  		layer = layui.layer,
        	form = layui.form,
        	element = layui.element,
        	laydate = layui.laydate;;
	  
  		table.render({
	    	elem: '#test',
	    	url:'/MavenSSM/Common/AccountList',
	    	cols: [[
	      		{field:'id', width:80, title: 'ID', align: 'center', sort: true},
	      		{field:'name', width:130, align: 'center', title: '用户名'},
	      		{field:'password', width:130, align: 'center', title: '密码'},
	      		{field:'createDate', width:180, align: 'center', title: '时间'},
	    	]],
	    	id: 'testReload',
	    	page: true,
	    	height: 'full-200',
	  	});
        
  		var $ = layui.$, active = {
  			reload: function(){

 			 	table.reload('testReload', {
  			      	page: {
  			          curr: 1 //重新从第 1 页开始
  			        },
  			        where: {
  			          	key: {
  			          		name: $('#name').val(),
  			          		password: $('#password').val(),
  			          		startTime: $('#startTime').val(),
  			          		endTime: $('#endTime').val(),
  			          	}
  			        }
  			   	});
  			},
  		};
  			 
  		var start = laydate.render({
            elem: '#startTime',
            done: function (value, date, endDate) {
                end.config.min = {
                    year: date.year,
                    month: date.month - 1,
                    date: date.date,
                }
            }
        });

        var end = laydate.render({
            elem: '#endTime',
            done: function (value, date, endDate) {
                start.config.max = {
                    year: date.year,
                    month: date.month - 1,
                    date: date.date,
                }
            }
        });
  		
  		$('.demoTable .layui-btn').on('click', function(){
  			var type = $(this).data('type');
  			active[type] ? active[type].call(this) : '';
  		});
	});
	</script>

</body>
</html>


 
 