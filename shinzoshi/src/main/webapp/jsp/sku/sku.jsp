<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="skuDg" title="货品列表" 
       data-options="singleSelect:false,fit:true,fitColumns:true,collapsible:true,pagination:true,url:'sku/findAll',method:'get',toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'sku',width:60">货品编码</th>
            <th data-options="field:'name',width:80">货品名称</th>
            <th data-options="field:'category',width:80">货品类型</th>
            <th data-options="field:'weight',width:100">重量(kg)</th>
            <th data-options="field:'retailprice',width:60">零售价</th>
            <th data-options="field:'purchaseprice',width:60">采购价</th>
            <th data-options="field:'storerkey',width:60">货主编码</th>
            <th data-options="field:'comment',width:200">备注</th>
        </tr>
    </thead>
</table>

<div id="skuEditWindow" class="easyui-window" title="编辑" data-options="modal:true,closed:true,iconCls:'icon-save',href:'sku/toedit'" style="width:46%;height:60%;padding:10px;"></div>
<div id="skuAddWindow" class="easyui-window" title="新增" data-options="modal:true,closed:true,iconCls:'icon-save',href:'sku/toinsert'" style="width:46%;height:60%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var skuId = $("#skuDg");
    	var sels = skuId.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].sku);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	var skuAddwindows = $("#skuAddWindow").window({
        		onLoad :function(){
        			var skuAddForm = skuAddwindows.find('form');
	                var skuAdd = skuAddForm.find('input[name=storerkey]');
        			//加载货主
        			skuAdd.combobox({
                         url : "sku/findStores",
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
        	
        	var skuEditwindows = $("#skuEditWindow").window({
        		onLoad :function(){
        			var skuEditForm = skuEditwindows.find('form');
	                var skuEdit = skuEditForm.find('input[name=storerkey]');
        			//回显数据
        			var data = $("#skuDg").datagrid("getSelections")[0];
        			//加载货主,并回显
        			skuEdit.combobox({
                         url : "sku/findStores",
                         valueField : 'storerkey',
                         textField : 'company',
                         multiple : false,
                         editable : false,
                         panelHeight:110,
                         onLoadSuccess : function() {
                        	 skuEditForm.form('load', data );
                         }
                     });
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
                	$.post("sku/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#skuDg").datagrid("reload");
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
        	$("#skuDg").datagrid('clearChecked');
        }
    }];
</script>