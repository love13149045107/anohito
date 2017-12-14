<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>

<div id="skuAddDiv">
	<form id="skuAddForm"  method="post">
		<div>
			<span class="label">货品名字:</span>
			<span class="inputControl">
				<input class="textbox" type="text" name="name" style="width:200px" />

			</span>

		</div>
		<div>
			<span class="label">货品类型:</span>
			<span class="inputControl">
				<input class="textbox" type="text"  name="category" />
			</span>
		</div>
		<div>
			<span class="label">重量:</span>
			<span class="inputControl">
				<input class="easyui-numberbox" data-options="min:0,precision:2"  name="weight"  />
			</span>

		</div>
		<div>
			<span class="label">零售价:</span>
			<span class="inputControl">
				<input class="easyui-numberbox" data-options="min:0,precision:2"  type="text"  name="retailprice" />
			</span>

		</div>
		<div>
			<span class="label">采购价:</span>
			<span class="inputControl">
				<input class="easyui-numberbox" data-options="min:0,precision:2"  name="purchaseprice" />
			</span>

		</div>
		<div>
			<span class="label">货主:</span>
			<span class="inputControl">
				<input name="storerkey" />
			</span>

		</div>
		<div>
			<span class="label">描述:</span>
			<span class="inputControl">
				<input class="textbox" type="text" name="comment" />

			</span>

		</div>
		
		<div class="operation">
			<a id="skuAddButton" onclick="skuAddCommit()"  iconCls="icon-edit" class="easyui-linkbutton">确定</a>
			<a id="skuAddButton" onclick="skuClear()"  iconCls="icon-edit" class="easyui-linkbutton">重置</a>
		</div>
	</form>
</div>
<script>
	function skuAddCommit() {
		$("#skuAddForm").form('submit',{
			url : 'sku/insert',
			success : function (data) {
				var result = $.parseJSON(data);
				if (result.status == 200) {
					$("#skuDg").datagrid('reload');
					$.messager.show({
						title: '提示',
						msg: '添加成功'
					});
					$("#skuDg").datagrid('clearChecked');
	                E3.closeCurrentWindow();
				} else {
					$.messager.alert('提示', '操作失败！', 'error');
				}
			}
		});
	}
	function skuClear(){
		$("#skuAddForm").find('input').val('');
	}
</script>