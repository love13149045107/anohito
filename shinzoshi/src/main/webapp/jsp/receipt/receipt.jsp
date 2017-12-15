<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="receiptDg" title="收货单列表" 
       data-options="singleSelect:false,fit:true,fitColumns:true,collapsible:true,pagination:true,url:'receipt/findAll',method:'get',toolbar:toolbar,onLoadSuccess:function(data) {
                    $('.receipt_take').linkbutton({text: '收货', plain: true, iconCls: 'icon-add'});
            }">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'storerkey',width:40">货主编码</th>
            <th data-options="field:'company',width:30">供应商</th>
            <th data-options="field:'phone',width:50">供应商联系电话</th>
            <th data-options="field:'address',width:100">地址</th>
            <th data-options="field:'type',width:30">收货单类型</th>
            <th data-options="field:'status',width:60">状态</th>
            <th data-options="field:'comment',width:100">备注</th>
            <th data-options="field:'handle',width:30,formatter:function(value,row,index){
            		if(row.status == '已收货'){
            			return '';
            		}
                    var storerkey = row.storerkey;
                    return '<a  onclick=receiptTake(\''+storerkey+'\')  class=\'receipt_take\'></a>';
                }">操做</th>
        </tr>
    </thead>
</table>

<div id="receiptAddWindow" class="easyui-window" title="新增" data-options="modal:true,closed:true,iconCls:'icon-save',href:'receipt/toinsert'" style="width:46%;height:60%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var receiptId = $("#receiptDg");
    	var sels = receiptId.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].receipt);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	var receiptAddwindows = $("#receiptAddWindow").window("open");
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
                	$.post("receipt/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#receiptDg").datagrid("reload");
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
        	$("#receiptDg").datagrid('clearChecked');
        }
    }];
    function receiptTake(data){
    	alert(data);
    }
</script>