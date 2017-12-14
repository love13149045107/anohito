<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="storerDg" title="货主列表" 
       data-options="singleSelect:false,fit:true,fitColumns:true,collapsible:true,pagination:true,url:'/storer/findAll',method:'get',toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'storerkey',width:60">货主编码</th>
            <th data-options="field:'company',width:80">公司名称</th>
            <th data-options="field:'phone',width:80">联系电话</th>
            <th data-options="field:'address',width:100">地址</th>
            <th data-options="field:'email',width:60">邮件</th>
            <th data-options="field:'comment',width:200">备注</th>
        </tr>
    </thead>
</table>

<div id="storerEditWindow" class="easyui-window" title="编辑" data-options="modal:true,closed:true,iconCls:'icon-save',href:'storer/toedit'" style="width:46%;height:50%;padding:10px;"></div>
<div id="storerAddWindow" class="easyui-window" title="新增" data-options="modal:true,closed:true,iconCls:'icon-save',href:'storer/toinsert'" style="width:46%;height:50%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var storerId = $("#storerDg");
    	var sels = storerId.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].storerkey);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#storerAddWindow").window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	
        	$("#storerEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#storerDg").datagrid("getSelections")[0];
        			$("#storeEditForm").form("load",data);
        			
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("storer/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#storerDg").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>