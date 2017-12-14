<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>

<div id="storerAddDiv">
	<form id="storeAddForm" enctype="multipart/form-data"  method="post">
		<div>
			<span class="label">公司名称:</span>
			<span class="inputControl">
				<input class="textbox" type="text" name="company" style="width:200px" />

			</span>

		</div>
		<div>
			<span class="label">联系电话:</span>
			<span class="inputControl">
				<input class="textbox" type="text"  name="phone" />
			</span>
		</div>
		<div>
			<span class="label">地址:</span>
			<span class="inputControl">
				<input class="textbox" type="text"  name="address" style="width:200px" />
			</span>

		</div>
		<div>
			<span class="label">邮件:</span>
			<span class="inputControl">
				<input class="textbox" type="text"  name="email" style="width:200px" />
			</span>

		</div>
		
		<div>
			<span class="label">备注:</span>
			<span class="inputControl">
				<input class="textbox" type="text" name="comment" />

			</span>

		</div>
		
		<div class="operation">
			<a id="storerAddButton" onclick="storerAddCommit()"  iconCls="icon-edit" class="easyui-linkbutton">确定</a>
			<a id="storerAddButton" onclick="storerClear()"  iconCls="icon-edit" class="easyui-linkbutton">重置</a>
		</div>
	</form>
</div>
<script>
	function storerAddCommit() {
		$("#storeAddForm").form('submit',{
			url : 'storer/insert',
			success : function (data) {
				var result = $.parseJSON(data);
				if (result.status == 200) {
					$("#storerDg").datagrid('reload');
					$.messager.show({
						title: '提示',
						msg: '添加成功'
					});
					$("#storerDg").datagrid('clearChecked');
	                E3.closeCurrentWindow();
				} else {
					$.messager.alert('提示', '操作失败！', 'error');
				}
			}
		});
	}
	function storerClear(){
		$("#storeAddForm").find('input').val('');
	}
</script>