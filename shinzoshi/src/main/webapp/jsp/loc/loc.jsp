<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="locDg" title="库位列表" 
       data-options="singleSelect:false,fit:true,fitColumns:true,collapsible:true,pagination:true,url:'loc/findAll',method:'get',toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'loc',width:60">库位编码</th>
            <th data-options="field:'type',width:80">库位类型</th>
            <th data-options="field:'putawayzone',width:100">库位区域</th>
            <th data-options="field:'stacklimit',width:60">堆栈限制</th>
            <th data-options="field:'footprint',width:60">地面托盘数</th>
            <th data-options="field:'quantity',width:60">库存数量</th>
        </tr>
    </thead>
</table>

<div id="locEditWindow" class="easyui-window" title="编辑" data-options="modal:true,closed:true,iconCls:'icon-save',href:'loc/toedit'" style="width:46%;height:60%;padding:10px;"></div>
<div id="locAddWindow" class="easyui-window" title="新增" data-options="modal:true,closed:true,iconCls:'icon-save',href:'loc/toinsert'" style="width:46%;height:60%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var locId = $("#locDg");
    	var sels = locId.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].loc);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	var locAddwindows = $("#locAddWindow").window({
        		onLoad :function(){
        			var locAddForm = locAddwindows.find('form');
	                var locAdd = locAddForm.find('input[name=storerkey]');
        			//加载货主
        			locAdd.combobox({
                         url : "loc/findStores",
                         valueField : 'storerkey',
                         textField : 'company',
                         multiple : false,
                         editable : false,
                         panelHeight:110,
                         
                     });
        			
        		}
        	}).window("open");
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
        	
        	var locEditwindows = $("#locEditWindow").window({
        		onLoad :function(){
        			var locEditForm = locEditwindows.find('form');
        			//回显数据
        			var data = $("#locDg").datagrid("getSelections")[0];
        			locEditForm.form("load",data);
        			
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
                	$.post("loc/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#locDg").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'取消',
        iconCls:'icon-undo',
        handler:function(){
        	$("#locDg").datagrid('clearChecked');
        }
    }];
</script>