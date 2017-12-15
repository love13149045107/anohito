<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>

<div id="locEditDiv">
	<form id="locEditForm"  method="post" >
		<div>
			<span class="label">库位类型:</span>
			<span class="inputControl">
				<select  class="easyui-combobox" name="type" style="width:150px;" >  
				    <option value="OTHER">OTHER</option>
					<option value="CASE">CASE</option>
					<option value="PICK">PICK</option>
					<option value="STAGE">STAGE</option>
				</select> 
			</span>

		</div>
		<div>
			<span class="label">库位区域:</span>
			<span class="inputControl">
				<input class="textbox" type="text" name="putawayzone"  />

			</span>

		</div>
		<div>
			<span class="label">堆栈限制:</span>
			<span class="inputControl">
				<input class="textbox" type="text"  name="stacklimit" />
			</span>
		</div>
		<div>
			<span class="label">地面托盘数:</span>
			<span class="inputControl">
				<input  class="textbox" name="footprint"  />
			</span>

		</div>
		<div>
			<span class="label">库存数量:</span>
			<span class="inputControl">
				<input  class="textbox" name="quantity"  />
			</span>

		</div>
		
		<div class="operation">
			<a id="locEditButton" onclick="locEditCommit()"  iconCls="icon-edit" class="easyui-linkbutton">确定</a>
		</div>
	</form>
</div>
<script>
	function locEditCommit() {
		$("#locEditForm").form('submit',{
			url : 'loc/edit',
			success : function (data) {
				var result = $.parseJSON(data);
				if (result.status == 200) {
					$("#locDg").datagrid('reload');
					$.messager.show({
						title: '提示',
						msg: '编辑成功'
					});
					$("#locDg").datagrid('clearChecked');
	                E3.closeCurrentWindow();
				} else {
					$.messager.alert('提示', '操作失败！', 'error');
				}
			}
		});
	}
</script>